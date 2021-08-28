package com.example.smart_bus_system.qrcode.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.smart_bus_system.BusOwner.DriverMainActivity;

import com.example.smart_bus_system.Conection.RetroClient;
import com.example.smart_bus_system.Conection.UserCreditial1;
import com.example.smart_bus_system.Home;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.example.smart_bus_system.R;
import com.example.smart_bus_system.qrcode.config.UserState;
import com.example.smart_bus_system.qrcode.models.BusDriver;
import com.example.smart_bus_system.qrcode.models.Passenger;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginScreen extends AppCompatActivity implements View.OnClickListener {


    private EditText bus_no,password;
    private Button login,b1;
    private RadioGroup user_type_rg;

    SharedPreferences sharedpreferences;

    private DatabaseReference reference;
    public static String BUSES_FIREBASE_ROOT_PATH = "Buses";
    public static String PASSENGER_FIREBASE_ROOT_PATH = "Passengers";
    private ProgressDialog dialog;

    private int loginUserType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_login_screen);

        init();



//        b1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent( LoginScreen.this, DriverMainActivity.class));
//            }
//        });


        dialog = new ProgressDialog(LoginScreen.this);
        dialog.setMessage("In progress");
        dialog.setCancelable(true);

        initViews();
        setListeners();

        user_type_rg.check(R.id.driver);
        loginUserType = R.id.driver;
        user_type_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                if(checkedId == R.id.driver)
                {
                    bus_no.setHint("Bus No");
                }
                else
                {
                    bus_no.setHint("Username");
                }
                loginUserType = checkedId;
            }
        });
    }

    private void init() {
        bus_no = findViewById(R.id.bus_no);
        password = findViewById(R.id.password);
        b1=findViewById(R.id.button);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });


    }
    public void Login() {

//        if (TextUtils.isEmpty(login_user_name.getText().toString())) {
//            login_user_name.setError("User name is required !");
//            return;
//        }
//
//
//        if(login_password.getText().length()<8 &&!isValidPassword(login_password.getText().toString())){
//            login_password.setError( "Password must be 8 characters" );
//            return;
//        }


        HashMap<String, String> hashMap = new HashMap<>();


        hashMap.put("busno", bus_no.getText().toString());
        hashMap.put("pass", password.getText().toString());



        Call<UserCreditial1> authenticateUser1= RetroClient.getInstance().getApi().authenticateUser1(hashMap);

        authenticateUser1.enqueue(new Callback<UserCreditial1>() {
            @Override
            public void onResponse(Call<UserCreditial1> call, Response<UserCreditial1> response) {
                if(response.body().getSuccess().equals("true")) {

                    AlertMessage("Login Success !");


                    //set the session
                    sharedpreferences =getSharedPreferences("user_details_1", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putBoolean("isLoggedIn",true);
                    editor.putString("utype",response.body().getUsertype());
                    editor.putString("uid",response.body().getUid());
                    editor.putString("bus_number",response.body().getBus_number());
                    editor.putString("route_id",response.body().getRoute_id());
                    editor.commit();


                    //to check user type
                    if (response.body().getUsertype().equals("driver")) {


                        startActivity(new Intent(LoginScreen.this, DriverMainActivity.class));
                        finish();
                        //  Toast.makeText(SignInActivity.this,"User Login Success   !",Toast.LENGTH_SHORT).show();

                    }






                }else{
                    AlertMessage("Login Failed !");


                }
            }

            @Override
            public void onFailure(Call<UserCreditial1> call, Throwable t) {


                Log.e("Error",t.getMessage());
                //startActivity(new Intent(LoginActivity1.this, UserMainNav.class));
            }
        });


    }

    private void AlertMessage(String message){

//        android.app.AlertDialog.Builder dialog = new android.app.AlertDialog.Builder(LoginActivity.this);
//        dialog.setTitle( "Task Status" )
//                .setIcon(R.drawable.ic_baseline_email_24)
//                .setMessage(message)
//                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialoginterface, int i) {
//                        dialoginterface.cancel();
//                    }}).show();

    }
    public static boolean isValidPassword(final String password) {

        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();

    }



    private void setListeners()
    {
        login.setOnClickListener(this);
    }

    private void initViews()
    {
        bus_no = findViewById(R.id.bus_no);
        password = findViewById(R.id.password);
        user_type_rg = findViewById(R.id.user_type_rg);

        login = findViewById(R.id.login);
    }
    private EditText validate()
    {
        if(bus_no.getText().toString().trim().isEmpty())
        {
            return bus_no;
        }
        else if(password.getText().toString().trim().isEmpty())
        {
            return password;
        }
        return null;
    }

    @Override
    public void onClick(View view)
    {
        if(view.getId() == login.getId())
        {
            EditText editText = validate();
            if(editText == null)
            {
                if(loginUserType == R.id.driver)
                {
                    BusDriver busDriver = new BusDriver();
                    busDriver.setBusNo(bus_no.getText().toString().trim());
                    busDriver.setPassword(password.getText().toString().trim());
                    checkLogin(busDriver);
                }
                else
                {
                    Passenger passenger = new Passenger();
                    passenger.setUsername(bus_no.getText().toString().trim());
                    passenger.setPassword(password.getText().toString().trim());
                    checkLogin(passenger);

                }

            }
            else
            {
                editText.setError("Please fill this field!");
            }
        }
    }

    private void checkLogin(BusDriver cBuss)
    {
        dialog.show();

        reference = FirebaseDatabase.getInstance().getReference(BUSES_FIREBASE_ROOT_PATH);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                boolean isSuccess = false;

                for(DataSnapshot dss : snapshot.getChildren())
                {
                    BusDriver busDriver = dss.getValue(BusDriver.class);
                    if(busDriver != null)
                    {
                        if(cBuss.getBusNo().equals(busDriver.getBusNo())  && cBuss.getPassword().equals(busDriver.getPassword()))
                        {
                            isSuccess = true;
                            dialog.dismiss();

                            UserState.saveBus(getApplicationContext(), busDriver);

                            startActivity(new Intent(LoginScreen.this, BusDriverDashboard.class));
                            finish();
                        }
                    }

                }
                if(!isSuccess)
                    Toast.makeText(LoginScreen.this, "Login Failed, please check your credentials", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error)
            {
                Toast.makeText(LoginScreen.this, "An error occurred", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });



    }
    private void checkLogin(Passenger cPassenger)
    {
        dialog.show();

        reference = FirebaseDatabase.getInstance().getReference(PASSENGER_FIREBASE_ROOT_PATH);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                boolean isSuccess = false;

                for(DataSnapshot dss : snapshot.getChildren())
                {
                    Passenger passenger = dss.getValue(Passenger.class);
                    if(passenger != null)
                    {
                        if(passenger.getUsername().equals(cPassenger.getUsername()) && passenger.getPassword().equals(cPassenger.getPassword()))
                        {
                            isSuccess = true;
                            dialog.dismiss();

                            UserState.savePassenger(getApplicationContext(),passenger);

                            startActivity(new Intent(LoginScreen.this, PassengerDashboard.class));
                            finish();
                        }
                    }

                }
                dialog.dismiss();
                if(!isSuccess)
                    Toast.makeText(LoginScreen.this, "Login Failed, please check your credentials", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error)
            {
                Toast.makeText(LoginScreen.this, "An error occurred", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });



    }

    public void openRegisterScreen(View view)
    {
        startActivity(new Intent(LoginScreen.this, RegisterActivity.class));
    }
}