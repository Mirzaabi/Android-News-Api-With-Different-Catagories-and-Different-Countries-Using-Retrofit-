package com.example.newsworld.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Headline {

@SerializedName("status")
    @Expose
    private String status;

    @SerializedName("totalResults")
    @Expose
    private String totalResults;

    @SerializedName("articles")
    @Expose
    private List<Articles>marticles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public List<Articles> getMarticles() {
        return marticles;
    }

    public void setMarticles(List<Articles> marticles) {
        this.marticles = marticles;
    }

    public Headline(String status, String totalResults, List<Articles> marticles) {
        this.status = status;
        this.totalResults = totalResults;
        this.marticles = marticles;
    }
}


