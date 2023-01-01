package com.example.simpliadmission;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Steps extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steps);

        String mhtcet = "https://cetcell.mahacet.org/";

        TextView undertext = (TextView) findViewById(R.id.undertext);
        undertext.setText("Steps to fill application form\n\nMHT-CET\n"+mhtcet);
        undertext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl(mhtcet);
            }
        });

        TextView tview1 = (TextView) findViewById(R.id.tview1);
        tview1.setText("How to Fill MH CET Application Form\n" +
                "Candidates should follow the following steps to fill the application form. Here, we have mentioned step by step procedure for How to Fill MH CET Application Form:\n" +
                "\n" +
                "Step-1: Online Registration\n" +
                "Step-2: Fill Details\n" +
                "Step-3: Upload Scanned Images\n" +
                "Step-4: Fee Payment\n" +
                "Step-5: Print Confirmation Page\n" +
                "\n" +
                "Step-1: Online Registration:\n\n" +
                "\b\bStep-1.1: Visit Official Link:\n" +
                "Visit to the official website.\n" +
                "Click on the “Apply Online” link.\n" +
                "The application page will be opened on the screen.\n" +
                "Read the instructions carefully.\n" +
                "Now, click on “Apply Now” button.\n" +
                "Step-2: Fill Details:\n\n" +
                "\b\bStep-2.1: Personal Information:\n" +
                "Fill your personal details such as Candidate’s Full Name, Father’s/Husband’s Name, Mother’s Name, Gender, Date of Birth.\n" +
                "All details should be same as in SSC certificate.\n" +
                "\b\bStep-2.2: Contact Information:\n" +
                "Fill your contact details such as address for correspondence, mobile number, telephone number & email ID.\n" +
                "Select option of permanent residence, are you residence of India & domicile.\n" +
                "\b\bStep-2.3: Reservation:\n" +
                "Select the category option you belong, whether the candidate possesses Caste Certificate & Non-Creamy Layer Group or Not?\n" +
                "\b\bStep-2.4: Other Details:\n" +
                "Fill your other details such as PwD category, religion, other entrance exams candidate apply, total annual income, aadhaar number, etc.\n" +
                "\b\bStep-2.5: Education Information:\n" +
                "Fill your education details such as place from where candidate passed 12th/equivalent examination, district of school, district of exam center, etc.\n" +
                "Also, fill MH CET exam details such as language & selection of subjects.\n" +
                "Fill your password for future login.\n" +
                "Fill security key given on the form & click on “Next” button.\n" +
                "Check all the data fields have been correctly & click on the “Ok” button.\n" +
                "Then, click on submit button.\n" +
                "Note down your application number.\n\n" +
                "Step-3: Upload Images:\n" +
                "After details submission, click on the “Upload Photo & Signature” button.\n" +
                "Photograph size should be 15 KB to 50 KB.\n" +
                "Signature size should be 5 KB to 20 KB.\n" +
                "Both the images in a JPG format.\n" +
                "Photograph should be in colored passport size and take against a light/white background.\n" +
                "The candidate himself/herself should sign (no capital letters) on a white paper with a black ink pen.\n" +
                "Click on link “Click here to upload signature”.\n" +
                "Then, click on “Choose File” option for photograph upload.\n" +
                "After uploading both the scanned images, click on the “Upload Photo” button.\n" +
                "Now, click on the “Continue” button.\n\n" +
                "Step-4: Fee Payment\n" +
                "After photograph & signature upload, click on the make payment button.\n" +
                "Check all the details & click on “Pay Now” button.\n" +
                "Pay the fee via online mode, i.e. credit card, debit card, net banking, debit card (ATM Pin) & cash card.\n" +
                "\nStep-5: Print Confirmation Page\n" +
                "Take print out copy of the confirmation page.\n" +
                "Click on the “Generate MHT CET 2022 Registration Confirmation Page” link.");
    }
    private void gotoUrl(String s){
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
}