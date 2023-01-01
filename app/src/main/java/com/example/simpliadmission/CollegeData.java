package com.example.simpliadmission;
//

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CollegeData extends AppCompatActivity {

    private static final int REQUEST_CALL = 1;
    TextView website;

    TextView t1, t2, t3, t4, t5, t6, t7, t8, t9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collegedata);

        t1 = (TextView) findViewById(R.id.college_name);
        t2 = (TextView) findViewById(R.id.emailholder);
        t3 = (TextView) findViewById(R.id.fee);
        t4 = (TextView) findViewById(R.id.courses);
        t5 = (TextView) findViewById(R.id.type);
        t6 = (TextView) findViewById(R.id.address);
        t7 = (TextView) findViewById(R.id.estd);
        t8 = (TextView) findViewById(R.id.phone);
        t9 = (TextView) findViewById(R.id.website);
//
        t1.setText(getIntent().getStringExtra("dataName").toString());
        t2.setText(getIntent().getStringExtra("dataEmail").toString());
        t3.setText(getIntent().getStringExtra("dataFee").toString());
        t4.setText(getIntent().getStringExtra("dataCourses").toString());
        t5.setText(getIntent().getStringExtra("dataType").toString());
        t6.setText(getIntent().getStringExtra("dataAddress").toString());
        t7.setText(getIntent().getStringExtra("dataEstd").toString());
        t8.setText(getIntent().getStringExtra("dataPhone").toString());
        t9.setText(getIntent().getStringExtra("dataWebsite").toString());

        t9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl(t9.getText().toString().trim());
            }
        });


        Button call_button = findViewById(R.id.call_button);
        call_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallButton();
            }
        });

    }
    private void gotoUrl(String s){
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }

    private void CallButton() {
        String number = t8.getText().toString();
        if (number.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(CollegeData.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(CollegeData.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                CallButton();
            } else {
                Toast.makeText(this, "Permission denied!", Toast.LENGTH_SHORT).show();
            }

        }
    }
}