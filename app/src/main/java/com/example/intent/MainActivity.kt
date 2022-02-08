package com.example.intent

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
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
            var intent=Intent(this,Second_activity::class.java)
            intent.putExtra("key",str)
            startActivity(intent)
        }
        intent=getIntent()
        var String1=intent.getStringExtra("bye")
        send_text.setText(String1)

        val button_2=findViewById<Button>(R.id.button_2)
        button_2.setOnClickListener {
            val intent=Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("https://www.javatpoint.com/"))
            startActivity(intent)

        }

    }

   /* override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1){
            if (requestCode == Activity.RESULT_OK){
                Toast.makeText(this,data?.getStringExtra("bye"),Toast.LENGTH_LONG).show()
            }
        }
    }*/

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