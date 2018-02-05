package org.miage.placesearcher.model;

import com.google.gson.annotations.Expose;

/**
 * Created by lloison on 05/02/2018.
 */

public class PropertiesPlace {
    private String postcode;
    private String context;
    @Expose
    private String name;
    @Expose
    private String city;
    private Double x;
    @Expose
    private String id;
    private Double y;
    private Double score;
    @Expose
    private String citycode;
    private String label;
    private String type;
    private Double importance;

    public PropertiesPlace() {
    }

    public PropertiesPlace(String postcode, String context, String name, String city, Double x, String id, Double y, Double score, String citycode, String label, String type, Double importance) {
        this.postcode = postcode;
        this.context = context;
        this.name = name;
        this.city = city;
        this.x = x;
        this.id = id;
        this.y = y;
        this.score = score;
        this.citycode = citycode;
        this.label = label;
        this.type = type;
        this.importance = importance;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getImportance() {
        return importance;
    }

    public void setImportance(Double importance) {
        this.importance = importance;
    }
}
