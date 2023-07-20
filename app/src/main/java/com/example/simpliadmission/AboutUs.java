package com.example.simpliadmission;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class AboutUs extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        TextView undertext = (TextView) findViewById(R.id.undertext);
        undertext.setText("SimpliAdmission");

        TextView t1 = (TextView) findViewById(R.id.t1);
        t1.setText("\b\b\b\bSimpliAdmission is a one-stop-solution making course and college selection easy for students looking to pursue undergraduate UG courses in India accessible to users through Mobile Application. Our Application is a repository of reliable and authentic information for College affiliated by Mumbai University. We offer specific information for students interested in UG courses in India across the most popular educational streams of Engineering.");
        TextView t2 = (TextView) findViewById(R.id.t2);
        t2.setText("\b\b\b\bWe also cover the Basic Guidelines for the any students seeking to take admission in Engineering courses in a concise manner. We have introduced several student oriented products and tools like Top Colleges, College Compare,Scholarship details &amp; Eligibility ,My-shortlist(Favorites) ,FAQs section which covers some basic but important questions which are answered according to students perspective which will help them in decision making by easy access to detailed information on career choices.");

    }
}