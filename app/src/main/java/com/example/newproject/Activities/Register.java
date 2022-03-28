package com.example.newproject.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.newproject.R;

public class Register extends AppCompatActivity {
    final Context context = this;
    String strnumber;
    ImageView rback_btn;
    Button next;
    EditText enterNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        /*googleApiClient = new GoogleApiClient.Builder(this)
                .addApi(Auth.CREDENTIALS_API)
                .build();
        requestPhoneNumber(result -> {
            phoneET.setText(result);
*/          enterNumber = findViewById(R.id.renter_number);
            rback_btn = findViewById(R.id.rback_btn);
            rback_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent i = new Intent(getApplicationContext(), Welcome.class);
                    startActivity(i);

                }
            });

            next = findViewById(R.id.nextbtn_r);
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    strnumber = enterNumber.getText().toString();

                    Intent intent = new Intent(getApplicationContext(), Verification.class);
                    startActivity(intent);

                }

            });

        }
        }


