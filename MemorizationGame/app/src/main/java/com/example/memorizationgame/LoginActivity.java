package com.example.memorizationgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.InputStream;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //login
        /*
        Button cancel = (Button)findViewById(R.id.cancelbutton);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

         */
        /*
        Button login = (Button)findViewById(R.id.loginbutton);
        login.setOnClickListener(new View.OnClickListener() {
            InputStream is = this.getResources().openRawResource(R.drawable.allUsers);
        });

         */
        //setting music
        final Intent serviceIntent = new Intent(LoginActivity.this,MusicService.class);
        ImageButton musicPlayer = (ImageButton)findViewById(R.id.sound);
        musicPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MusicService.isplay == false){
                    startService(serviceIntent);
                    musicPlayer.setImageResource(R.drawable.stop);
                }else {
                    stopService(serviceIntent);
                    musicPlayer.setImageResource(R.drawable.start);
                }
            }
        });

    }

    public void signIn(View view) throws IOException {
        String username = ((EditText) findViewById(R.id.nameinput)).getText().toString();
        String password = ((EditText) findViewById(R.id.passinput)).getText().toString();
        InputStream is = this.getResources().openRawResource(R.raw.all_users);
        FileIO fio = new FileIO(is);
        if (fio.match(username,password)){
            UerAccount user = fio.getUser(username);
            Intent intent = new Intent(LoginActivity.this,AccountActivity.class);
            intent.putExtra("user",user);
            startActivity(intent);
        }
        else {
            Toast.makeText(LoginActivity.this, "The entered username and password does not match records", Toast.LENGTH_SHORT).show();
        }

    }

    public void cancel(View view){
        finish();
    }
}