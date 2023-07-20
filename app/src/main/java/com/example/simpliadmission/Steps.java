package com.example.simpliadmission;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Steps extends AppCompatActivity {

    @SuppressLint({"SetTextI18n", "NewApi"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steps);
        RelativeLayout header = (RelativeLayout) findViewById(R.id.header_title);

        String mhtcet = "https://cetcell.mahacet.org/";

        TextView undertext = (TextView) findViewById(R.id.undertext);
        undertext.setText("Steps to fill application form\n\nMHT-CET\n"+mhtcet);
        undertext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl(mhtcet);
            }
        });

        int margin = (int) getResources().getDimension(R.dimen.popup_margin);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(margin, margin, margin, margin);

        TextView tview0 = (TextView) findViewById(R.id.tview0);
        tview0.setText("How to Fill MH CET Application Form\n" +
                        "Candidates should follow the following steps to fill the application form. Here, we have mentioned step by step procedure for How to Fill MH CET Application Form:" );
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        LayoutInflater inflater1 = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View popupView1 = inflater1.inflate(R.layout.popup_layout, null);
        PopupWindow popupWindow1 = new PopupWindow(popupView1, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow1.setOutsideTouchable(true);
        popupWindow1.setFocusable(true);
        popupWindow1.setElevation(10);
        popupWindow1.setAnimationStyle(R.anim.popup_animation);

        popupView1.setLayoutParams(params);

        TextView tview1 = (TextView) findViewById(R.id.tview1);
        tview1.setText("Step-1: Online Registration\n");
        tview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow1.showAtLocation(header, Gravity.CENTER , 0, 0 );
            }
        });
//        --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        LayoutInflater inflater2 = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View popupView2 = inflater2.inflate(R.layout.popup_layout2, null);
        PopupWindow popupWindow2 = new PopupWindow(popupView2, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow2.setFocusable(true);
        popupWindow2.setAnimationStyle(R.anim.popup_animation);
        popupView2.setLayoutParams(params);

        TextView tview2 = (TextView) findViewById(R.id.tview2);
        tview2.setText("Step-2: Fill Details\n");
        tview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                popupWindow1.showAsDropDown(tview2, 0, 0);
                popupWindow2.showAtLocation(header, Gravity.CENTER , 0, 0 );
            }
        });
//        --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        LayoutInflater inflater3 = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View popupView3 = inflater3.inflate(R.layout.popup_layout3, null);
        PopupWindow popupWindow3 = new PopupWindow(popupView3, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow3.setFocusable(true);
        popupWindow3.setAnimationStyle(R.anim.popup_animation);
        TextView tview3 = (TextView) findViewById(R.id.tview3);
        tview3.setText("Step-3: Upload Scanned Images\n");
        tview3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow3.showAtLocation(header, Gravity.CENTER , 0, 0 );
            }
        });
//        --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        LayoutInflater inflater4 = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View popupView4 = inflater4.inflate(R.layout.popup_layout4, null);
        PopupWindow popupWindow4 = new PopupWindow(popupView4, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow4.setFocusable(true);
        popupWindow4.setAnimationStyle(R.anim.popup_animation);
        TextView tview4 = (TextView) findViewById(R.id.tview4);
        tview4.setText("Step-4: Fee Payment\n");
        tview4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow4.showAtLocation(header, Gravity.CENTER , 0, 0 );
            }
        });
//        --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        LayoutInflater inflater5 = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View popupView5 = inflater5.inflate(R.layout.popup_layout5, null);
        PopupWindow popupWindow5 = new PopupWindow(popupView5, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow5.setFocusable(true);
        popupWindow5.setAnimationStyle(R.anim.popup_animation);
        TextView tview5 = (TextView) findViewById(R.id.tview5);
        tview5.setText("Step-5: Print Confirmation Page\n");
        tview5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow5.showAtLocation(header, Gravity.CENTER , 0, 0 );
            }
        });
//        --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

//        Button showButton = findViewById(R.id.click_button);
//        showButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                popupWindow1.showAsDropDown(showButton, 0, 0);
//                popupWindow1.showAtLocation(v, Gravity.CENTER, 0, 0);
//            }
//        });

//        TextView tview1 = (TextView) findViewById(R.id.tview1);
//        tview1.setText(
//                "\n" +
//                "Step-1: Online Registration:\n\n" +
//                "\b\bStep-1.1: Visit Official Link:\n" +
//                "Visit to the official website.\n" +
//                "Click on the “Apply Online” link.\n" +
//                "The application page will be opened on the screen.\n" +
//                "Read the instructions carefully.\n" +
//                "Now, click on “Apply Now” button.\n" +
//                "Step-2: Fill Details:\n\n" +
//                "\b\bStep-2.1: Personal Information:\n" +
//                "Fill your personal details such as Candidate’s Full Name, Father’s/Husband’s Name, Mother’s Name, Gender, Date of Birth.\n" +
//                "All details should be same as in SSC certificate.\n" +
//                "\b\bStep-2.2: Contact Information:\n" +
//                "Fill your contact details such as address for correspondence, mobile number, telephone number & email ID.\n" +
//                "Select option of permanent residence, are you residence of India & domicile.\n" +
//                "\b\bStep-2.3: Reservation:\n" +
//                "Select the category option you belong, whether the candidate possesses Caste Certificate & Non-Creamy Layer Group or Not?\n" +
//                "\b\bStep-2.4: Other Details:\n" +
//                "Fill your other details such as PwD category, religion, other entrance exams candidate apply, total annual income, aadhaar number, etc.\n" +
//                "\b\bStep-2.5: Education Information:\n" +
//                "Fill your education details such as place from where candidate passed 12th/equivalent examination, district of school, district of exam center, etc.\n" +
//                "Also, fill MH CET exam details such as language & selection of subjects.\n" +
//                "Fill your password for future login.\n" +
//                "Fill security key given on the form & click on “Next” button.\n" +
//                "Check all the data fields have been correctly & click on the “Ok” button.\n" +
//                "Then, click on submit button.\n" +
//                "Note down your application number.\n\n" +
//                "Step-3: Upload Images:\n" +
//                "After details submission, click on the “Upload Photo & Signature” button.\n" +
//                "Photograph size should be 15 KB to 50 KB.\n" +
//                "Signature size should be 5 KB to 20 KB.\n" +
//                "Both the images in a JPG format.\n" +
//                "Photograph should be in colored passport size and take against a light/white background.\n" +
//                "The candidate himself/herself should sign (no capital letters) on a white paper with a black ink pen.\n" +
//                "Click on link “Click here to upload signature”.\n" +
//                "Then, click on “Choose File” option for photograph upload.\n" +
//                "After uploading both the scanned images, click on the “Upload Photo” button.\n" +
//                "Now, click on the “Continue” button.\n\n" +
//                "Step-4: Fee Payment\n" +
//                "After photograph & signature upload, click on the make payment button.\n" +
//                "Check all the details & click on “Pay Now” button.\n" +
//                "Pay the fee via online mode, i.e. credit card, debit card, net banking, debit card (ATM Pin) & cash card.\n" +
//                "\nStep-5: Print Confirmation Page\n" +
//                "Take print out copy of the confirmation page.\n" +
//                "Click on the “Generate MHT CET 2022 Registration Confirmation Page” link.");

    }
    private void gotoUrl(String s){
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
}