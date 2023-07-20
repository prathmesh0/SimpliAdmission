package com.example.simpliadmission;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class faq extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        TextView q1 = (TextView) findViewById(R.id.q1);
        q1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                TextView ans1 = (TextView) findViewById(R.id.ans1);
                ans1.setText("One of the most frequently asked questions on college admissions is what kind of college is best suited for your requirements. Here, your college consultant already has a well-planned database of colleges. A good college consultant will already know which college is the best for a particular course. Remember to inform your consultant of your interests, hobbies, career plans and financial situation. This information helps your consultant to narrow down the list of colleges that are best suited for you. ");
                ans1.setVisibility(View.VISIBLE);
            }
        });
        TextView q2 = (TextView) findViewById(R.id.q2);
        q2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                TextView ans2 = (TextView) findViewById(R.id.ans2);
                ans2.setVisibility(View.VISIBLE);
            }
        });
        TextView q3 = (TextView) findViewById(R.id.q3);
        q3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                TextView ans3 = (TextView) findViewById(R.id.ans3);
                ans3.setText("One of the questions to ask about the college admission process is the eligibility or necessary qualifications for a student to seek admission in the college. Some colleges may have different admission procedures. It is better to clarify the procedure otherwise you may end up running from pillar to post at the last minute trying to fulfil all the criteria. Be sure to note down if the college has a separate entrance exam. If it does, ask the college administrator for a briefing on how to prepare for the same.");
                ans3.setVisibility(View.VISIBLE);
            }
        });
        TextView q4 = (TextView) findViewById(R.id.q4);
        q4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                TextView ans4 = (TextView) findViewById(R.id.ans4);
                ans4.setText("This is an important question to ask when choosing a college. Scholarships are aids that help students during their course of studying in a college. Scholarships can be monetary help like a reduction in fees or a discount on books. Find out different kind of scholarships available to students and what is the process and criteria for students to apply for a scholarship on our app.\n" +
                        "\n");
                ans4.setVisibility(View.VISIBLE);
            }
        });
        TextView q5 = (TextView) findViewById(R.id.q5);
        q5.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                TextView ans5 = (TextView) findViewById(R.id.ans5);
                ans5.setText("Ragging is a punishable offence in India. Still many of the colleges does not take any steps towards it , so be sure to ask the college representatives if anti ragging regulations are strictly adhered to on campus and what measures are taken to prevent any untoward incidents on campus. A healthy atmosphere on campus will ensure your holistic development as a student. ");
                ans5.setVisibility(View.VISIBLE);
            }
        });
        TextView q7 = (TextView) findViewById(R.id.q7);
        q7.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                TextView ans7 = (TextView) findViewById(R.id.ans7);
                ans7.setText("In India, we have two types of colleges, one, those offering degrees in many fields like arts, science, business including engineering and are generally known as universities, and the second, which offer degrees only in engineering and are generally known as Institutes. Universities that offer other degrees along with engineering named their engineering degree as B.E. (Bachelor of Engineering) and Institutes providing professional courses like engineering named their engineering degree as B. Tech. (Bachelor of Technology).");
                ans7.setVisibility(View.VISIBLE);
            }
        });
        TextView q15 = (TextView) findViewById(R.id.q15);
        q15.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                TextView ans15 = (TextView) findViewById(R.id.q15ans);
                ans15.setText("•\tPassport size photographs,\n" +
                        "•\tOriginal Leaving Certificate (If Duplicate Submit FIR Original Copy),\n" +
                        "•\tClass 10th Mark sheet,\n" +
                        "•\tClass 12th Mark sheet,\n" +
                        "•\tClass 10th Board Certificate,\n" +
                        "•\tClass 12th Board Certificate,\n" +
                        "•\tMHT-CET / Jee Main Entrance Exam Score Card,\n" +
                        "•\tDomicile Certificate,\n" +
                        "•\tCertificate of Indian Nationality,\n" +
                        "•\tcaste certificate,\n" +
                        "•\tNon-Creamy Layer Certificate,\n" +
                        "•\tCast Validity Certificate.\n" +
                        "•\tAadhaar Card,\n" +
                        "•\tIncome Certificate\n");
                ans15.setVisibility(View.VISIBLE);
            }
        });
    }

}