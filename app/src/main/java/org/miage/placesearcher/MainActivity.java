package org.miage.placesearcher;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.EventLog;
import android.util.Log;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import org.miage.placesearcher.event.EventBusManager;
import org.miage.placesearcher.services.PlaceSearchService;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "main";
    @BindView(R.id.helloWordMsg) TextView helloWordMsg;
    @BindView(R.id.ratingBarTest) RatingBar ratingBarTest;
    @BindView(R.id.exercice6ButtonPage) Button exercice6ButtonPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
    @Override
    public void onResume() {
        // onResume appelé à chaque chargement de la page
        super.onResume();
        // ajoute 1 à chaque reouverture de la page
        ratingBarTest.setRating(ratingBarTest.getRating()+1);
    }

    // click sur le text retire une étoile
    @OnClick(R.id.helloWordMsg)
    public void onClickMe() {
        Toast.makeText(getBaseContext(), "click text",
                Toast.LENGTH_SHORT).show();
        ratingBarTest.setRating(ratingBarTest.getRating()-1);
    }

    // vers une autre page activity pour l'exercice 6
    @OnClick(R.id.exercice6ButtonPage)
    public void changePage() {
        Toast.makeText(getBaseContext(), "change page",
                Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, Exercice6Activity.class);
        startActivity(intent);
    }

}
