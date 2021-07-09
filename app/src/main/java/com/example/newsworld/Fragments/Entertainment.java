package com.example.newsworld.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.newsworld.Adapter.Adapter;
import com.example.newsworld.Models.Articles;
import com.example.newsworld.Models.Headline;
import com.example.newsworld.R;
import com.example.newsworld.Retrofit.Api_Clint;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Entertainment extends Fragment {


    RecyclerView recyclerView;
    Adapter adapter;
    List<Articles> articles;
    Spinner mcountry;
    String pcountry;
    String spinnercountry;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_business, container, false);


        mcountry = v.findViewById(R.id.spinner);
        recyclerView = v.findViewById(R.id.recv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        articles = new ArrayList<>();


        ArrayAdapter<String> quantityadapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_dropdown_item,getResources().getStringArray(R.array.countries));
        mcountry.setAdapter(quantityadapter);


        mcountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                spinnercountry = parent.getItemAtPosition(position).toString();

                if (spinnercountry.equals("America")){
                    pcountry = "us";
                    fetchAllCountryNews();
                    Toast.makeText(getContext(), "success", Toast.LENGTH_SHORT).show();
                }
                if (spinnercountry.equals("India")){
                    pcountry = "in";
                    fetchAllCountryNews();
                    Toast.makeText(getContext(), "success", Toast.LENGTH_SHORT).show();
                }
                if (spinnercountry.equals("Australia")){
                    pcountry = "au";
                    fetchAllCountryNews();
                    Toast.makeText(getContext(), "success", Toast.LENGTH_SHORT).show();
                }
                if (spinnercountry.equals("Austria")){
                    pcountry = "at";
                    fetchAllCountryNews();
                    Toast.makeText(getContext(), "success", Toast.LENGTH_SHORT).show();
                }
                if (spinnercountry.equals("Canada")){
                    pcountry = "ca";
                    fetchAllCountryNews();
                    Toast.makeText(getContext(), "success", Toast.LENGTH_SHORT).show();
                }
                if (spinnercountry.equals("China")){
                    pcountry = "cn";
                    fetchAllCountryNews();
                    Toast.makeText(getContext(), "success", Toast.LENGTH_SHORT).show();
                }
                if (spinnercountry.equals("America")){
                    pcountry = "us";
                    fetchAllCountryNews();
                    Toast.makeText(getContext(), "success", Toast.LENGTH_SHORT).show();
                }

                if (spinnercountry.equals("Dubai")){
                    pcountry = "ae";
                    fetchAllCountryNews();
                    Toast.makeText(getContext(), "success", Toast.LENGTH_SHORT).show();
                }


                Toast.makeText(getContext(), "Select Your Country", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return v;
    }


    private void fetchAllCountryNews() {

        //for fatch data from api

        Call<Headline> call = Api_Clint.getInstance().getApi().getBussinesHeadline(pcountry,
                "entertainment","3060f357934144d1a18f202ec35d88a4");
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