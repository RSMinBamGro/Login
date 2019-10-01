package com.example.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity {

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_sendForceOffLineBroadcast = (Button) findViewById(R.id.button_sendForceOffLineBroadcast);
        button_sendForceOffLineBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.broadcast.FORCE_OFFLINE");
                sendBroadcast(intent);
            }
        });

    }

}