package org.miage.placesearcher.services;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by lloison on 15/01/2018.
 */

public class PlaceSearchService {
    private static final String TAG = "Main activity";

    public AsyncTask<String, Void, Response> getListe(String url) {
        @SuppressLint("StaticFieldLeak")
        AsyncTask<String, Void, Response> asyncTask = new AsyncTask<String, Void, Response>() {
            @Override
            protected Response doInBackground(String... strings) {
                Log.d(TAG, "test do in background");
                final OkHttpClient okHttpClient = new OkHttpClient();
                final Request request = new Request.Builder()
                        .url(strings[0])
                        .build();

                try {
                    Response execute = okHttpClient.newCall(request).execute();
                    Log.d(TAG, execute.body().toString());
                    return execute;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Response response) {
                super.onPostExecute(response);
                Log.d(TAG, "test post execute");
                try {
                    JSONObject jsonObj = new JSONObject(response.body().string());
                    JSONArray features = jsonObj.getJSONArray("features");

                    for (int i=0; i < features.length(); i++) {
                        JSONObject o = features.getJSONObject(i);
                        String label = o.getJSONObject("properties").getString("label");
                        Log.d(TAG, label);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        };
        return asyncTask.execute(url);
    }

}
