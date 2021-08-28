package com.example.smart_bus_system.qrcode.fragments;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.zxing.Result;
import com.example.smart_bus_system.R;
import com.example.smart_bus_system.qrcode.config.UserState;
import com.example.smart_bus_system.qrcode.listeners.OnCodeRetrieved;
import com.example.smart_bus_system.qrcode.models.BusDriver;
import com.example.smart_bus_system.qrcode.models.Journey;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import im.delight.android.location.SimpleLocation;

import static android.content.Context.LOCATION_SERVICE;
import static com.example.smart_bus_system.qrcode.activities.LoginScreen.BUSES_FIREBASE_ROOT_PATH;
import static com.example.smart_bus_system.qrcode.activities.LoginScreen.PASSENGER_FIREBASE_ROOT_PATH;

public class QRCodeScannerFragment extends Fragment
{

    private Context context;
    private CodeScanner mCodeScanner;
    private OnCodeRetrieved listener;

    public QRCodeScannerFragment(Context context,OnCodeRetrieved listener) {
        this.context = context;
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_scanner, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view)
    {


        CodeScannerView scannerView = view.findViewById(R.id.scanner_view);
        mCodeScanner = new CodeScanner(context, scannerView);
        mCodeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull final Result result) {

                String code = result.getText();

                listener.onSuccess(code);

            }
        });
    }



    @Override
    public void onResume() {
        super.onResume();
        mCodeScanner.startPreview();

    }

    @Override
    public void onStop()
    {
        mCodeScanner.releaseResources();
        super.onStop();
    }

}
