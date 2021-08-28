package com.example.smart_bus_system.qrcode.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.example.smart_bus_system.R;
import com.example.smart_bus_system.qrcode.config.UserState;
import com.example.smart_bus_system.qrcode.listeners.JourneyListAdapterListener;
import com.example.smart_bus_system.qrcode.listeners.OnDialogStateChangedListener;
import com.example.smart_bus_system.qrcode.models.Journey;
import com.example.smart_bus_system.qrcode.models.Passenger;
import com.example.smart_bus_system.qrcode.recyclerAdapters.JourneyListAdapter;

import java.util.ArrayList;

import static com.example.smart_bus_system.qrcode.fragments.UserRegisterFragment.PASSENGER_FIREBASE_ROOT_PATH;

public class PassengerJourneyListFragment extends Fragment
{
    private Context context;
    private JourneyListAdapter adapter;
    private ArrayList<Journey> journeyList;
    private RecyclerView rv_journey_list;
    private TextView tv_empty_list;
    private OnDialogStateChangedListener dialog;
    private JourneyListAdapterListener listener;

    public PassengerJourneyListFragment(Context context,OnDialogStateChangedListener dialog,JourneyListAdapterListener listener)
    {
        this.context = context;
        this.dialog = dialog;
        this.listener = listener;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.layout_passenger_journey_list,container,false);
        initViews(view);
        return view;
    }

    private void initViews(View view)
    {

        dialog.show();

        rv_journey_list = view.findViewById(R.id.rv_journey_list);
        tv_empty_list = view.findViewById(R.id.tv_empty_list);

        journeyList = new ArrayList<>();
        adapter = new JourneyListAdapter(context,journeyList,listener);
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setReverseLayout(true);
        manager.setStackFromEnd(true);
        rv_journey_list.setLayoutManager(manager);
        rv_journey_list.setAdapter(adapter);

        String userId = UserState.getPassengerId(context);


        DatabaseReference reference = FirebaseDatabase.getInstance().getReference(PASSENGER_FIREBASE_ROOT_PATH).child(userId).child("AllJourneys");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                journeyList.clear();
                adapter.notifyDataSetChanged();

                if(snapshot.exists())
                {
                    tv_empty_list.setVisibility(View.INVISIBLE);
                    for(DataSnapshot dss : snapshot.getChildren())
                    {
                        Journey journey = dss.getValue(Journey.class);
                        journeyList.add(journey);
                        adapter.notifyDataSetChanged();

                    }

                }
                else
                {
                    tv_empty_list.setVisibility(View.VISIBLE);
                }

                dialog.hide();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error)
            {
                tv_empty_list.setVisibility(View.VISIBLE);
                dialog.hide();
            }
        });

    }
}
