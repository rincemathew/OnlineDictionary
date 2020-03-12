package com.example.onlinedictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainPage extends AppCompatActivity {

    Button next;
    TextView getRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        next=findViewById(R.id.next);
        getRequest=findViewById(R.id.getRequest);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sentGetRequest();
            }
        });
    }

    private void sentGetRequest() {
        RequestQueue queue= Volley.newRequestQueue(MainPage.this);
        String url="https://api.dictionaryapi.dev/api/v1/entries/en/hello";
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                getRequest.setText("Data: "+response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                getRequest.setText("Data: Response Failed");
            }
        });
        queue.add(stringRequest);
    }
}
