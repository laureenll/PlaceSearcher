package org.miage.placesearcher.services;

import org.miage.placesearcher.model.PlaceSearchResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by lloison on 05/02/2018.
 */

public interface PlaceSearchServiceREST {
    @GET("search/")
    Call<PlaceSearchResult> searchForPlaces(@Query("q") String search);
}
