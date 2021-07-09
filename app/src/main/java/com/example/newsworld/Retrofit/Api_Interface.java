package com.example.newsworld.Retrofit;

import com.example.newsworld.Models.Headline;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface Api_Interface {

    //Bussines news Keys for Different Countries
    String bussines_key_us="top-headlines?country=us&category=business&apiKey=3060f357934144d1a18f202ec35d88a4";
    String bussines_key_at="top-headlines?country=at&category=business&apiKey=3060f357934144d1a18f202ec35d88a4";
    String bussines_key_au="top-headlines?country=au&category=business&apiKey=3060f357934144d1a18f202ec35d88a4";
    String bussines_key_cn="top-headlines?country=cn&category=business&apiKey=3060f357934144d1a18f202ec35d88a4";
    String bussines_key_ca="top-headlines?country=ca&category=business&apiKey=3060f357934144d1a18f202ec35d88a4";
    String bussines_key_ae="top-headlines?country=ae&category=business&apiKey=3060f357934144d1a18f202ec35d88a4";
    String bussines_key_in="top-headlines?country=in&category=business&apiKey=3060f357934144d1a18f202ec35d88a4";




    String apple_key="everything?q=apple&from=2021-06-29&to=2021-06-29&sortBy=popularity&apiKey=6c0ce265e0bb4053b77258ca2d48aaa3";
    String bussines_key="top-headlines?country=in&category=business&apiKey=3060f357934144d1a18f202ec35d88a4";
    String entertainment_key="top-headlines?country=us&category=entertainment&apiKey=3060f357934144d1a18f202ec35d88a4";
    String genral_key="top-headlines?country=in&category=genral&apiKey=3060f357934144d1a18f202ec35d88a4";
    String health_key="top-headlines?country=in&category=health&apiKey=3060f357934144d1a18f202ec35d88a4";
    String science_key="top-headlines?country=in&category=science&apiKey=3060f357934144d1a18f202ec35d88a4";
    String sports_key="top-headlines?country=in&category=sports&apiKey=3060f357934144d1a18f202ec35d88a4";
    String tesla_key="everything?q=tesla&from=2021-05-30&sortBy=publishedAt&apiKey=3060f357934144d1a18f202ec35d88a4";
    String tech_key="top-headlines?sources=techcrunch&apiKey=3060f357934144d1a18f202ec35d88a4";
    String wsj_key="everything?domains=wsj.com&apiKey=3060f357934144d1a18f202ec35d88a4";


    //Identifying Different country Bussines News

    @GET("top-headlines")
    Call<Headline> getBussinesHeadline(
            @Query("country") String country,
            @Query("category") String category,
            @Query("apiKey") String apiKey);



    @GET(entertainment_key)
    Call<Headline> getEntertainmentHeadline();
    @GET(genral_key)
    Call<Headline> getGenralHeadline();
    @GET(health_key)
    Call<Headline> getHealthHeadline();
    @GET(science_key)
    Call<Headline> getScienceHeadline();
    @GET(sports_key)
    Call<Headline> getSportsHeadline();
    @GET(apple_key)
    Call<Headline> getAppleHeadline();

    @GET(tesla_key)
    Call<Headline> getTeslaHeadline();

    @GET(tech_key)
    Call<Headline> getTechHeadline();

    @GET(wsj_key)
    Call<Headline> getWsjHeadline();



}
