package org.miage.placesearcher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.miage.placesearcher.model.Place;
import org.miage.placesearcher.model.PlaceAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Place itemAtPosition = (Place) arrayAdapter.getItem(position);
        Toast.makeText(getBaseContext(), "You selected place : " + itemAtPosition.getId(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Exercice6Activity.this, PlaceDetailsActivity.class);
        intent.putExtra("streetItem", itemAtPosition.getStreet());
        intent.putExtra("idItem", Integer.valueOf(itemAtPosition.getId()).toString());
        startActivity(intent);
    }
}
