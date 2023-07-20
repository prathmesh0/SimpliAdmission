package com.example.simpliadmission;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.Editable;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.Lottie;
import com.airbnb.lottie.LottieAnimationView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class Predict extends AppCompatActivity {


    private String selectedItem, url;

//    String url = "https://web-production-4c809.up.railway.app/cmpn";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_predict);

        LottieAnimationView progressBar = findViewById(R.id.progressBar);


        Spinner spinner = (Spinner) findViewById(R.id.collegeBranch);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedItem = parent.getItemAtPosition(position).toString();
                switch (selectedItem) {
                    case "Computer Engineering":
                        url = "https://simpliadmission.up.railway.app/cmpn";
                        break;
                    case "Information Technology":
                        url = "https://simpliadmission.up.railway.app/inft";
                        break;
                    case "Electronics and Telecommunication":
                        url = "https://simpliadmission.up.railway.app/extc";
                        break;
                    case "Electrical Engineering":
                        url = "https://simpliadmission.up.railway.app/elec";
                        break;
                }
//                Toast.makeText(getApplicationContext(), selectedItem, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(Predict.this, ";)", Toast.LENGTH_SHORT).show();
            }
        });




        EditText percentile = (EditText) findViewById(R.id.percentile);
        Button predict = (Button) findViewById(R.id.predBtn);
        TextView predResult = (TextView) findViewById(R.id.result);


        predict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                predict.setEnabled(false);
                if (!percentile.getText().toString().equals("")) {
                    predResult.setText("");
                    progressBar.setVisibility(View.VISIBLE);

                    String txtPercentile = percentile.getText().toString();
                    float checkPredict = Float.parseFloat(txtPercentile);
                    if (checkPredict > 100 || checkPredict < 0) {
                        Toast.makeText(Predict.this, "Please enter valid percentile", Toast.LENGTH_SHORT).show();
                    } else {
                        if(checkPredict < 30){
                            Toast.makeText(Predict.this, "Chances of admission are less in first cap round", Toast.LENGTH_SHORT).show();
                        }
                        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                                new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {
                                        try {
                                            JSONObject jsonObject = new JSONObject(response);
                                            String data = jsonObject.getString("You have chance to get admission in ");
                                            predResult.setText(data);
                                            predResult.setClickable(true);

                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                        progressBar.setVisibility(View.GONE);
                                    }
                                },
                                new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                        Toast.makeText(Predict.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                }) {
                            @Override
                            protected Map<String, String> getParams() {
                                Map<String, String> params = new HashMap<String, String>();
                                params.put("percentile", percentile.getText().toString());

                                return params;
                            }
                        };
                        RequestQueue queue = Volley.newRequestQueue(Predict.this);
                        queue.add(stringRequest);
                    }
                }
                else{
                    percentile.setError("Please enter your percentile!");
                    percentile.requestFocus();
//                    Toast.makeText(Predict.this, "Please enter your percentile", Toast.LENGTH_SHORT).show();
                }
                predict.setEnabled(true);
            }
        });
    }
}