package org.miage.placesearcher;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URL;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PlaceDetailsActivity extends AppCompatActivity {

    private static final int SELECT_PHOTO = 0;
    private static final int SEND_PHOTO = 1;
    @BindView(R.id.textId)
    TextView textId;
    @BindView(R.id.textStreet)
    TextView textStreet;
    @BindView(R.id.idImageImport)
    ImageView imgImport;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_details);
        ButterKnife.bind(this);
        String streetItem = getIntent().getStringExtra("streetItem");
        String idItem = getIntent().getStringExtra("idItem");
        textId.setText(idItem);
        textStreet.setText(streetItem);
    }

    @OnClick(R.id.textId)
    public void onClickMe() {
        PlaceDetailsActivity.this.finish();
    }

    @OnClick(R.id.buttonGoogleSearch)
    public void onClickGoogleMe() {
        Uri urlGoogle = Uri.parse("geo:0,0?q=" + getIntent().getStringExtra("streetItem"));
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW);
        launchBrowser.setData(urlGoogle);
        startActivity(launchBrowser);
    }

    @OnClick(R.id.buttonPartageLocalisation)
    public void onClickShareMe() {
        Intent launchBrowser = new Intent(Intent.ACTION_SEND);
        launchBrowser.putExtra(Intent.EXTRA_TEXT, getIntent().getStringExtra("streetItem"));
        launchBrowser.setType("text/plain");
        startActivity(launchBrowser);
    }

    @OnClick(R.id.buttonIdImportImg)
    public void onClickImportMe() {
        Intent photoImport = new Intent(Intent.ACTION_PICK);
        photoImport.setType("image/*");
        startActivityForResult(photoImport, SELECT_PHOTO);
    }

    @OnClick(R.id.buttonSendImage)
    public void onClickSendMe() {
        // choisir image
        Intent photoImport = new Intent(Intent.ACTION_PICK);
        photoImport.setType("image/*");
        startActivityForResult(photoImport, SEND_PHOTO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode) {
            case SELECT_PHOTO:
                if(resultCode == RESULT_OK) {
                    Uri selectImg = data.getData();
                    imgImport.setImageURI(selectImg);
                }
            case SEND_PHOTO:
                if(resultCode == RESULT_OK) {
                    Uri selectImg = data.getData();
                    // envoi image vers destinataire
                    Intent launchBrowser = new Intent(Intent.ACTION_SEND);
                    launchBrowser.putExtra(Intent.EXTRA_STREAM, selectImg);
                    launchBrowser.setType("image/*");
                    startActivity(launchBrowser);
                }
        }
    }
}
