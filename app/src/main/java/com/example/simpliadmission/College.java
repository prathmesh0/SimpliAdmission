package com.example.simpliadmission;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class College extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<model> dataList;
    FirebaseFirestore db;
    myAdapter adapter;
    SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college);

        searchView = findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });

        TextView CollegeUnderText = (TextView) findViewById(R.id.undertext);
        CollegeUnderText.setText("List of Colleges in Mumbai");

        recyclerView = (RecyclerView) findViewById(R.id.recview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dataList = new ArrayList<>();

        adapter = new myAdapter(dataList);
        recyclerView.setAdapter(adapter);


//        recyclerView
        db = FirebaseFirestore.getInstance();
        db.collection("Colleges").orderBy("name").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                        for (DocumentSnapshot d:list){
                            model obj = d.toObject(model.class);
                            dataList.add(obj);
                        }
                        adapter.notifyDataSetChanged();
                    }
                });


    }


//    Search
    private void filterList(String text) {
        List<model> filteredList = new ArrayList<>();
        for (model d: dataList ){
            if (d.getName().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(d);
            }
            if (d.getAddress().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(d);
            }
        }
        if (filteredList.isEmpty()){
            Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show();
        }
        else{
            adapter.setFilteredList(filteredList);
        }
    }
}