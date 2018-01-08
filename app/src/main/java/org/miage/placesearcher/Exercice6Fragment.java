package org.miage.placesearcher;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 */
public class Exercice6Fragment extends Fragment {
    @BindView(R.id.exercice6Fragment)
    ListView listView;

    private Unbinder unbinder;

    public Exercice6Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    //test commit

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_exercice6, container, false);
        unbinder = ButterKnife.bind(this, view);
        String[] listItems = new String[]{"item1", "item2", "item3"};
        /*ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.id.simple_list_item_1, listItems);
        listView.setAdapter(arrayAdapter);*/
        return view;
    }

}
