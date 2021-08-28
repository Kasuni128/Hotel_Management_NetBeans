package com.example.smart_bus_system.qrcode.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
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
import com.example.smart_bus_system.qrcode.models.Journey;
import com.example.smart_bus_system.qrcode.models.Passenger;

import java.util.ArrayList;
import java.util.List;

public class UserRegisterFragment extends Fragment
{

    private EditText username,first_name,last_name,nic,phone,password,confirm_pw;
    private Context context;
    private OnDialogStateChangedListener dialog;
    private DatabaseReference reference;

    public static String PASSENGER_FIREBASE_ROOT_PATH = "Passengers";

    public UserRegisterFragment(Context context,OnDialogStateChangedListener dialog)
    {
        this.context = context;
        this.dialog = dialog;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.activity_user_register_screen,container,false);
        initViews(view);
        return view;
    }

    private void initViews(View view)
    {
        username = view.findViewById(R.id.username);
        first_name = view.findViewById(R.id.first_name);
        last_name = view.findViewById(R.id.last_name);
        nic = view.findViewById(R.id.nic);
        phone = view.findViewById(R.id.phone);
        password = view.findViewById(R.id.password);
        confirm_pw = view.findViewById(R.id.confirm_pw);

        username.postDelayed(new Runnable() {
            @Override
            public void run() {
                hideSoftKeyboard(username);
            }
        }, 200);

        reference = FirebaseDatabase.getInstance().getReference(PASSENGER_FIREBASE_ROOT_PATH);

    }
    protected void hideSoftKeyboard(EditText input) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(input.getWindowToken(), 0);
    }
    private EditText validateIsEmpty()
    {
        username.setError(null);
        first_name.setError(null);
        last_name.setError(null);
        nic.setError(null);
        phone.setError(null);
        password.setError(null);
        confirm_pw.setError(null);


        if(username.getText().toString().trim().isEmpty())
        {
            return username;
        }
        else if(first_name.getText().toString().trim().isEmpty())
        {
            return first_name;
        }
        else if(last_name.getText().toString().trim().isEmpty())
        {
            return last_name;
        }
        else if(nic.getText().toString().trim().isEmpty())
        {
            return nic;
        }
        else if(phone.getText().toString().trim().isEmpty())
        {
            return phone;
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

        String userName = username.getText().toString();
        String firstName = first_name.getText().toString();
        String lastName = last_name.getText().toString();
        String nicNumber = nic.getText().toString();
        String mNumber = phone.getText().toString();
        String passwordText = password.getText().toString();


        Passenger passenger = new Passenger();
        passenger.setUsername(userName);
        passenger.setFirstName(firstName);
        passenger.setLastName(lastName);
        passenger.setNic(nicNumber);
        passenger.setMobileNumber(mNumber);
        passenger.setPassword(passwordText);


        passenger.setPassengerId(String.valueOf(System.currentTimeMillis()));

        reference.child(passenger.getPassengerId()).setValue(passenger).addOnCompleteListener(new OnCompleteListener<Void>() {
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
    public void isUserNameAlreadyExists(OnStateChange listener)
    {
        String userName = username.getText().toString();

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                if(snapshot.exists())
                {
                    boolean isNameTaken = false;
                    for(DataSnapshot dss: snapshot.getChildren())
                    {
                        Passenger passenger = dss.getValue(Passenger.class);
                        if(passenger != null)
                        {
                            if(passenger.getUsername().equals(userName))
                            {
                                isNameTaken = true;
                                listener.taken();
                                break;
                            }
                        }
                    }
                    if(!isNameTaken)
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
                isUserNameAlreadyExists(new OnStateChange() {
                    @Override
                    public void taken()
                    {
                        username.setError("Username is already taken");
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
