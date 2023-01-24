package com.example.newsfeed;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{
    //ViewHolder class is taking the views from news_segment xml
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mheading, mcontent, mauthor, mtime;
        CardView cardview;
        ImageView imageview;

        //Constructor of viewholder class
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //fetching the ids of views of news_segment
            mheading=itemView.findViewById(R.id.mainheading);
            mcontent=itemView.findViewById(R.id.content);
            mauthor=itemView.findViewById(R.id.author);
            mtime=itemView.findViewById(R.id.time);
            cardview=itemView.findViewById(R.id.cardview);
            imageview=itemView.findViewById(R.id.imageview);
        }
    }
    Context context;
    ArrayList<Model> modelClassArrayList;

    public RecyclerAdapter(Context context, ArrayList<Model> modelClassArrayList) {
        this.context=context;
        this.modelClassArrayList=modelClassArrayList;
    }

    @NonNull
    @Override
    //ViewHolder method is converting our news segment xml file into its corresponding view object
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.news_segment, null, false);
        return new ViewHolder(view);
    }

    //The following code will fetch the data from the web service and display them
    //on the app[CardView]
    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {

        //On clicking the cardview the web-service news page will be opened
        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( context, WebViewClass.class);
                intent.putExtra("url", modelClassArrayList.get(position).getUrl());
                context.startActivity(intent);
            }
        });
        holder.mheading.setText(modelClassArrayList.get(position).getTitle());
        holder.mcontent.setText(modelClassArrayList.get(position).getDescription());
        holder.mauthor.setText(modelClassArrayList.get(position).getAuthor());
        holder.mtime.setText(modelClassArrayList.get(position).getPublishedAt());
        Glide.with(context).load(modelClassArrayList.get(position).getUrlToImage()).into(holder.imageview);
    }

    @Override
    public int getItemCount() {
        return modelClassArrayList.size();
    }

}
