package com.example.myearthquake;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private static final String USGS_REQUEST_URL =
            "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&orderby=time&minmag=6&limit=10";
    private ArrayList<EarthQuake> earthQuakes = new ArrayList<>();
    //ArrayList<EarthQuake> earthQuakesAsync = new ArrayList<EarthQuake>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.list);
        listView.setOnItemClickListener(this);
        EarthQuakeAsync task = new EarthQuakeAsync();
        task.execute(USGS_REQUEST_URL);
        try {
            earthQuakes = task.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        EarthQuakeAdapter adapter = new EarthQuakeAdapter(MainActivity.this,R.layout.earth_quake_list_item,this.earthQuakes);
        Log.e("a7a",""+earthQuakes.size());

        for(int i = 0 ; i < earthQuakes.size() ;i++){

            Log.e("Element number " , earthQuakes.get(i).getEarthQuake_Place());
        }
        listView.setAdapter(adapter);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        EarthQuake earthQuake = (EarthQuake) parent.getItemAtPosition(position);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(earthQuake.getEarthQuake_url()));
        startActivity(intent);
    }

    private class EarthQuakeAsync extends AsyncTask<String, Void, ArrayList<EarthQuake>>{

        @Override
        protected ArrayList<EarthQuake> doInBackground(String... strings) {

            try {
                URL url = new URL(strings[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();
                InputStream stream = urlConnection.getInputStream();

                BufferedReader reader = new BufferedReader(new InputStreamReader(stream, "iso-8859-1"), 8);
                StringBuilder sb = new StringBuilder();
                String line = null;
                while ((line = reader.readLine()) != null) {
                    sb.append(line + "\n");
                }
                stream.close();


                JSONObject root = new JSONObject(sb.toString());
                JSONArray features = root.getJSONArray("features");
                for (int i =0;i<features.length();i++){
                    JSONObject featuresByIndex = features.getJSONObject(i);
                    JSONObject properties = featuresByIndex.getJSONObject("properties");
                    String place_full = properties.getString("place");
                    String [] place = place_full.split(",");
                    long time_full = properties.getLong("time");
                    Log.e("xxxxxxxxxxxx",""+properties.getDouble("mag"));
                    Log.e("xxxxxxxxxxxx",""+place[0]);


                    //Log.e("xxxxxxxxxxxx",""+place[1]);
                    Log.e("xxxxxxxxxxxx",""+DateFormat.getDateInstance().format(time_full));
                    Log.e("xxxxxxxxxxxx",""+DateFormat.getTimeInstance().format(time_full));
                    Log.e("xxxxxxxxxxxx",""+properties.getString("url"));

                    earthQuakes.add(new EarthQuake(properties.getDouble("mag"),""+place[0],""+place[0], DateFormat.getDateInstance().format(time_full),DateFormat.getTimeInstance().format(time_full),properties.getString("url")));
                    //earthQuakes.add(new EarthQuake(50.5,"","","","",""));
                }


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return earthQuakes;
        }

        @Override
        protected void onPostExecute(ArrayList<EarthQuake> earthQuake) {

        }
    }


}
