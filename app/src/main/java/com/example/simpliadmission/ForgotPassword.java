package com.example.simpliadmission;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {

    private EditText emailEditText;
    private LottieAnimationView progressBar ;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        emailEditText = (EditText) findViewById(R.id.email);
        Button resetPasswordButton = (Button) findViewById(R.id.resetpassword);
        progressBar = (LottieAnimationView) findViewById(R.id.progressBar2);

        auth = FirebaseAuth.getInstance();

        resetPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetPassword();
            }
        });
    }
        private void resetPassword(){
            String email = emailEditText.getText().toString().trim();

            if(email.isEmpty()){
                emailEditText.setError("Email is required");
                emailEditText.requestFocus();
                return;
            }
            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                emailEditText.setError("Please provide a valid email!");
                emailEditText.requestFocus();
                return;
            }
            progressBar.setVisibility(View.VISIBLE);

            auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(ForgotPassword.this, "Please check your email to reset the password", Toast.LENGTH_LONG).show();
                        Intent i3 = new Intent(ForgotPassword.this, LoginPage.class);
                        startActivity(i3);
                    }
                    else{
                        Toast.makeText(ForgotPassword.this, "Something went wrong, Try again!", Toast.LENGTH_LONG).show();
                    }
                    progressBar.setVisibility(View.INVISIBLE);
                }

            });
        }

}

