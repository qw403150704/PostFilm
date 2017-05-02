package com.example.qw.postfilm.model;

import java.util.List;

/**
 * Created by QW on 2017/4/1.
 */

public class in_theaterGson {
    int count;
    int total;



    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Subjects> subjects;

    public List<Subjects> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subjects> subjectsList) {
        this.subjects = subjectsList;
    }

    public class Subjects{
        private String id;
        private String title;
        private Rating rating;
        private Images images;

        public Rating getRating() {
            return rating;
        }

        public void setRating(Rating rating) {
            this.rating = rating;
        }

        public Images getImages() {
            return images;
        }

        public void setImages(Images images) {
            this.images = images;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
    public class Rating{
        public Float average;

        public Float getAverage() {
            return average;
        }

        public void setAverage(Float average) {
            this.average = average;
        }
    }
    public class Images{
        public String medium;

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }
    }


}
