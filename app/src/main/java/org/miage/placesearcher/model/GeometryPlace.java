package org.miage.placesearcher.model;

/**
 * Created by lloison on 05/02/2018.
 */

public class GeometryPlace {
    private double[] coordinates;
    private String type;

    public GeometryPlace() {
    }

    public double[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(double[] coordinates) {
        this.coordinates = coordinates;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
