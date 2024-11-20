package com.example.modulo8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryViewholder> {
    Context context;
    List<Mascota> mascotas;

    public GalleryAdapter(Context context, List<Mascota> mascotas) {
        this.context = context;
        this.mascotas = mascotas;
    }

    @NonNull
    @Override
    public GalleryViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GalleryViewholder(LayoutInflater.from(context).inflate(R.layout.pet_gallery_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewholder holder, int position) {
        holder.likesCount.setText(mascotas.get(position).getLikes());
        holder.image.setImageResource(mascotas.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }
}
