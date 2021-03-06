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

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder>{
    public int[] pictures=new int[]{R.drawable.m1,R.drawable.m2,R.drawable.m3,R.drawable.m4,R.drawable.m5,R.drawable.m6};//本地图片
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.picture_list_item,parent,false);//创建view实例,将布局传入
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(pictures[position]);//对RecyclerView的子项进行赋值
    }

    @Override
    public int getItemCount() {
        return pictures.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{//定义内部类 ViewHolder
       private ImageView imageView;
       public ViewHolder(@NonNull View itemView) {
           super(itemView);
           imageView=itemView.findViewById(R.id.image_view);//获取picture_list_item布局中的imageView实例
       }
   }
}
