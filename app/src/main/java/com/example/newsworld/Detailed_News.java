package com.example.newsworld;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class Detailed_News extends AppCompatActivity {
WebView webView;
ProgressDialog progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed__news);

        webView=findViewById(R.id.webview);


        /*progress = new ProgressDialog(this);
        progress.setMessage("Loading");
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.show();*/
        //url get from privious activity through intent

        Intent intent=getIntent();
        String url=intent.getStringExtra("url");

        // setting for show items in web view

        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.setWebViewClient(new WebViewClient());


        webView.loadUrl(url);

    }
}