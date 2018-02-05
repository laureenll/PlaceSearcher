package org.miage.placesearcher.model;

import com.google.gson.annotations.Expose;

/**
 * Created by lloison on 08/01/2018.
 */

public class Place {

    @Expose
    private PropertiesPlace properties;
    @Expose
    private GeometryPlace geometry;

    public Place() {

    }

    public Place(PropertiesPlace properties, GeometryPlace geometry) {
        this.properties = properties;
        this.geometry = geometry;
    }

    public PropertiesPlace getProperties() {
        return properties;
    }

    public void setProperties(PropertiesPlace properties) {
        this.properties = properties;
    }

    public GeometryPlace getGeometry() {
        return geometry;
    }

    public void setGeometry(GeometryPlace geometry) {
        this.geometry = geometry;
    }
}
