package com.example.intent

import android.R.attr.data
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class Second_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var  receiver_msg =findViewById<EditText>(R.id.received_value_id)
        /*val intent = intent
        val str = intent.getStringExtra("key")
        receiver_msg.text = str*/

        val intent =getIntent()
        var str = intent.getStringExtra("key")
        receiver_msg.setText(str)


        val send_button=findViewById<Button>(R.id.send_button)
        send_button.setOnClickListener {
            val str = receiver_msg.text.toString()
           var intent=Intent(this,MainActivity::class.java)
            intent.putExtra("bye",str)
            startActivity(intent)

        }
    }

}