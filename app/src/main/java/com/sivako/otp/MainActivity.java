package com.sivako.otp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et_otpPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        runtimeSMSPermissionsRequest();

        et_otpPass = findViewById(R.id.et_otpPass);
        new OTPReceiver().setEditText(et_otpPass);

    }

    private void runtimeSMSPermissionsRequest() {

        String permission = Manifest.permission.RECEIVE_SMS;

        int grant = ContextCompat.checkSelfPermission(this, permission);

        if (grant != PackageManager.PERMISSION_GRANTED) {

            String[] permission_list = new String[1];
            permission_list[0] = permission;

            ActivityCompat.requestPermissions(this, permission_list, 1);
        }


    }
}