package com.lixiaojuan.news.adapter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lixiaojuan.news.R;

import java.util.ArrayList;
import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>{
    public int[] pictures=new int[]{R.drawable.m1,R.drawable.m2,R.drawable.m3,R.drawable.m4,R.drawable.m5,R.drawable.m6};
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MyViewHolder holder=new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.picture_list_item,parent,false));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.imageView.setImageResource(pictures[position]);
    }

    @Override
    public int getItemCount() {
        return pictures.length;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
       private ImageView imageView;
       public MyViewHolder(@NonNull View itemView) {
           super(itemView);
           imageView=itemView.findViewById(R.id.image_view);
       }
   }
}
