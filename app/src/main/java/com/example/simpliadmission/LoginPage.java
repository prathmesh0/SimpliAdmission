package com.example.simpliadmission;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginPage extends AppCompatActivity {

    private EditText editTextEmail, editTextPassword;
    TextView forgotPassword;
    private FirebaseAuth mAuth;
    private LottieAnimationView progressBar, animationView;
//    Button HomePage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        TextView register = (TextView) findViewById(R.id.noaccount);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(LoginPage.this, SignupPage.class);
                startActivity(i1);
                Toast.makeText(LoginPage.this, "Register here", Toast.LENGTH_LONG).show();
            }
        });

        Button login = (Button) findViewById(R.id.login_button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLogin();
            }
        });

        editTextEmail = (EditText) findViewById(R.id.email_login);
        editTextPassword = (EditText) findViewById(R.id.password_login);

        progressBar = (LottieAnimationView) findViewById(R.id.progressBar1);
        animationView = (LottieAnimationView) findViewById(R.id.login_logo);

        mAuth = FirebaseAuth.getInstance();

        forgotPassword = (TextView) findViewById(R.id.fgpass);
        forgotPassword.setOnClickListener(this::OnClick);

    }


    public void OnClick(View v) {
        if (v.getId() == R.id.login_button) {
            userLogin();
        }
        if (v.getId() == R.id.fgpass) {
            startActivity(new Intent(this, ForgotPassword.class));
        }

    }

    private void userLogin() {
        String email_login = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (email_login.isEmpty()) {
            editTextEmail.setError("Email is required!");
            editTextEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email_login).matches()) {
            editTextEmail.setError("Enter a valid email address!");
            editTextEmail.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            editTextPassword.setError("Password is required!");
            editTextPassword.requestFocus();
            return;
        }
        if (password.length() < 6) {
            editTextPassword.setError("Invalid Password");
            editTextPassword.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        animationView.setVisibility(View.INVISIBLE);
        mAuth.signInWithEmailAndPassword(email_login, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    assert user != null;
                    if(user.isEmailVerified()){
                        startActivity(new Intent(LoginPage.this, MainActivity.class));
                    }
//                    else{
//                        user.sendEmailVerification();
//                        Toast.makeText(LoginPage.this, "Check your Email for verification" , Toast.LENGTH_LONG).show();
//                    }
                }
                else {
                    Toast.makeText(LoginPage.this, "Invalid credentials", Toast.LENGTH_LONG).show();
                }
                progressBar.setVisibility(View.GONE);
            }
        });
    }

    public void onBackPressed() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(LoginPage.this);
        alertDialog.setTitle("Exit App");
        alertDialog.setMessage("Do you want to exit app?");
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishAffinity();
            }
        });
        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialog.show();
    }
}