package com.example.modulo8;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PetViewholder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView petName, likes;

    ToggleButton likeBtn;

    public PetViewholder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView);
        petName = itemView.findViewById(R.id.petName);
        likes = itemView.findViewById(R.id.likesNum);
        likeBtn = itemView.findViewById(R.id.likeBtn);
    }
}
