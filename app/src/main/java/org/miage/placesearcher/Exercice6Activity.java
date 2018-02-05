package org.miage.placesearcher;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.otto.Subscribe;

import org.miage.placesearcher.event.EventBusManager;
import org.miage.placesearcher.event.SearchResultEvent;
import org.miage.placesearcher.model.Place;
import org.miage.placesearcher.model.PlaceAdapter;
import org.miage.placesearcher.model.PlaceSearchResult;
import org.miage.placesearcher.services.PlaceSearchService;
import org.miage.placesearcher.services.PlaceSearchServiceREST;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Exercice6Activity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @BindView(R.id.listViewTest)
    ListView listView;

    @BindView(R.id.choixPlaceId)
    EditText placeRecherchee;

    private ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice6);
        ButterKnife.bind(this);

       /* List<Place> listePlaces = new ArrayList<>();
        arrayAdapter = new PlaceAdapter(this, listePlaces);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);*/


        //appelRESTsearchPlaces("Place%20du%20commerce");

    }

    private void appelRESTsearchPlaces(String placeSearch) {
        final Exercice6Activity _this = this;

        // Exercice requete GET HTTP avec Retrofit
        // convertisseur JSON to Java object
        Gson gsonConverter;
        gsonConverter = new GsonBuilder()
                .excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC)
                .serializeNulls()
                .excludeFieldsWithoutExposeAnnotation().create();

        // init Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .client(new OkHttpClient())
                .baseUrl("https://api-adresse.data.gouv.fr/")
                .addConverterFactory(GsonConverterFactory.create(gsonConverter))
                .build();

        // appel service REST avec retrofit
        PlaceSearchServiceREST placeSearchServiceREST = retrofit.create(PlaceSearchServiceREST.class);
        placeSearchServiceREST.searchForPlaces("search/" + placeSearch).enqueue(new Callback<PlaceSearchResult>() {
            @Override
            public void onResponse(Call<PlaceSearchResult> call, retrofit2.Response<PlaceSearchResult> response) {
                PlaceSearchResult result = response.body();
                if (result != null) {
                    arrayAdapter = new PlaceAdapter(_this, result.features);
                    listView.setAdapter(arrayAdapter);
                    listView.setOnItemClickListener(_this);
                }
            }

            @Override
            public void onFailure(Call<PlaceSearchResult> call, Throwable t) {
                new Exception("erreur appel REST");
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();


        // déclaration asyntask et event bus
        /*AsyncTask<String, Void, Response> liste = placeSearchService.getListe("https://api-adresse.data.gouv.fr/search/?q=Place%20du%20commerce");
        EventBusManager.BUS.register(this);*/
    }


    @Override
    protected void onPause() {
        /*EventBusManager.BUS.unregister(this);*/
        super.onPause();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Place itemAtPosition = (Place) arrayAdapter.getItem(position);
        Toast.makeText(getBaseContext(), "You selected place : " + itemAtPosition.getProperties().getId(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Exercice6Activity.this, PlaceDetailsActivity.class);
        intent.putExtra("streetItem", itemAtPosition.getProperties().getName());
        intent.putExtra("cityItem", itemAtPosition.getProperties().getCity());
        intent.putExtra("codeItem", itemAtPosition.getProperties().getCitycode());
        intent.putExtra("idItem", itemAtPosition.getProperties().getId());
        startActivity(intent);
    }

    @Subscribe
    public void searchresult(SearchResultEvent event) {
        arrayAdapter = new PlaceAdapter(this, event.getListePlaces());
        listView.setAdapter(arrayAdapter);
    }

    @OnTextChanged(R.id.choixPlaceId)
    public void onTextAdresseSearch(CharSequence text) {
        if (text.toString().length() > 2) {
            appelRESTsearchPlaces(text.toString());
        }
    }
}
