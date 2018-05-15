package com.example.chung.callbackdata

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity: AppCompatActivity() {

    companion object {
        val CALL_BACK_MESSAGE = "Call back"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(findViewById(R.id.toolbarDetail))
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowHomeEnabled(true)
        }
    }

    fun callBack(view: View) {
        val message = editText.text.toString()
        if (!message.isEmpty()) {
           val result = Intent().apply {
                putExtra(CALL_BACK_MESSAGE, message)
            }
            setResult(Activity.RESULT_OK, result)
        }
        finish()
    }
}