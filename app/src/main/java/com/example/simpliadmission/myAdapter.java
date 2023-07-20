package com.example.simpliadmission;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class myAdapter extends RecyclerView.Adapter<myAdapter.myViewHolder>{

    ArrayList<model> dataList;
//    final String URL_REGEX = "^(https?|ftp)://(-\\.)?([^\\s/?\\.#-]+\\.?)+(/[\\S]*)?$";
//    final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);
//    Resources res = getResources();

//    DatabaseReference likeRef;


    public myAdapter(ArrayList<model> datalist) {
        this.dataList = datalist;
    }

    public void setFilteredList(List<model> filteredList){
        this.dataList = (ArrayList<model>) filteredList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.t1.setText(dataList.get(position).getName());
//        holder.t2.setText(dataList.get(position).getEmail());
//        holder.t3.setText(dataList.get(position).getFee());
//        holder.t4.setText(dataList.get(position).getCourses());
//        holder.t5.setText(dataList.get(position).getType());
//        holder.t6.setText(dataList.get(position).getAddress() + "Show in maps");
//        holder.t7.setText(dataList.get(position).getEstd());
//        holder.t8.setText(dataList.get(position).getPhone());
//        holder.t9.setText(dataList.get(position).getWebsite());

////        ImageView imageView = findViewById(R.id.image_link);
            String imageUrl = dataList.get(position).getImage();
            Picasso.get().load(imageUrl).into(holder.t10);

            holder.t1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(holder.t1.getContext(), CollegeData.class);

                    intent.putExtra("dataName", dataList.get(position).getName());
                    intent.putExtra("dataEmail", dataList.get(position).getEmail());
                    intent.putExtra("dataFee", dataList.get(position).getFee());
                    intent.putExtra("dataCourses", dataList.get(position).getCourses());
                    intent.putExtra("dataType", dataList.get(position).getType());
                    intent.putExtra("dataAddress", dataList.get(position).getAddress());
                    intent.putExtra("dataEstd", dataList.get(position).getEstd());
                    intent.putExtra("dataPhone", dataList.get(position).getPhone());
                    intent.putExtra("dataWebsite", dataList.get(position).getWebsite());
                    intent.putExtra("dataBg", dataList.get(position).getBg());
//
//
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    holder.t1.getContext().startActivity(intent);

                }

            });
        holder.cardView.startAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(), R.anim.anim));

//        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
//        String userID = firebaseUser.getUid();
//        String postKey = dataList.get(position).getName();
//
//        holder.likeBtnStatus(postKey, userID);

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    static class myViewHolder extends RecyclerView.ViewHolder{

        TextView t1, t2, t3, t4, t5, t6, t7, t8, t9;
        ImageView t10;
        private final CardView cardView;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.t1);
            t2 = itemView.findViewById(R.id.t2);
            t3 = itemView.findViewById(R.id.t3);
            t4 = itemView.findViewById(R.id.t4);
            t5 = itemView.findViewById(R.id.t5);
            t6 = itemView.findViewById(R.id.t6);
            t7 = itemView.findViewById(R.id.t7);
            t8 = itemView.findViewById(R.id.t8);
            t9 = itemView.findViewById(R.id.t9);
            t10 = itemView.findViewById(R.id.t10);

            cardView = itemView.findViewById(R.id.cardView);

//            public void likeBtnStatus(final String postKey, final String userID) {
//                likeRef = FirebaseDatabase.getInstance().getReference("likes");
//                likeRef.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if (snapshot.child(postKey).hasChild(userID)){
//                            int likeCount = (int)snapshot.child(postKey).getChildrenCount();
//                            likeText.setText(likeCount + "likes");
//                        }
//                        else{
//
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });
//            }
        }


    }
}
