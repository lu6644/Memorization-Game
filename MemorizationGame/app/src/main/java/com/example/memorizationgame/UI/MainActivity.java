package com.example.memorizationgame.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.memorizationgame.Business.MusicService;
import com.example.memorizationgame.R;
import com.example.memorizationgame.UI.Login.LoginActivity;
import com.example.memorizationgame.ui.login.CreateAccountActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting music
        final Intent serviceIntent = new Intent(MainActivity.this, MusicService.class);
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


        Button newAccount = (Button)findViewById(R.id.newAccount);
        newAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CreateAccountActivity.class);
                startActivity(intent);
            }
        });

        Button login = (Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });


        //question mark
        ImageButton questionmark = (ImageButton) findViewById(R.id.questionmark1);
        questionmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(view );
            }
        });

    }

    public  void showDialog(View view){
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle("Instruction");
        builder.setMessage("choose the right shape that you have already seen");
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    protected void onStart() {
        startService(new Intent(MainActivity.this,MusicService.class));
        super.onStart();
    }
}