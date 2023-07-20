package com.example.simpliadmission;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.regex.Pattern;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MyViewHolder> {
    List<Message> messageList;
    final String URL_REGEX = "^(https?|ftp)://(-\\.)?([^\\s/?\\.#-]+\\.?)+(/[\\S]*)?$";
    final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);
    public MessageAdapter(List<Message> messageList) {
        this.messageList = messageList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View chatView = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item,null);
        return new MyViewHolder(chatView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Message message = messageList.get(position);
        if(message.getSentBy().equals(Message.SENT_BY_ME)){
            holder.leftChatView.setVisibility(View.GONE);
            holder.rightChatView.setVisibility(View.VISIBLE);
            holder.rightTextView.setText(message.getMessage());
        }else{
            holder.rightChatView.setVisibility(View.GONE);
            holder.leftChatView.setVisibility(View.VISIBLE);
            if(URL_PATTERN.matcher(message.getMessage()).matches()){
//                holder.leftTextView.setText(message.getMessage()+"- Click to copy");
                holder.leftTextView.setText(message.getMessage());
                holder.leftTextView.setPaintFlags(holder.leftTextView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
//
                holder.leftTextView.setOnClickListener(v -> {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(message.getMessage()));
                    v.getContext().startActivity(intent);
//                        Toast.makeText(v.getContext(), "message copied", Toast.LENGTH_SHORT).show();
                });
            }else{
                holder.leftTextView.setText(message.getMessage());
                holder.leftTextView.setOnLongClickListener(v -> {
                    holder.leftChatView.animate().alpha(0.4f).setDuration(700).withEndAction(() -> holder.leftChatView.setAlpha(1.0f)).start();
                    ClipboardManager clipboard = (ClipboardManager) v.getContext().getSystemService(Context.CLIPBOARD_SERVICE);
                    ClipData clip = ClipData.newPlainText("text", message.getMessage());
                    clipboard.setPrimaryClip(clip);
                    Toast.makeText(v.getContext(), "message copied", Toast.LENGTH_SHORT).show();
                    return true;
                });
            }
        }
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        LinearLayout leftChatView,rightChatView;
        TextView leftTextView,rightTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            leftChatView  = itemView.findViewById(R.id.left_chat_view);
            rightChatView = itemView.findViewById(R.id.right_chat_view);
            leftTextView = itemView.findViewById(R.id.left_chat_text_view);
            rightTextView = itemView.findViewById(R.id.right_chat_text_view);
        }
    }
}
