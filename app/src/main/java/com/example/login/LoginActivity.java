package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity {

    private EditText editText_account;

    private EditText editText_password;

    private Button button_login;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editText_account = (EditText) findViewById(R.id.editText_account);
        editText_password = (EditText) findViewById(R.id.editText_password);
        button_login = (Button) findViewById(R.id.button_login);

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = editText_account.getText().toString();
                String password = editText_password.getText().toString();

                if ("admin".equals(account) && "123456".equals(password)) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else
                    Toast.makeText(LoginActivity.this, "Account or password is invalid", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
