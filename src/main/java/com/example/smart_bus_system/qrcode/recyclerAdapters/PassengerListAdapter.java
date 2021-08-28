package com.example.smart_bus_system.qrcode.recyclerAdapters;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smart_bus_system.R;
import com.example.smart_bus_system.qrcode.listeners.JourneyListAdapterListener;
import com.example.smart_bus_system.qrcode.models.Journey;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PassengerListAdapter extends RecyclerView.Adapter<PassengerListAdapter.MyViewHolder>
{

    private ArrayList<Journey> journeyList;
    private Context context;

    public PassengerListAdapter(Context context, ArrayList<Journey> journeyList)
    {
        this.journeyList = journeyList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.passenger_list_item,parent,false);
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

        if(journey.getPassengerName() != null && !journey.getPassengerName().isEmpty())
        holder.user_name.setText(journey.getPassengerName());

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
            }
        }




    }

    @Override
    public int getItemCount()
    {
        return journeyList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView user_name,date,start_location,to_location,start_time,exit_time;

        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            user_name = itemView.findViewById(R.id.user_name);
            date = itemView.findViewById(R.id.date);
            start_location = itemView.findViewById(R.id.start_location);
            to_location = itemView.findViewById(R.id.to_location);
            start_time = itemView.findViewById(R.id.start_time);
            exit_time = itemView.findViewById(R.id.exit_time);

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

            return addresses.get(0).getThoroughfare();

        }
        catch (Exception e)
        {
            return null;
        }

    }
}
