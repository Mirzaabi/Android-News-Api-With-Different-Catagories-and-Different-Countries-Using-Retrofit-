package com.example.newsworld.Adapter;

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
import com.example.newsworld.Detailed_News;
import com.example.newsworld.Models.Articles;
import com.example.newsworld.R;

import java.util.List;
import java.util.Locale;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{
     Context context;
     List<Articles>articles;

    public Adapter(Context context, List<Articles> articles) {
        this.context = context;
        this.articles = articles;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(context).inflate(R.layout.single_item_news,parent,false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final  Articles art=articles.get(position);
        String url=art.getUrl();
        holder.tvTitle.setText(art.getTitle());
       // holder.tvSource.setText(art.getSource());
        holder.tvDate.setText(art.getPublishedAt());
        holder.description.setText(art.getDescription());


        //for image load

        String imageUrl=art.getUrlToImage();
//Picasso.get().load(imageUrl).into(holder.imageView);
        Glide.with(context).load(imageUrl).into(holder.imageView);

        //move on next activity b click on any item

holder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {


        Intent intent=new Intent(context, Detailed_News.class);
        intent.putExtra("url",art.getUrl());
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);

    }
});

    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle,tvSource,tvDate,description;
        ImageView imageView;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.headline);
           // tvSource = itemView.findViewById(R.id.source);
            tvDate = itemView.findViewById(R.id.date);
            imageView = itemView.findViewById(R.id.newsimage);
            cardView = itemView.findViewById(R.id.card);
            description = itemView.findViewById(R.id.description);

        }

    }

public String getCountry(){
    Locale locale=Locale.getDefault();
    String country=locale.getCountry();
    return country.toLowerCase();
}


}