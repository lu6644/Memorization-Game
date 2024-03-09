package com.example.memorizationgame.UI.Game;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.memorizationgame.Business.Game;
import com.example.memorizationgame.Business.MusicService;
import com.example.memorizationgame.Business.UerAccount;
import com.example.memorizationgame.R;
import com.example.memorizationgame.UI.Account.AccountActivity;

public class GameLv2Activity extends AppCompatActivity {
    Chronometer ch;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_lv2);

        //receiving user and displaying user information
        UerAccount user = (UerAccount) getIntent().getSerializableExtra("user");
        TextView scoreTextview = (TextView) findViewById(R.id.score);
        scoreTextview.setText("Your Score: \n" + "     " + user.gettotalPoints());

        //Displaying shapes
        Game bronze = new Game();
        int[] answer = bronze.getAnswerLevel2();
        ImageView shape1 = findViewById(R.id.shape1View);
        shape1.setImageResource(bronze.shapes[answer[0]]);
        ImageView shape2 = findViewById(R.id.shape2View);
        shape2.setImageResource(bronze.shapes[answer[1]]);
        ImageView shape3 = findViewById(R.id.shape3View);
        shape3.setImageResource(bronze.shapes[answer[2]]);
        ImageView shape4 = findViewById(R.id.shape4View);
        shape4.setImageResource(bronze.shapes[answer[3]]);
        ImageView shape5 = findViewById(R.id.shape5View);
        shape5.setImageResource(bronze.shapes[answer[4]]);
        ImageView shape6 = findViewById(R.id.shape6View);
        shape6.setImageResource(bronze.shapes[answer[5]]);



        //setting music
        final Intent serviceIntent = new Intent(GameLv2Activity.this, MusicService.class);
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

        //setting cutdown
        ch = (Chronometer) findViewById(R.id.cutdown);
        ch.setBase(SystemClock.elapsedRealtime() + 5000);
        ch.setCountDown(true);
        ch.setFormat("%s");
        ch.start();
        ch.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                ch.setText(ch.getText().toString().substring(1));

                if (SystemClock.elapsedRealtime() - ch.getBase() >= 0) {
                    ch.stop();
                    Intent intent = new Intent(GameLv2Activity.this, AnswerLv2Activity.class);
                    //delivering data
                    intent.putExtra("game", bronze);
                    intent.putExtra("user", user);
                    startActivity(intent);
                }
            }
        });

        //setting exit button
        Button exitButton = (Button) findViewById(R.id.exitbutton);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameLv2Activity.this, AccountActivity.class);
                intent.putExtra("user", user);
                startActivity(intent);
            }
        });

    }
}