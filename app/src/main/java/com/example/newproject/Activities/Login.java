package com.example.newproject.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.newproject.R;
import com.example.newproject.Utilities.HttpsTrustManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {

    FrameLayout loginbtn;
    EditText number,password;
    String strLogin,strPass,strname,strResponse,ID;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        number = findViewById(R.id.enter_numbersignin);
        password = findViewById(R.id.enter_passwordsignin);


        loginbtn = findViewById(R.id.frameSign);
       loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strLogin = number.getText().toString();
                strPass = password.getText().toString();

                if (strLogin.equals("")){
                    number.setError("Enter the Number!");
                }else if (strPass.equals("")){
                    password.setError("Enter Your Password!");
                }else {
                 /*Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                 startActivity(intent);*/
                    // calling a method to post the data and passing our name and job.
                    postData();
                    ID = Settings.Secure.getString(getContentResolver(),
                            Settings.Secure.ANDROID_ID);
                    Toast.makeText(Login.this, "Device is:" + ID, Toast.LENGTH_SHORT).show();
                }
            }
       });

    }
    public void postData() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JSONObject object = new JSONObject();
        try {
            //input your API parameters
            strLogin =  number.getText().toString();
            strPass = password.getText().toString();
            Toast.makeText(this, "Number is:"+strLogin, Toast.LENGTH_SHORT).show();
            //  object.put("parameter","value");
            object.put("mobilno",strLogin);
            object.put("passwd",strPass);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        //  stsdl  =  object.tos
        HttpsTrustManager.allowAllSSL();
        // Enter the correct url for your api service site
        String url = "https://202.143.96.44:1831/api/Mob/Login";//getResources().getString(R.string.url);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, object,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("TAG", "Login:" + response);

                        strname = response.optString("personName");

                        //for url creation
                        strResponse = "Name.:"+""+strname;
                        Log.d("TAGParser","parseData:"+strResponse);

                        Intent i = new Intent(getApplicationContext(),MainActivity.class);
                        i.putExtra("response",strResponse);
                        startActivity(i);


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                responseTV.setText(error.getMessage());
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<>();

                headers.put("DeviceId", ID);
                return headers;
            }
        };
        requestQueue.add(jsonObjectRequest);

    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(),Welcome.class);
        startActivity(intent);
    }
}