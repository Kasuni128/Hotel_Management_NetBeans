package com.example.smart_bus_system.qrcode.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.example.smart_bus_system.R;
import com.example.smart_bus_system.qrcode.activities.LoginScreen;
import com.example.smart_bus_system.qrcode.listeners.OnDialogStateChangedListener;
import com.example.smart_bus_system.qrcode.listeners.OnStateChange;
import com.example.smart_bus_system.qrcode.models.BusDriver;

public class BusDriverRegisterFragment extends Fragment
{

    private EditText bus_no,bus_root,license_id,drivers_name,number,password,confirm_pw;

    private DatabaseReference reference;
    private static String BUSES_FIREBASE_ROOT_PATH = "Buses";

    private Context context;
    private OnDialogStateChangedListener dialog;

    public BusDriverRegisterFragment(Context context,OnDialogStateChangedListener dialog)
    {
        this.context = context;
        this.dialog = dialog;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.activity_register_bus,container,false);
        initViews(view);
        return view;
    }

    private void initViews(View view)
    {
        bus_no = view.findViewById(R.id.bus_no);
        bus_root =  view.findViewById(R.id.bus_root);
        license_id =  view.findViewById(R.id.license_id);
        drivers_name =  view.findViewById(R.id.drivers_name);
        number =  view.findViewById(R.id.number);
        password =  view.findViewById(R.id.password);
        confirm_pw =  view.findViewById(R.id.confirm_pw);



        reference = FirebaseDatabase.getInstance().getReference(BUSES_FIREBASE_ROOT_PATH);
    }
    private EditText validateIsEmpty()
    {
        bus_no.setError(null);
        bus_root.setError(null);
        license_id.setError(null);
        drivers_name.setError(null);
        number.setError(null);
        password.setError(null);
        confirm_pw.setError(null);


        if(bus_no.getText().toString().trim().isEmpty())
        {
            return bus_no;
        }
        else if(bus_root.getText().toString().trim().isEmpty())
        {
            return bus_root;
        }
        else if(license_id.getText().toString().trim().isEmpty())
        {
            return license_id;
        }
        else if(drivers_name.getText().toString().trim().isEmpty())
        {
            return drivers_name;
        }
        else if(number.getText().toString().trim().isEmpty())
        {
            return number;
        }
        else if(password.getText().toString().trim().isEmpty())
        {
            return password;
        }
        else if(confirm_pw.getText().toString().trim().isEmpty())
        {
            return confirm_pw;
        }
        return null;
    }
    private boolean validatePassword()
    {
        if(password.getText().toString().trim().equals(confirm_pw.getText().toString().trim()))
        {
            return true;
        }
        password.setError("Password mismatched");
        confirm_pw.setError("Password mismatched");

        return false;
    }
    private void register()
    {


        String busNo = bus_no.getText().toString();
        String busRoot = bus_root.getText().toString();
        String licenseId = license_id.getText().toString();
        String driversName = drivers_name.getText().toString();
        String mNumber = number.getText().toString();
        String passwordText = password.getText().toString();


        BusDriver busDriver = new BusDriver();
        busDriver.setBusNo(busNo);
        busDriver.setBusRoot(busRoot);
        busDriver.setDriversName(driversName);
        busDriver.setLicenseId(licenseId);
        busDriver.setNumber(mNumber);
        busDriver.setPassword(passwordText);

        reference.child(busNo).setValue(busDriver).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task)
            {
                if(task.isSuccessful())
                {
                    Toast.makeText(context, "Registration success", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(context, LoginScreen.class));
                    dialog.finishActivity();
                }
                else
                {
                    Toast.makeText(context, "Failed to register", Toast.LENGTH_SHORT).show();
                }
                dialog.hide();


            }
        });


    }
    public void isBusAlreadyExists(OnStateChange listener)
    {
        String busNumber = bus_no.getText().toString();

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                if(snapshot.exists())
                {
                    boolean isNumberTaken = false;
                    for(DataSnapshot dss: snapshot.getChildren())
                    {
                        BusDriver driver = dss.getValue(BusDriver.class);
                        if(driver != null)
                        {
                            if(driver.getBusNo().equals(busNumber))
                            {
                                isNumberTaken = true;
                                listener.taken();
                                break;
                            }
                        }
                    }
                    if(!isNumberTaken)
                    {
                        listener.notTaken();
                    }
                }
                else
                {
                    listener.notTaken();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void pressRegisterButton()
    {
        EditText editText = validateIsEmpty();

        if(editText == null)
        {
            if(validatePassword())
            {
                dialog.show();
                isBusAlreadyExists(new OnStateChange() {
                    @Override
                    public void taken()
                    {
                        bus_no.setError("Bus No is already exists");
                        dialog.hide();
                    }

                    @Override
                    public void notTaken()
                    {
                        register();
                    }
                });

            }
        }
        else
        {
            editText.setError("Please fill this field!");
        }
    }
}
