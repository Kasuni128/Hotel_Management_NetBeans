package com.example.smart_bus_system.qrcode.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
import com.example.smart_bus_system.qrcode.listeners.OnDialogStateChangedListener;
import com.example.smart_bus_system.qrcode.models.Journey;
import com.example.smart_bus_system.qrcode.recyclerAdapters.PassengerListAdapter;

import java.util.ArrayList;

import static com.example.smart_bus_system.qrcode.activities.LoginScreen.BUSES_FIREBASE_ROOT_PATH;
import static com.example.smart_bus_system.qrcode.fragments.UserRegisterFragment.PASSENGER_FIREBASE_ROOT_PATH;

public class PassengerListFragment extends Fragment
{
    private RecyclerView rv_list;
    private PassengerListAdapter adapter;
    private ArrayList<Journey> list;
    private Context context;
    private OnDialogStateChangedListener listener;
    private TextView tv_empty_list;

    public PassengerListFragment(Context context,OnDialogStateChangedListener listener)
    {
        this.context = context;
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.passenger_list,container,false);
        initViews(view);
        return view;
    }

    private void initViews(View view)
    {
        listener.show();

        list = new ArrayList<>();
        rv_list = view.findViewById(R.id.rv_list);
        tv_empty_list = view.findViewById(R.id.tv_empty_list);

        adapter = new PassengerListAdapter(context,list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);

        rv_list.setLayoutManager(layoutManager);
        rv_list.setAdapter(adapter);

        String busId = UserState.getBusId(context);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference(BUSES_FIREBASE_ROOT_PATH).child(busId).child("AllPassengers");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                list.clear();
                adapter.notifyDataSetChanged();
                if(snapshot.exists())
                {
                    tv_empty_list.setVisibility(View.INVISIBLE);
                }
                else
                {
                    tv_empty_list.setVisibility(View.VISIBLE);
                }
                for(DataSnapshot dss: snapshot.getChildren())
                {
                    Journey journey = dss.getValue(Journey.class);
                    list.add(journey);
                    adapter.notifyDataSetChanged();
                }
                listener.hide();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error)
            {
                tv_empty_list.setVisibility(View.VISIBLE);
                listener.hide();
            }
        });

    }
}
