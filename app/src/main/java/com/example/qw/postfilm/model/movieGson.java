package com.example.qw.postfilm.model;

import java.util.List;

/**
 * Created by QW on 2017/4/5.
 */

public class movieGson {
      Rating rating;
      List<Author> author;
      String alt_title;
      String image;
      String title;
      String summary;
      attrs attrs;
      String id;
      String mobile_link;
      String alt;

    public movieGson.Rating getRating() {
        return rating;
    }

    public void setRating2(movieGson.Rating rating) {
        this.rating = rating;
    }



    public movieGson.attrs getAttrs() {
        return attrs;
    }

    public void setAttrs(movieGson.attrs attrs) {
        this.attrs = attrs;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public List<Author> getAuthor() {
        return author;
    }

    public void setAuthor(List<Author> author) {
        this.author = author;
    }

    public String getAlt_title() {
        return alt_title;
    }

    public void setAlt_title(String alt_title) {
        this.alt_title = alt_title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobile_link() {
        return mobile_link;
    }

    public void setMobile_link(String mobile_link) {
        this.mobile_link = mobile_link;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public class attrs{
        List<String> language;
        List<String> pubdate;
        List<String> title;
        List<String> country;
        List<String> writer;
        List<String> director;
        List<String> cast;
        List<String> movie_duration;
        List<String> year;
        List<String> movie_type;


        public List<String> getLanguage() {
            return language;
        }

        public void setLanguage(List<String> language) {
            this.language = language;
        }

        public List<String> getMovie_duration() {
            return movie_duration;
        }

        public void setMovie_duration(List<String> movie_duration) {
            this.movie_duration = movie_duration;
        }


        public List<String> getPubdate() {
            return pubdate;
        }

        public void setPubdate(List<String> pubdate) {
            this.pubdate = pubdate;
        }

        public List<String> getTitle() {
            return title;
        }

        public void setTitle(List<String> title) {
            this.title = title;
        }

        public List<String> getCountry() {
            return country;
        }

        public void setCountry(List<String> country) {
            this.country = country;
        }

        public List<String> getWriter() {
            return writer;
        }

        public void setWriter(List<String> writer) {
            this.writer = writer;
        }

        public List<String> getDirector() {
            return director;
        }

        public void setDirector(List<String> director) {
            this.director = director;
        }

        public List<String> getCast() {
            return cast;
        }

        public void setCast(List<String> cast) {
            this.cast = cast;
        }

        public List<String> getYear() {
            return year;
        }

        public void setYear(List<String> year) {
            this.year = year;
        }

        public List<String> getMovie_type() {
            return movie_type;
        }

        public void setMovie_type(List<String> movie_type) {
            this.movie_type = movie_type;
        }
    }
    public class Rating{
        public Float average;//平均评分
        public Integer numRaters;//参与评分人数

        public Float getAverage() {
            return average;
        }

        public void setAverage(Float average) {
            this.average = average;
        }

        public Integer getNumRaters() {
            return numRaters;
        }

        public void setNumRaters(Integer numRaters) {
            this.numRaters = numRaters;
        }
    }
    public class Author{
        private String name;//导演姓名

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    }


