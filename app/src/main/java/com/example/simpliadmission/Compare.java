package com.example.simpliadmission;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Compare extends AppCompatActivity {

//    ArrayList<String> spinnerList;
//    FirebaseFirestore db;
//    DatabaseReference spinnerRef;
//    ArrayAdapter<String> adapter;
//    Spinner sview1;
//    Spinner sview2;
    RecyclerView recview1, recview2;
    ArrayList<compareModel> datalist;
    ArrayList<compareModel2> datalist2;
    FirebaseFirestore db1, db2;
    compareAdapter adapter;
    compareAdapter2 adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare);

        TextView undertext = (TextView) findViewById(R.id.undertext);
        undertext.setText("Compare Colleges\nusing search option ");

        SearchView searchView1 = findViewById(R.id.searchView1);
        searchView1.clearFocus();
        searchView1.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList1(newText);
                return true;
            }
        });
        SearchView searchView2 = findViewById(R.id.searchView2);
        searchView2.clearFocus();
        searchView2.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList2(newText);
                return true;
            }
        });

        recview1 = findViewById(R.id.recview1);
        recview1.setLayoutManager(new LinearLayoutManager(this));


        recview2 = findViewById(R.id.recview2);
        recview2.setLayoutManager(new LinearLayoutManager(this));


        datalist = new ArrayList<compareModel>();
        datalist2 = new ArrayList<compareModel2>();

        adapter = new compareAdapter(datalist);
        adapter2 = new compareAdapter2(datalist2);

        recview1.setAdapter(adapter);
        recview2.setAdapter(adapter2);

        db1 = FirebaseFirestore.getInstance();
        db1.collection("Colleges").orderBy("name").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {

                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                        for(DocumentSnapshot d:list){
                            compareModel obj = d.toObject(compareModel.class);
                            datalist.add(obj);
                        }
                        adapter.notifyDataSetChanged();
                    }
                });

        db2 = FirebaseFirestore.getInstance();
        db2.collection("Colleges").orderBy("name").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> list= queryDocumentSnapshots.getDocuments();
                        for(DocumentSnapshot d:list){
                            compareModel2 obj = d.toObject(compareModel2.class);
                            datalist2.add(obj);
                        }
                        adapter2.notifyDataSetChanged();
                    }
                });

    }


    private void filterList1(String text) {
        List<compareModel> filteredList1 = new ArrayList<>();
        for (compareModel d1: datalist ){
            if (d1.getName().toLowerCase().contains(text.toLowerCase())){
                filteredList1.add(d1);
            }
        }
        if (filteredList1.isEmpty()){
            Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show();
        }
        else{
            adapter.setFilteredList(filteredList1);
        }
    }
    private void filterList2(String text) {
        List<compareModel2> filteredList2 = new ArrayList<>();
        for (compareModel2 d2: datalist2 ){
            if (d2.getName().toLowerCase().contains(text.toLowerCase())){
                filteredList2.add(d2);
            }
        }
        if (filteredList2.isEmpty()){
            Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show();
        }
        else{
            adapter2.setFilteredList(filteredList2);
        }
    }
}
