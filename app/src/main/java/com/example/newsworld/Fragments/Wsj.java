package com.example.newsworld.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.newsworld.Adapter.Adapter;
import com.example.newsworld.Models.Articles;
import com.example.newsworld.Models.Headline;
import com.example.newsworld.R;
import com.example.newsworld.Retrofit.Api_Clint;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Wsj extends Fragment {


    RecyclerView recyclerView;
    Adapter adapter;
    List<Articles> articles;

    final String api_key="6c0ce265e0bb4053b77258ca2d48aaa3";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_wsj, container, false);


        recyclerView =v.findViewById(R.id.recv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        articles=new ArrayList<>();

        fatchNEWS();

        return v;
    }
    private void fatchNEWS() {

        //for fatch data from api

        Call<Headline> call = Api_Clint.getInstance().getApi().getWsjHeadline();
        call.enqueue(new Callback<Headline>() {
            @Override
            public void onResponse(Call<Headline> call, Response<Headline> response) {
                if (response.isSuccessful() && response.body().getMarticles() != null) {

                    articles.clear();
                    articles = response.body().getMarticles();
                    adapter = new Adapter(getContext().getApplicationContext(), articles);
                    recyclerView.setAdapter(adapter);
                    Toast.makeText(getContext().getApplicationContext(), "News", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext().getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
                }

            }


            @Override
            public void onFailure(Call<Headline> call, Throwable t) {
                Toast.makeText(getContext().getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }

}