package com.example.myearthquake;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class EarthQuakeAdapter extends ArrayAdapter<EarthQuake> {
    private Context context;
    private ArrayList<EarthQuake> earthQuakes;

    public EarthQuakeAdapter(@androidx.annotation.NonNull Context context, int resource, @androidx.annotation.NonNull ArrayList<EarthQuake> earthQuakes) {
        super(context, resource, earthQuakes);
        this.context = context;
        this.earthQuakes = earthQuakes;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.earth_quake_list_item, null);

        EarthQuake currentEarthQuake = earthQuakes.get(position);

        TextView earthquake_Mag, nearby_place_tv, earthquake_place_tv, earthquake_date_tv, earthquake_time_tv;
        earthquake_Mag = view.findViewById(R.id.earthquake_Mag);
        nearby_place_tv = view.findViewById(R.id.nearby_place_tv);
        earthquake_place_tv = view.findViewById(R.id.earthquake_place_tv);
        earthquake_date_tv = view.findViewById(R.id.earthquake_date_tv);
        earthquake_time_tv = view.findViewById(R.id.earthquake_time_tv);


        earthquake_Mag.setText(String.valueOf(currentEarthQuake.getEarthQuake_mag()));
        nearby_place_tv.setText(currentEarthQuake.getEarthQuake_nearbyPlace());
        earthquake_place_tv.setText(currentEarthQuake.getEarthQuake_Place());
        earthquake_date_tv.setText(currentEarthQuake.getEarthQuake_date());
        earthquake_time_tv.setText(currentEarthQuake.getEarthQuake_time());

        //for color changing
        GradientDrawable gradientDrawable = (GradientDrawable) earthquake_Mag.getBackground();
        if (currentEarthQuake.getEarthQuake_mag() <= 1){
            gradientDrawable.setColor(ContextCompat.getColor(getContext(),R.color.magnitude1));
        }else if (currentEarthQuake.getEarthQuake_mag() <= 2){
            gradientDrawable.setColor(ContextCompat.getColor(getContext(),R.color.magnitude2));
        }else if (currentEarthQuake.getEarthQuake_mag() <= 3){
            gradientDrawable.setColor(ContextCompat.getColor(getContext(),R.color.magnitude3));
        }else if (currentEarthQuake.getEarthQuake_mag() <= 4){
            gradientDrawable.setColor(ContextCompat.getColor(getContext(),R.color.magnitude4));
        } else if (currentEarthQuake.getEarthQuake_mag() <= 5){
            gradientDrawable.setColor(ContextCompat.getColor(getContext(),R.color.magnitude5));
        } else if (currentEarthQuake.getEarthQuake_mag() <= 6){
            gradientDrawable.setColor(ContextCompat.getColor(getContext(),R.color.magnitude6));
        } else if (currentEarthQuake.getEarthQuake_mag() <= 7){
            gradientDrawable.setColor(ContextCompat.getColor(getContext(),R.color.magnitude7));
        } else if (currentEarthQuake.getEarthQuake_mag() <= 8){
            gradientDrawable.setColor(ContextCompat.getColor(getContext(),R.color.magnitude8));
        } else if (currentEarthQuake.getEarthQuake_mag() <= 9){
            gradientDrawable.setColor(ContextCompat.getColor(getContext(),R.color.magnitude9));
        } else if (currentEarthQuake.getEarthQuake_mag() <= 10){
            gradientDrawable.setColor(ContextCompat.getColor(getContext(),R.color.magnitude10plus));
        }else{
            gradientDrawable.setColor(ContextCompat.getColor(getContext(),R.color.magnitude10plus));
        }

        return view;
    }
}
