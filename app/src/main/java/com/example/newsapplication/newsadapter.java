package com.example.newsapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class newsadapter extends RecyclerView.Adapter<newsadapter.ViewHolder>{

    Context context;
    LayoutInflater layoutInflater;
    View view;
    String[] Img;
    String title[];
    String desc[];
    String link[];

    public newsadapter (Context context, String[] Img, String[] title, String[] desc, String[] link) {
        this.context = context;
        this.view = view;
        this.Img = Img;
        this.title = title;
        this.desc = desc;
        this.link = link;
    }

    @NonNull
    @Override
    public newsadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.newslayout, parent,false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull newsadapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Picasso.get().load(Img[position]).into(holder.img);
        holder.title.setText(title[position]);
        holder.desc.setText(desc[position]);
        holder.link.setText(link[position]);

        holder.newsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("cardpressed", "onClick: Pressed card");
            }
        });
    }

    @Override
    public int getItemCount() {
        return title.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView title;
        TextView desc;
        TextView link;
        CardView newsCard;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.NewsImage);
            title = itemView.findViewById(R.id.NewsTitle);
            desc = itemView.findViewById(R.id.NewsDescription);
            link = itemView.findViewById(R.id.NewsLink);
            newsCard = itemView.findViewById(R.id.newsCard);
        }
    }
}

