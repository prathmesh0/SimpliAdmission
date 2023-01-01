package com.example.simpliadmission;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class compareAdapter2 extends RecyclerView.Adapter<compareAdapter2.myviewholder> {
    ArrayList<compareModel2> datalist2;

    public compareAdapter2(ArrayList<compareModel2> datalist2) {
        this.datalist2 = datalist2;
    }

    @NonNull
    @Override
    public compareAdapter2.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.comparesinglerow, parent, false);
        return new compareAdapter2.myviewholder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, @SuppressLint("RecyclerView") int position) {
        holder.t1.setText(datalist2.get(position).getName());
        holder.t3.setText(datalist2.get(position).getFee());
        holder.t4.setText(datalist2.get(position).getCourses());
        holder.t5.setText(datalist2.get(position).getType());
        holder.t7.setText(datalist2.get(position).getEstd());

    }

    @Override
    public int getItemCount() {
        return datalist2.size();
    }

    public void setFilteredList(List<compareModel2> filteredList2) {
        this.datalist2 = (ArrayList<compareModel2>) filteredList2;
        notifyDataSetChanged();
    }

    class myviewholder extends RecyclerView.ViewHolder{
        TextView t1,t2,t3,t4,t5,t6,t7,t8,t9;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.clg_name);
            t3 = itemView.findViewById(R.id.fee);
            t4 = itemView.findViewById(R.id.courses);
            t5 = itemView.findViewById(R.id.type);
            t7 = itemView.findViewById(R.id.estd);

            CardView cardView = itemView.findViewById(R.id.compareCardView);
        }
    }
}
