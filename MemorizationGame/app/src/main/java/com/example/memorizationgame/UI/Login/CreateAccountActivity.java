package com.example.memorizationgame.UI.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.memorizationgame.Business.MusicService;
import com.example.memorizationgame.Business.UerAccount;
import com.example.memorizationgame.R;
import com.example.memorizationgame.UI.Account.AccountActivity;

public class CreateAccountActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);


        //setting music
        final Intent serviceIntent = new Intent(CreateAccountActivity.this, MusicService.class);
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


        //setting new account button
        Button newAccount = (Button)findViewById(R.id.signup);
        newAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = ((EditText) findViewById(R.id.username)).getText().toString();
                String password = ((EditText) findViewById(R.id.password)).getText().toString();
                String re_password = ((EditText) findViewById(R.id.reenterPassword)).getText().toString();
                if("".equals(name)){
                    Toast.makeText(CreateAccountActivity.this, "The username could not be empty", Toast.LENGTH_SHORT).show();
                }else if("".equals(password)){
                    Toast.makeText(CreateAccountActivity.this, "The password could not be empty", Toast.LENGTH_SHORT).show();

                }else if("".equals(re_password)){
                    Toast.makeText(CreateAccountActivity.this, "The re-enter password could not be empty", Toast.LENGTH_SHORT).show();
                }else{
                    if(!password.equals(re_password)){
                        Toast.makeText(CreateAccountActivity.this, "The re-enter password is not correct,please re-enter again", Toast.LENGTH_SHORT).show();
                    }else {

                        //go to a new activity
                        Intent intent = new Intent(CreateAccountActivity.this, AccountActivity.class);
                        UerAccount user = new UerAccount(name,password);
                        intent.putExtra("user",user);
                        startActivity(intent);
                    }
                }


            }
        });

        //setting cancel button
        Button cancel = (Button)findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //setting question mark
        ImageButton questionmark = (ImageButton) findViewById(R.id.questionmark3);
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


}