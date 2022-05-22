package com.example.memorizationgame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class AccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        //setting music
        final Intent serviceIntent = new Intent(AccountActivity.this,MusicService.class);
        ImageButton musicPlayer = (ImageButton)findViewById(R.id.sound);
        if(MusicService.isplay == false){
            musicPlayer.setImageResource(R.drawable.start);
        }
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



        //receiving user and displaying user information
        UerAccount user = (UerAccount) getIntent().getSerializableExtra("user");
        ((TextView) findViewById(R.id.name)).setText(user.getUserName());
        TextView round = (TextView) findViewById(R.id.round);
        round.setText("" + user.getCompleteRounds());
        TextView rank = (TextView) findViewById(R.id.rank);
        rank.setMovementMethod(ScrollingMovementMethod.getInstance());
        rank.setText(user.getRankHistory());

        //setting badge
        ImageView badge = (ImageView) findViewById(R.id.badge);
        if(user.gettotalPoints() < 100){
            badge.setImageResource(R.mipmap.badge1);
        }else {
            badge.setImageResource(R.mipmap.badge2);
        }

        //setting start button
        Button startGame = (Button) findViewById(R.id.startgame);
        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(user.gettotalPoints() >= 100){
                    Intent intent = new Intent(AccountActivity.this, GameLv2Activity.class);
                    intent.putExtra("user", user);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(AccountActivity.this, GameActivity.class);
                    intent.putExtra("user", user);
                    startActivity(intent);
                }

            }
        });

        //setting question mark
        ImageButton questionmark = (ImageButton) findViewById(R.id.questionmark4);
        questionmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(view);
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


}

