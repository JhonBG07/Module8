package com.example.modulo8;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class ProfileFragment extends Fragment {

    View view;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_profile, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerviewGallery);

        List<Mascota> mascotas = new ArrayList<>();
        mascotas.add(new Mascota(R.drawable.pastor1, 6));
        mascotas.add(new Mascota(R.drawable.pastor2, 4));
        mascotas.add(new Mascota(R.drawable.pastor3, 2));
        mascotas.add(new Mascota(R.drawable.pastor4, 10));
        mascotas.add(new Mascota(R.drawable.pastor5, 1));
        mascotas.add(new Mascota(R.drawable.pastor6, 25));
        mascotas.add(new Mascota(R.drawable.pastor7, 14));
        mascotas.add(new Mascota(R.drawable.pastor8, 14));
        mascotas.add(new Mascota(R.drawable.pastor9, 14));

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
        recyclerView.setAdapter(new GalleryAdapter(getContext(), mascotas));

        return view;
    }
}