package com.example.modulo8;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GalleryViewholder extends RecyclerView.ViewHolder {
    ImageView image;
    TextView likesCount;

    public GalleryViewholder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.picture);
        likesCount = itemView.findViewById(R.id.likesCount);
    }
}
