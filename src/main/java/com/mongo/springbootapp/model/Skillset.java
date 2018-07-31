package com.mongo.springbootapp.model;

public class Skillset {
    private String skill;
    private Integer rating;
    private Boolean endorsed;

    protected Skillset() {}

    public Skillset(String skill, int rating, boolean endorsed) {
        this.skill = skill;
        this.rating = rating;
        this.endorsed = endorsed;
    }

    public String getSkill() {
        return skill;
    }

    public Integer getRating() {
        return rating;
    }

    public Boolean isEndorsed() {
        return endorsed;
    }
}
