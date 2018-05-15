package com.example.chung.callbackdata

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_master.*

class MasterActivity : AppCompatActivity() {

    private val CALLBACK_REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_master)
        setSupportActionBar(findViewById(R.id.toolbar))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_items, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val intent = Intent(this, DetailActivity::class.java)
        startActivityForResult(intent, CALLBACK_REQUEST_CODE)
        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == CALLBACK_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                val message = data?.getStringExtra(DetailActivity.CALL_BACK_MESSAGE).toString()
                message?.let {
                    textView.text = it
                }
            }
        }
    }
}
