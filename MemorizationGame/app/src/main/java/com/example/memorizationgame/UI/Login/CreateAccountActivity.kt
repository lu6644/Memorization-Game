package com.example.memorizationgame.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.memorizationgame.R
import com.example.memorizationgame.Business.MusicService
import com.example.memorizationgame.Business.UerAccount
import com.example.memorizationgame.databinding.ActivityCreateAccountBinding
import com.example.memorizationgame.UI.Account.AccountActivity

class CreateAccountActivity : AppCompatActivity() {

    // Using View Binding to inflate the layout
    private lateinit var binding: ActivityCreateAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setting music
        val serviceIntent = Intent(this, MusicService::class.java)
        with(binding) {
            if (!MusicService.isplay) {
                sound.setImageResource(R.drawable.start)
            }
            sound.setOnClickListener {
                if (!MusicService.isplay) {
                    startService(serviceIntent)
                    sound.setImageResource(R.drawable.stop)
                } else {
                    stopService(serviceIntent)
                    sound.setImageResource(R.drawable.start)
                }
            }

            // Setting new account button
            signup.setOnClickListener {
                val name = username.text.toString()
                val password = password.text.toString()
                val rePassword = reenterPassword.text.toString()
                when {
                    name.isEmpty() -> Toast.makeText(this@CreateAccountActivity, "The username could not be empty", Toast.LENGTH_SHORT).show()
                    password.isEmpty() -> Toast.makeText(this@CreateAccountActivity, "The password could not be empty", Toast.LENGTH_SHORT).show()
                    rePassword.isEmpty() -> Toast.makeText(this@CreateAccountActivity, "The re-enter password could not be empty", Toast.LENGTH_SHORT).show()
                    password != rePassword -> Toast.makeText(this@CreateAccountActivity, "The re-enter password is not correct, please re-enter again", Toast.LENGTH_SHORT).show()
                    else -> {
                        // Go to a new activity
                        val intent = Intent(this@CreateAccountActivity, AccountActivity::class.java)
                        val user = UerAccount(name, password)
                        intent.putExtra("user", user)
                        startActivity(intent)
                    }
                }
            }

            // Setting cancel button
            cancel.setOnClickListener { finish() }

            // Setting question mark
            questionmark3.setOnClickListener { showDialog() }
        }
    }

    private fun showDialog() {
        val builder = android.app.AlertDialog.Builder(this)
        builder.setTitle("Instruction")
            .setMessage("Choose the right shape that you have already seen")
            .setPositiveButton("ok") { dialog, _ -> dialog.dismiss() }
            .create()
            .show()
    }
}
