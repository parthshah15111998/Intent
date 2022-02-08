package com.example.intent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private var backPressedTime: Long = 0
    private var backToast: Toast? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var send_text=findViewById<EditText>(R.id.send_text_id)
        var send_button=findViewById<Button>(R.id.send_button_id)
        send_button.setOnClickListener {
            val str = send_text.text.toString()
            val intent=Intent(this,Second_activity::class.java)
            intent.putExtra("key",str)
            startActivity(intent)
        }

    }

    override fun onBackPressed() {
    if (backPressedTime + 2000 > System.currentTimeMillis()){
        backToast?.cancel()
        super.onBackPressed()
        return
    }else{
        Toast.makeText(this,"Press Again to exit",Toast.LENGTH_LONG).show()
    }
        backPressedTime=System.currentTimeMillis()
    }
}