package org.miage.placesearcher;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

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

        // requete GET HTTP
        /*OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api-adresse.data.gouv.fr/search/?q=Place%20du%20commerce")
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            // callback error
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            // callback success
            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                }
                Toast.makeText(getBaseContext(), "success",
                        Toast.LENGTH_SHORT).show();
            }
        });*/
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
