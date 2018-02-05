package org.miage.placesearcher.model;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Created by lloison on 05/02/2018.
 */

public class PlaceSearchResult {
    @Expose
    public List<Place> features;
}
