package com.example.intent

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Second_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var  receiver_msg =findViewById<TextView>(R.id.received_value_id)
        /*val intent = intent
        val str = intent.getStringExtra("key")
        receiver_msg.text = str*/

        val intent =getIntent()
        var str = intent.getStringExtra("key")
        receiver_msg.setText(str);
    }
}