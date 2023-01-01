package com.example.simpliadmission;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class compareAdapter extends RecyclerView.Adapter<compareAdapter.myviewholder>{

    ArrayList<compareModel> datalist;

    public compareAdapter(ArrayList<compareModel> datalist) {
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.comparesinglerow, parent, false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, @SuppressLint("RecyclerView") int position) {
        holder.t1.setText(datalist.get(position).getName());
        holder.t3.setText(datalist.get(position).getFee());
        holder.t4.setText(datalist.get(position).getCourses());
        holder.t5.setText(datalist.get(position).getType());
        holder.t7.setText(datalist.get(position).getEstd());

//        holder.t1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(holder.t1.getContext(), CompareData.class);
//
//                intent.putExtra("dataName", datalist.get(position).getName());
//                intent.putExtra("dataFee", datalist.get(position).getFee());
//                intent.putExtra("dataCourses", datalist.get(position).getCourses());
//                intent.putExtra("dataType", datalist.get(position).getType());
//                intent.putExtra("dataEstd", datalist.get(position).getEstd());
////
////
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                holder.t1.getContext().startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public void setFilteredList(List<compareModel> filteredList1) {
        this.datalist = (ArrayList<compareModel>) filteredList1;
        notifyDataSetChanged();
    }

    class myviewholder extends RecyclerView.ViewHolder{
        TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;

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
