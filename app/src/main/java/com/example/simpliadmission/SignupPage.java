package com.example.simpliadmission;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieImageAsset;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class SignupPage extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextfname, editTextlname, editTextemail_signup, editTextpassword_signup, editTextrepassword;
    TextView haveAccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);

        TextView register = findViewById(R.id.register);
        register.setOnClickListener(this);

        TextView reg = findViewById((R.id.signup_button));
        reg.setOnClickListener(this);

        editTextfname = findViewById(R.id.fname);
        editTextlname = findViewById(R.id.lname);
        editTextemail_signup = findViewById(R.id.email_signup);
        editTextpassword_signup = findViewById(R.id.password_signup);
        editTextrepassword = findViewById(R.id.repassword);

        haveAccount= findViewById(R.id.haveaccount);
        haveAccount.setOnClickListener(view -> {
            Intent login = new Intent(SignupPage.this, LoginPage.class);
            startActivity(login);
            Toast.makeText(SignupPage.this, "Enter Login details", Toast.LENGTH_SHORT).show();
        });



    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.signup_button) {
            registerUser();
        }
    }
    private void registerUser(){
        String email = editTextemail_signup.getText().toString().trim();
        String password = editTextpassword_signup.getText().toString().trim();
        String repassword = editTextrepassword.getText().toString().trim();
        String fname = editTextfname.getText().toString().trim();
        String lname = editTextlname.getText().toString().trim();


        if(fname.isEmpty()) {
            editTextfname.setError("Enter your first name");
            editTextfname.requestFocus();
            return;
        }
        if(lname.isEmpty()) {
            editTextlname.setError("Enter your last name");
            editTextlname.requestFocus();
            return;
        }
        if(email.isEmpty()) {
            editTextemail_signup.setError("Email is required!");
            editTextemail_signup.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextemail_signup.setError("Please provide a valid email!");
            editTextemail_signup.requestFocus();
            return;
        }
        if(password.isEmpty()){
            editTextpassword_signup.setError("Password is required");
            editTextpassword_signup.requestFocus();
            return;
        }
        if(password.length() < 6){
            editTextpassword_signup.setError("Password must be more than 6 characters");
            editTextpassword_signup.requestFocus();
            return;
        }
        if(repassword.isEmpty()){
            editTextrepassword.setError("Enter your password again");
            editTextrepassword.requestFocus();
            return;
        }
        if(!repassword.equals(password)){
            editTextrepassword.setError("Password not matching");
            editTextrepassword.requestFocus();
            return;
        }

        LottieAnimationView progressBar = (LottieAnimationView) findViewById(R.id.progressBar);
        LottieAnimationView animationView = (LottieAnimationView) findViewById(R.id.signup_logo);
        FirebaseAuth mAuth = FirebaseAuth.getInstance();

        progressBar.setVisibility(View.VISIBLE);
        animationView.setVisibility(View.INVISIBLE);
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if(task.isSuccessful()) {
                        User user = new User(fname, lname, email);
                        FirebaseUser verifyUser = FirebaseAuth.getInstance().getCurrentUser();

                        FirebaseDatabase.getInstance().getReference("Users")
                                .child(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid())
                                .setValue(user).addOnCompleteListener(task1 -> {
                                    if(task1.isSuccessful()){
                                        assert verifyUser != null;
                                        if(verifyUser.isEmailVerified()){
                                            Toast.makeText(this, "User already exits", Toast.LENGTH_SHORT).show();
                                        }else{
                                            verifyUser.sendEmailVerification();
                                            Toast.makeText(SignupPage.this, "Check your Email for verification" , Toast.LENGTH_LONG).show();
                                            Intent redirect = new Intent(SignupPage.this, LoginPage.class);
                                            startActivity(redirect);

                                        }
                                    }
                                    else{
                                        Toast.makeText(SignupPage.this, "Failed to registered,", Toast.LENGTH_LONG).show();
                                    }
                                    progressBar.setVisibility(View.GONE);
                                });


                    }else{
                        Toast.makeText(SignupPage.this, "Failed to registered,  Check if already registered", Toast.LENGTH_LONG).show();
                        progressBar.setVisibility(View.GONE);
                    }
                });
    }
}