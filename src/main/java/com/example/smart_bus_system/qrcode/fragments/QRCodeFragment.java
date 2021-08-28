package com.example.smart_bus_system.qrcode.fragments;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.google.zxing.Result;
import com.example.smart_bus_system.R;
import com.example.smart_bus_system.qrcode.activities.Scanner;
import com.example.smart_bus_system.qrcode.config.UserState;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class QRCodeFragment extends Fragment
{
    private CodeScanner mCodeScanner;
    private Context context;

    public QRCodeFragment(Context context)
    {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.activity_bus_dashboard,container,false);
        initViews(view);
        return view;
    }

    private void initViews(View view)
    {
        ImageView qr_image = view.findViewById(R.id.qr_image);


        String code = UserState.getBusId(context);

        QRGEncoder qrgEncoder = new QRGEncoder(code, null, QRGContents.Type.TEXT, 500);
        qrgEncoder.setColorBlack(Color.BLACK);
        qrgEncoder.setColorWhite(Color.WHITE);
        Bitmap bitmap = qrgEncoder.getBitmap();
        qr_image.setImageBitmap(bitmap);
    }
}
