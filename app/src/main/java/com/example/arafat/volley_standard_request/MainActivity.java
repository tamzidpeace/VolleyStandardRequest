package com.example.arafat.volley_standard_request;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    //const
    private static final String TAG = "MainActivity";

    //member variables
    private TextView mTextView;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = findViewById(R.id.btn);
        mTextView = findViewById(R.id.txt);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String url = "http://192.168.43.30/volley-standard-request.php";

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                        (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {
                                try {

                                    String name = response.getJSONArray("response2").getJSONObject(0).getString("Name");
                                    String email = response.getJSONArray("response2").getJSONObject(0).getString("Email");
                                    String mobile = response.getJSONArray("response2").getJSONObject(0).getString("Mobile");

                                    mTextView.setText("Name: " + name + "\n" + "Email: " + email + "\n" + "Mobile: " + mobile);

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                    Log.d(TAG, "onResponse: " + e.toString());
                                }
                            }
                        }, new Response.ErrorListener() {

                            @Override
                            public void onErrorResponse(VolleyError error) {
                                // TODO: Handle error
                                mTextView.setText(error.toString());
                                Log.d(TAG, "onErrorResponse: " + error.toString());

                            }
                        });

                // Access the RequestQueue through your singleton class.
                MySingleton.getInstance(MainActivity.this).addToRequestQueue(jsonObjectRequest);
            }
        });

    }
}
