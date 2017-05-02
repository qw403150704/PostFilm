package com.example.qw.postfilm.model;

import android.graphics.Bitmap;

import java.util.List;

/**
 * Created by QW on 2017/3/22.
 */

public class Film {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }




    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    //Film 构造函数
    public Film(String id,Float rating,String title,String url,Bitmap image,List<String> pubdata,List<String> language,String year,String genres,String summary){

        this.id = id;
        this.rating = rating;
        this.title = title;
        this.url = url;
        this.image = image;
        this.pubdata=pubdata;
        this.language = language;
        this.year = year;
        this.genres = genres;
        this.summary = summary;

    }
    public Film(String id,Float rating,String title,Bitmap image){

        this.id = id;
        this.rating = rating;
        this.title = title;
        this.image = image;
    }
//    //测试
//    public Film(String id,Float rating,String title,String imageUrl){
//        this.id = id;
//        this.rating = rating;
//        this.title = title;
//        this.imageUrl = imageUrl;
//    }
    private String id;//条目ID
    private Float rating;//评价星级
    private String title;//中文名
    private String url;//条目页Url
    private Bitmap image;//图片Bitmap对象
    private List<String> pubdata;//大陆上映日期
    private List<String> language;//语种
    private String year;//年代
//    private String imageUrl;//图片Url

//    public String getImageUrl() {
//        return imageUrl;
//    }
//
//    public void setImageUrl(String imageUrl) {
//        this.imageUrl = imageUrl;
//    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    private String genres;//类型
    private String summary;//简介
    private String country;//国家

    public List<String> getPubdata() {
        return pubdata;
    }

    public void setPubdata(List<String> pubdata) {
        this.pubdata = pubdata;
    }
    public List<String> getLanguage() {
        return language;
    }

    public void setLanguage(List<String> language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    private String duration;//持续时间
}
