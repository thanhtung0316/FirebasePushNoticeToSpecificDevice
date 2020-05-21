package com.thanhtung.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.thanhtung.myapplication.databinding.ActivityMainBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private ActivityMainBinding binding;
    private static final String TAG = "MainActivity";
    private String token = "eh_Laps_RBiM9b-ycUxKaf:APA91bHnbiA0UNGNF_8ktufTM4YNUTFSBaixdE5-WGouFjV7VseJc16dICbl--L86lx_e74PV04jCbq4zPcRiUBuvGGc86qq7q74yH48CBrJdstebQeNlezOj8AfCJ7G82HOBuxEOmLb";
    private boolean isSaveToken = false;
    private MyShared shared;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.btnSend.setOnClickListener(this);
        binding.btnSwitch.setOnCheckedChangeListener(this);
        shared = new MyShared(this);
        binding.edtToken.setText(shared.get("token"));

        getDeviceToken();
//        getWindow().addFlags(
//                WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED |
//                        WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD |
//                        WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON |
//                        WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON |
//                        WindowManager.LayoutParams.FLAG_ALLOW_LOCK_WHILE_SCREEN_ON);
//        finish();

//        FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(this, new OnSuccessListener<InstanceIdResult>() {
//            @Override
//            public void onSuccess(InstanceIdResult instanceIdResult) {
//                Log.e("TAGs", "onSuccess: "+instanceIdResult.getToken() );
//            }
//        });
//        getDeviceToken();

    }

    private void getDeviceToken() {
        FirebaseInstanceId.getInstance().getInstanceId().addOnCompleteListener(this, new OnCompleteListener<InstanceIdResult>() {
            @Override
            public void onComplete(@NonNull Task<InstanceIdResult> task) {
                Log.e(TAG, task.getResult().getToken());
                token = task.getResult().getToken();
            }
        });
    }

    @Override
    public void onClick(View v) {
        String token = binding.edtToken.getText().toString();

        if (token.equals("")) {
            Toast.makeText(this, "Token invalid!", Toast.LENGTH_SHORT).show();
        } else {
            if (isSaveToken){
                shared.put("token",token);
            }
            ApiBuilder.getInstance().sendMessage(new Sender(token, new Data("This ís message", "http://google.com.vn","01232465","hello kind"))).enqueue(new Callback<MyResponse>() {
                @Override
                public void onResponse(Call<MyResponse> call, Response<MyResponse> response) {
                    Log.e(TAG, "onResponse: " + response.errorBody());
                    Toast.makeText(MainActivity.this, " SUCCESS"+response.body(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<MyResponse> call, Throwable t) {
                    Log.e(TAG, "onFailure: " + t.getMessage());
                    Toast.makeText(MainActivity.this, " "+t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }


    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        isSaveToken = isChecked;
    }
}
