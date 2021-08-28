package com.example.smart_bus_system.qrcode.recyclerAdapters;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smart_bus_system.R;
import com.example.smart_bus_system.qrcode.listeners.JourneyListAdapterListener;
import com.example.smart_bus_system.qrcode.models.Journey;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class JourneyListAdapter extends RecyclerView.Adapter<JourneyListAdapter.MyViewHolder>
{

    private ArrayList<Journey> journeyList;
    private Context context;
    private JourneyListAdapterListener listener;

    public JourneyListAdapter(Context context,ArrayList<Journey> journeyList,JourneyListAdapterListener listener)
    {
        this.journeyList = journeyList;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.journey_list_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {

        Journey journey = journeyList.get(position);

        if(journey.getEnteredLatitude() != 0 && journey.getEnteredLongitude() != 0)
        {
            String enteredCity = getLocation(journey.getEnteredLatitude(),journey.getEnteredLongitude());
            if(enteredCity != null)
            {
                holder.start_location.setText(enteredCity);
            }
        }

        if(journey.getBusNo() != null && !journey.getBusNo().isEmpty())
        holder.bus_no.setText(journey.getBusNo());

        if(journey.getEnteredDate() != null && !journey.getEnteredDate().isEmpty())
        holder.date.setText(journey.getEnteredDate());

        if(journey.getEnteredTime() != null && !journey.getEnteredTime().isEmpty())
        holder.start_time.setText(journey.getEnteredTime());


        if(journey.getExitTime() != null && !journey.getExitTime().isEmpty())
            holder.exit_time.setText(journey.getExitTime());

        if(journey.getExitLatitude() != 0 && journey.getExitLongitude() != 0)
        {
            String exitCity = getLocation(journey.getExitLatitude(),journey.getExitLongitude());
            if(exitCity != null)
            {
                holder.to_location.setText(exitCity);
                holder.scan_exit.setVisibility(View.GONE);
            }
        }
        else
        {
            holder.scan_exit.setVisibility(View.VISIBLE);
        }

        holder.scan_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                listener.onScanButtonPressed(journey);
            }
        });



    }

    @Override
    public int getItemCount()
    {
        return journeyList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView bus_no,date,start_location,to_location,start_time,exit_time;
        ConstraintLayout scan_exit;

        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            bus_no = itemView.findViewById(R.id.bus_no);
            date = itemView.findViewById(R.id.date);
            start_location = itemView.findViewById(R.id.start_location);
            to_location = itemView.findViewById(R.id.to_location);
            start_time = itemView.findViewById(R.id.start_time);
            exit_time = itemView.findViewById(R.id.exit_time);

            scan_exit = itemView.findViewById(R.id.scan_exit);
        }
    }
    public String getLocation(double latitude, double longitude)
    {
        try
        {
            Geocoder geocoder;
            List<Address> addresses;
            geocoder = new Geocoder(context, Locale.getDefault());

            addresses = geocoder.getFromLocation(latitude, longitude, 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5

//            String address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
//            String city = addresses.get(0).getLocality();
//            String state = addresses.get(0).getAdminArea();
//            String country = addresses.get(0).getCountryName();
//            String postalCode = addresses.get(0).getPostalCode();
//            String knownName = addresses.get(0).getFeatureName();
            String street = addresses.get(0).getThoroughfare();


            return street;

        }
        catch (Exception e)
        {
            return null;
        }

    }
}
