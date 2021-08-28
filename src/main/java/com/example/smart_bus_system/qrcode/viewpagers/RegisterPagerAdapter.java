package com.example.smart_bus_system.qrcode.viewpagers;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.smart_bus_system.qrcode.fragments.BusDriverRegisterFragment;
import com.example.smart_bus_system.qrcode.fragments.UserRegisterFragment;
import com.example.smart_bus_system.qrcode.listeners.OnDialogStateChangedListener;

import java.util.ArrayList;

public class RegisterPagerAdapter extends FragmentStatePagerAdapter
{
    private Context context;
    ArrayList<Fragment> fragments;
    private OnDialogStateChangedListener listener;

    public RegisterPagerAdapter(@NonNull FragmentManager fm, Context context,OnDialogStateChangedListener listener)
    {
        super(fm);
        this.context = context;
        fragments = new ArrayList<>();
        fragments.add(new UserRegisterFragment(context,listener));
        fragments.add(new BusDriverRegisterFragment(context,listener));
    }

    @NonNull
    @Override
    public Fragment getItem(int position)
    {
       return fragments.get(position);
    }

    @Override
    public int getCount()
    {
        return 2;
    }
}
