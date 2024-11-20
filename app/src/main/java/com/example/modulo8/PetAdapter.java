package com.example.modulo8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PetAdapter extends RecyclerView.Adapter<PetViewholder>{

    Context context;
    List<Mascota> mascotas;

    private DatabaseHelper dbHelper;

    public PetAdapter(Context context, List<Mascota> mascotas) {
        this.context = context;
        this.mascotas = mascotas;
    }

    @NonNull
    @Override
    public PetViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PetViewholder(LayoutInflater.from(context).inflate(R.layout.pet_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PetViewholder holder, int position) {
        dbHelper = new DatabaseHelper(context);

        holder.petName.setText(mascotas.get(position).getPet());
        holder.likes.setText(String.valueOf(mascotas.get(position).getLikes()));
        holder.imageView.setImageResource(mascotas.get(position).getImage());
        if (mascotas.get(position).isHasLike()) {
            holder.likeBtn.setBackgroundResource(R.drawable.hueso_liked);
            holder.likeBtn.setChecked(true);
        } else {
            holder.likeBtn.setBackgroundResource(R.drawable.hueso);
            holder.likeBtn.setChecked(false);
        }
        holder.likeBtn.setOnCheckedChangeListener(((buttonView, isChecked) -> {
            mascotas.get(position).setHasLike(isChecked);
            if (isChecked) {
                mascotas.get(position).incrementLikes();
                holder.likeBtn.setBackgroundResource(R.drawable.hueso_liked);
                boolean insercionDB = dbHelper.insertarMascota(mascotas.get(position));
                if(insercionDB){
                    Toast.makeText(context, "exito",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(context, "error",Toast.LENGTH_SHORT).show();
                }
            } else {
                mascotas.get(position).decrementLikes();
                holder.likeBtn.setBackgroundResource(R.drawable.hueso);
            }
            holder.likes.setText(String.valueOf(mascotas.get(position).getLikes()));
        }));
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }
}
