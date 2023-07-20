package com.example.simpliadmission;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class CutOff extends AppCompatActivity {
    FirebaseFirestore db;
    RecyclerView mRecyclerView;
    ArrayList<DownModel> downModelArrayList = new ArrayList<>();
    CutoffAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cut_off);

        TextView undertext = (TextView) findViewById(R.id.undertext);
        undertext.setText("Previous Years Cut offs\n\nMHT-CET");

        setUpRV();
        setUpFB();
        dataFromFirebase();
    }
    private void dataFromFirebase() {

        if(downModelArrayList.size() > 0)
            downModelArrayList.clear();

        db.collection("cutoff").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                for (DocumentSnapshot documentSnapshot: task.getResult()){

                    DownModel downModel = new DownModel(documentSnapshot.getString("name"),documentSnapshot.getString("url"));
                    downModelArrayList.add(downModel);
                }

                myAdapter = new CutoffAdapter(CutOff.this,downModelArrayList);
                mRecyclerView.setAdapter(myAdapter);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(CutOff.this,"Error...", Toast.LENGTH_LONG).show();
            }
        });

    }



    private void setUpFB() {
        db = FirebaseFirestore.getInstance();
    }



    private void setUpRV() {

        mRecyclerView = findViewById(R.id.recycle);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
}