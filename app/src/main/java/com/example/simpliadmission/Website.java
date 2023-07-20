package com.example.simpliadmission;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Website extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website);

        TextView link1 = (TextView) findViewById(R.id.link1);
        link1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://cetcell.mahacet.org/");
            }
        });
        TextView link2 = (TextView) findViewById(R.id.link2);
        link2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://nta.ac.in/Engineeringexam");
            }
        });
        TextView link3 = (TextView) findViewById(R.id.link3);
        link3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://jeemain.nta.nic.in/");
            }
        });
        TextView link4 = (TextView) findViewById(R.id.link4);
        link4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://bit.ly/3IZ7Ma5");
            }
        });
        TextView link5 = (TextView) findViewById(R.id.link5);
        link5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://bit.ly/3ku9C9K");
            }
        });
        TextView link6 = (TextView) findViewById(R.id.link6);
        link6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://bit.ly/3SHrPNI");
            }
        });
        TextView link7 = (TextView) findViewById(R.id.link7);
        link7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://bit.ly/3ZsMJ55");
            }
        });
        TextView link8 = (TextView) findViewById(R.id.link8);
        link8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://bit.ly/3J4v4eA");
            }
        });
        TextView link9 = (TextView) findViewById(R.id.link9);
        link9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://bit.ly/3JdkstY");
            }
        });
        TextView link10 = (TextView) findViewById(R.id.link10);
        link10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://bit.ly/3kQHZYr");
            }
        });
        TextView link11 = (TextView) findViewById(R.id.link11);
        link11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://aicte-india.org/");
            }
        });
        TextView link12 = (TextView) findViewById(R.id.link12);
        link12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.jeeadv.ac.in/");
            }
        });
        TextView link13 = (TextView) findViewById(R.id.link13);
        link13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://mahadbt.maharashtra.gov.in/Home/Index");
            }
        });

    }
    private void gotoUrl(String s){
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
}