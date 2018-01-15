package org.miage.placesearcher;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.squareup.otto.Subscribe;

import org.miage.placesearcher.event.EventBusManager;
import org.miage.placesearcher.event.SearchResultEvent;
import org.miage.placesearcher.model.Place;
import org.miage.placesearcher.model.PlaceAdapter;
import org.miage.placesearcher.services.PlaceSearchService;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Response;

public class Exercice6Activity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @BindView(R.id.listViewTest)
    ListView listView;

    private ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice6);
        ButterKnife.bind(this);

        List<Place> listePlaces = new ArrayList<>();
        for (int i=0; i<50; i++) {
            listePlaces.add(new Place(i, 0d, 0d,"rue de la saulziniere", "44000", "Nantes"));
        }

        arrayAdapter = new PlaceAdapter(this, listePlaces);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        // requete GET HTTP
        PlaceSearchService placeSearchService = new PlaceSearchService();
        AsyncTask<String, Void, Response> liste = placeSearchService.getListe("https://api-adresse.data.gouv.fr/search/?q=Place%20du%20commerce");
        EventBusManager.BUS.register(this);
    }


    @Override
    protected void onPause() {
        EventBusManager.BUS.unregister(this);
        super.onPause();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Place itemAtPosition = (Place) arrayAdapter.getItem(position);
        Toast.makeText(getBaseContext(), "You selected place : " + itemAtPosition.getId(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Exercice6Activity.this, PlaceDetailsActivity.class);
        intent.putExtra("streetItem", itemAtPosition.getStreet());
        intent.putExtra("idItem", Integer.valueOf(itemAtPosition.getId()).toString());
        startActivity(intent);
    }

    @Subscribe
    public void searchresult(SearchResultEvent event) {
        arrayAdapter = new PlaceAdapter(this, event.getListePlaces());
        listView.setAdapter(arrayAdapter);
    }
}
