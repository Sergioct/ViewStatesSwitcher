package com.sergiocrespotoubes.viewstatesswitcher

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //viewStatesSwitcher.setStatus(ViewStatesSwitcher.Status.ERROR)
    }

}
