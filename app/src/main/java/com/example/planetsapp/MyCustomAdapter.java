package com.example.planetsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MyCustomAdapter extends ArrayAdapter<Planet> {

    //Using Custom objects from Planet class --> extends ArrayAdapter<Planet>

    private ArrayList<Planet> planetsArrayList;
    Context context;

    public MyCustomAdapter( ArrayList<Planet> planetsArrayList, Context context1) {
        super(context1, R.layout.item_list_layout, planetsArrayList);
        this.planetsArrayList = planetsArrayList;
        this.context = context1;
    }

    //View Holder : Without View Holder class adapter has to findViewById everytime it need to access the view in layout.
    //              It is used to cache references to the views within an item layout, do that they don't need to be
    //              repeatedly looked up during scrolling.

    private static class MyViewHolder{
        TextView planetName;
        TextView moonCount;
        ImageView planetImg;
    }

    //getView() : used to create and return a view for
    //            a specific item in the list.


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Planet planet = getItem(position);

        //Inflate Layout
        MyViewHolder myViewHolder;
        final View result;

        if(convertView == null){
            myViewHolder = new MyViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(
                    R.layout.item_list_layout,
                    parent,
                    false
            );
        // Finding Views:

        myViewHolder.planetName = (TextView)  convertView.findViewById(R.id.planetText);
        myViewHolder.moonCount = (TextView) convertView.findViewById(R.id.moonText);
        myViewHolder.planetImg = (ImageView) convertView.findViewById(R.id.imageView);

        result = convertView;

        convertView.setTag(myViewHolder);
        }else{
            //the view is recycled
            myViewHolder = (MyViewHolder) convertView.getTag();
            result = convertView;
        }

        myViewHolder.planetName.setText(planet.getPlanetName());
        myViewHolder.moonCount.setText(planet.getMoonName());
        myViewHolder.planetImg.setImageResource(planet.getPlanetImage());

        return result;
    }
}
