package com.example.examplerecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holdview> {
     Context ct;
     ArrayList<MyModel> list;

    public MyAdapter(Context ct, ArrayList<MyModel> list) {
        this.ct = ct;
        this.list = list;
    }

    @NonNull
    @Override
    public Holdview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holdview(LayoutInflater.from(ct).inflate(R.layout.row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Holdview holder, int position) {
      holder.tv.setText(list.get(position).getTitle());
        Glide.with(ct).load(list.get(position).getLink()).into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class Holdview extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv;
        public Holdview(@NonNull View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.iv);
            tv=itemView.findViewById(R.id.tv);
        }
    }
}
