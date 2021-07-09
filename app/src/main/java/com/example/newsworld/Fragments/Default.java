package com.example.newsworld.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.newsworld.Detailed_News;
import com.example.newsworld.MainActivity;
import com.example.newsworld.R;



public class Default extends Fragment {
    TextView subscribe,Read;
    FrameLayout frame;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {




        View v= inflater.inflate(R.layout.fragment_default, container, false);

        subscribe= v.findViewById(R.id.subscribetv);
        Read=v.findViewById(R.id.readlettertv);
        frame=v.findViewById(R.id.frame);


        subscribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext().getApplicationContext(), Detailed_News.class);
                intent.putExtra("url","https://ifj.us6.list-manage.com/subscribe?u=312d2086b1b5654e5e6957dd9&id=09bc8a5951&group[11885][16]=1&group[11897][32768]=1&group[11893][16384]=1");
                startActivity(intent);

            }
        });

        Read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext().getApplicationContext(),Detailed_News.class);
                intent.putExtra("url","https://mailchi.mp/ifj/ifj-covid-19-weekly-652816");
                startActivity(intent);


            }
        });
        return v;
    }


}