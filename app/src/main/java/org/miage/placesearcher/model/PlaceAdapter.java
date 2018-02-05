package org.miage.placesearcher.model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.miage.placesearcher.R;

import java.util.Collection;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lloison on 08/01/2018.
 */
public class PlaceAdapter extends ArrayAdapter<Place> {
    @BindView(R.id.codePostalText)
    TextView codePostal;

    @BindView(R.id.cityText)
    TextView cityText;

    @BindView(R.id.streetText)
    TextView streetText;


    public PlaceAdapter(Context context, List<Place> places) {
        super(context, -1, places);
    }

    @Override
    public View getView(int i, View convertView, @NonNull ViewGroup parent) {
        View actualView = convertView;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            actualView = inflater.inflate(R.layout.list_item_city, parent, false);
        }
        ButterKnife.bind(this, actualView);
        streetText.setText(getItem(i) != null && getItem(i).getProperties() != null ? getItem(i).getProperties().getName() : "");
        codePostal.setText(getItem(i) != null && getItem(i).getProperties() != null ? getItem(i).getProperties().getCitycode(): "");
        cityText.setText(getItem(i) != null && getItem(i).getProperties() != null ? getItem(i).getProperties().getCity() : "");

        return actualView;
    }

    @Override
    public void clear() {
        super.clear();
    }

    @Override
    public void addAll(@NonNull Collection<? extends Place> collection) {
        super.addAll(collection);
    }
}
