package com.example.login;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    private ForceOfflineBroadcastReceiver forceOfflineBroadcastReceiver;

    class ForceOfflineBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive (final Context context, Intent intent) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Warning");
            builder.setMessage("You are forced to be offline. Please try to login again.");
            builder.setCancelable(false);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ActivityManager.finishAll();
                    Intent intent = new Intent(context, LoginActivity.class);
                    context.startActivity(intent);
                }
            });
            builder.show();
        }
    }

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.addActivity(this);
    }

    @Override
    protected  void onDestroy () {
        super.onDestroy();
        ActivityManager.removeActivity(this);
    }

    @Override
    protected void onResume () {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.broadcast.FORCE_OFFLINE");
        forceOfflineBroadcastReceiver = new ForceOfflineBroadcastReceiver();
        registerReceiver(forceOfflineBroadcastReceiver, intentFilter);
    }

    @Override
    protected void onPause () {
        super.onPause();
        if(forceOfflineBroadcastReceiver != null) {
            unregisterReceiver(forceOfflineBroadcastReceiver);
            forceOfflineBroadcastReceiver = null;
        }
    }
}
