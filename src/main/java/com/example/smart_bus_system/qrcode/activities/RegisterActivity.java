package com.example.smart_bus_system.qrcode.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;
import com.example.smart_bus_system.R;
import com.example.smart_bus_system.qrcode.fragments.BusDriverRegisterFragment;
import com.example.smart_bus_system.qrcode.fragments.UserRegisterFragment;
import com.example.smart_bus_system.qrcode.listeners.OnDialogStateChangedListener;
import com.example.smart_bus_system.qrcode.viewpagers.RegisterPagerAdapter;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {


    private ViewPager register_pager;
    private RegisterPagerAdapter adapter;
    private TabLayout tabLayout;
    private Button sign_up;

    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        register_pager = findViewById(R.id.register_pager);
        tabLayout = findViewById(R.id.tabLayout);
        sign_up = findViewById(R.id.sign_up);


        dialog = new ProgressDialog(RegisterActivity.this);
        dialog.setMessage("In Progress");
        dialog.setCancelable(true);

        adapter = new RegisterPagerAdapter(getSupportFragmentManager(), getApplicationContext(), new OnDialogStateChangedListener() {
            @Override
            public void show()
            {
                dialog.show();
            }

            @Override
            public void hide()
            {
                dialog.hide();
            }

            @Override
            public void finishActivity() {
                finish();
            }
        });
        register_pager.setAdapter(adapter);

        tabLayout.setupWithViewPager(register_pager);

        setupTabIcons();

        sign_up.setOnClickListener(this);






    }
    private void setupTabIcons()
    {
        int[] tabIcons = {
                R.drawable.ic_user_white,
                R.drawable.ic_bus_white
        };

        String[] tabTexts = {
                "Passenger",
                "Driver"
        };

        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(0).setText(tabTexts[0]);

        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(1).setText(tabTexts[1]);



    }

    public void openLoginScreen(View view)
    {
        startActivity(new Intent(RegisterActivity.this, LoginScreen.class));
    }

    @Override
    public void onClick(View view)
    {
        if(view.getId() == sign_up.getId())
        {
            int pos = register_pager.getCurrentItem();
            if(pos == 0)
            {
                UserRegisterFragment fragment = (UserRegisterFragment) adapter.getItem(pos);
                fragment.pressRegisterButton();
            }
            else if (pos == 1)
            {
                BusDriverRegisterFragment fragment = (BusDriverRegisterFragment) adapter.getItem(pos);
                fragment.pressRegisterButton();
            }
        }
    }
}