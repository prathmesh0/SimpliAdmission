package com.example.simpliadmission;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class MainActivity extends LoginPage {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users");
        assert user != null;
        String userID = user.getUid();

        final TextView fnameTextView = (TextView) findViewById(R.id.welcometxt);
        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile = snapshot.getValue(User.class);

                if (userProfile != null) {
                    String fname = userProfile.fname;

                    fnameTextView.setText("Welcome, " + fname);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this, "Username error", Toast.LENGTH_SHORT).show();
            }

        });

        TextView cutoff = (TextView) findViewById(R.id.cutoff_txt);
        cutoff.setText("Cut off\nLists");

        ImageView Profile = (ImageView) findViewById(R.id.UserProf);
        Profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(MainActivity.this, UserProfile.class);
                startActivity(i2);
            }
        });
        LinearLayout Compare = (LinearLayout) findViewById(R.id.compare);
        Compare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent compare = new Intent(MainActivity.this, Compare.class);
                startActivity(compare);
            }
        });
        LinearLayout AbUs = (LinearLayout) findViewById(R.id.AboutUs);
        AbUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aboutus = new Intent(MainActivity.this, AboutUs.class);
                startActivity(aboutus);
            }
        });
        LinearLayout Cutoff = (LinearLayout) findViewById(R.id.cutoff);
        Cutoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cutoff = new Intent(MainActivity.this, CutOff.class);
                startActivity(cutoff);
            }
        });
        LinearLayout S = (LinearLayout) findViewById(R.id.scholarship);
        S.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent scholarship = new Intent(MainActivity.this, Scholarship.class);
                startActivity(scholarship);
            }
        });
        LinearLayout steps = (LinearLayout) findViewById(R.id.steps);
        steps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent steps = new Intent(MainActivity.this, Steps.class);
                startActivity(steps);
            }
        });
        LinearLayout College = (LinearLayout) findViewById(R.id.College);
        College.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4 = new Intent(MainActivity.this, College.class);
                startActivity(i4);
            }
        });

        LinearLayout Faq = (LinearLayout) findViewById(R.id.faq);
        Faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(MainActivity.this, faq.class);
                startActivity(i3);
            }
        });
        LinearLayout website = (LinearLayout) findViewById(R.id.website);
        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent website = new Intent(MainActivity.this, Website.class);
                startActivity(website);
            }
        });

        LinearLayout chatBot = (LinearLayout) findViewById(R.id.chatbot);
        chatBot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chatBot = new Intent(MainActivity.this, ChatBot.class);
                startActivity(chatBot);
            }
        });

        LinearLayout Predict = (LinearLayout) findViewById(R.id.Prediction);
        Predict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent predict = new Intent(MainActivity.this, Predict.class);
                startActivity(predict);
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}