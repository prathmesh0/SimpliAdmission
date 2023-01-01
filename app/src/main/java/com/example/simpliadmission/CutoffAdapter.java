package com.example.simpliadmission;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;

public class CutoffAdapter extends RecyclerView.Adapter<CutoffAdapter.MyViewHolder> {
    CutOff cutOff;
    ArrayList<DownModel> downModels;

    public CutoffAdapter(CutOff cutOff, ArrayList<DownModel> downModels) {
        this.cutOff = cutOff;
        this.downModels = downModels;
    }

    @androidx.annotation.NonNull
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(cutOff.getBaseContext());
        @SuppressLint("InflateParams") View view = layoutInflater.inflate(R.layout.elements,null,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@androidx.annotation.NonNull CutoffAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.mName.setText(downModels.get(position).getName());
        holder.mLink.setText(downModels.get(position).getLink());
        holder.mDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadFile(holder.mName.getContext(),downModels.get(position).getName(),".pdf",DIRECTORY_DOWNLOADS,downModels.get(position).getLink());
                holder.mDownload.setVisibility(View.INVISIBLE);
            }
        });

    }
    public void downloadFile(Context context, String fileName, String fileExtension, String destinationDirectory, String url) {

        DownloadManager downloadmanager = (DownloadManager) context.
                getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);

        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context, destinationDirectory, fileName + fileExtension);

        downloadmanager.enqueue(request);
    }




    @Override
    public int getItemCount() {
        return downModels.size();
    }
    static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView mName, mLink;
        LottieAnimationView mDownload;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            mName = itemView.findViewById(R.id.name);
            mLink = itemView.findViewById(R.id.link);
            mDownload = itemView.findViewById(R.id.down);
        }
    }
}
