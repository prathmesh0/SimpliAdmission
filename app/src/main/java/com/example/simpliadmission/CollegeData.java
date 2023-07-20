package com.example.simpliadmission;
//

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class CollegeData extends AppCompatActivity {

    private static final int REQUEST_CALL = 1;
    TextView website;
    LottieAnimationView progressBar;
    TextView t1, t2, t3, t4, t5, t6, t7, t8, t9;
    ImageView t10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collegedata);
        progressBar = (LottieAnimationView) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        t1 = (TextView) findViewById(R.id.college_name);
        t2 = (TextView) findViewById(R.id.emailholder);
        t3 = (TextView) findViewById(R.id.fee);
        t4 = (TextView) findViewById(R.id.courses);
        t5 = (TextView) findViewById(R.id.type);
        t6 = (TextView) findViewById(R.id.address);
        t7 = (TextView) findViewById(R.id.estd);
        t8 = (TextView) findViewById(R.id.phone);
        t9 = (TextView) findViewById(R.id.website);
        t10 = (ImageView) findViewById(R.id.clg_bg);

        t1.setText(getIntent().getStringExtra("dataName").toString());
        t2.setText(getIntent().getStringExtra("dataEmail").toString());
        t3.setText(getIntent().getStringExtra("dataFee").toString());
        t4.setText(getIntent().getStringExtra("dataCourses").toString());
        t5.setText(getIntent().getStringExtra("dataType").toString());
//        t6.setText(getIntent().getStringExtra("dataAddress").toString());
        t7.setText(getIntent().getStringExtra("dataEstd").toString());
        t8.setText(getIntent().getStringExtra("dataPhone").toString());
        t9.setText(getIntent().getStringExtra("dataWebsite").toString());



                t6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gotoMap(getIntent().getStringExtra("dataName").toString() + ", " + getIntent().getStringExtra("dataAddress").toString());
                    }
                });
        Target target = new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                t10.setImageBitmap(bitmap);
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onBitmapFailed(Exception e, Drawable errorDrawable) {
                progressBar.setVisibility(View.GONE);
                t1.setBackgroundColor(Color.TRANSPARENT);
                Toast.makeText(CollegeData.this, "Failed to load image", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {
                progressBar.setVisibility(View.VISIBLE);
            }
        };
        Picasso.get().load(getIntent().getStringExtra("dataBg").toString()).into(target);

        t9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl(t9.getText().toString().trim());
            }
        });
        SpannableStringBuilder builder = new SpannableStringBuilder();

        String address = getIntent().getStringExtra("dataAddress").toString();
        SpannableString blackSpannable= new SpannableString(address);
        blackSpannable.setSpan(new ForegroundColorSpan(Color.BLACK), 0, address.length(), 0);
        builder.append(blackSpannable);

        String blue = "\nshow in map";
        SpannableString blueSpannable = new SpannableString(blue);
        blueSpannable.setSpan(new ForegroundColorSpan(Color.BLUE), 0, blue.length(), 0);
        builder.append(blueSpannable);

        t6.setText(builder, TextView.BufferType.SPANNABLE);

        Button call_button = findViewById(R.id.call_button);
        call_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallButton();
            }
        });

    }
    private void gotoMap(String s){
        String uri = "http://maps.google.com/maps?q=" + s;
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(intent);
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