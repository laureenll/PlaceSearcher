package org.miage.placesearcher.event;

import org.miage.placesearcher.model.Place;

import java.util.List;

/**
 * Created by lloison on 15/01/2018.
 */

public class SearchResultEvent {
    private List<Place> listePlaces;

    public SearchResultEvent(List<Place> listePlaces) {
        this.listePlaces = listePlaces;
    }

    public List<Place> getListePlaces() {
        return listePlaces;
    }
}
