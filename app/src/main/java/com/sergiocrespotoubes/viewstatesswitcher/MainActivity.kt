package com.sergiocrespotoubes.viewstatesswitcher

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sergiocrespotoubes.viewstatesswitcherlib.ViewStatesSwitcher
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewStatesSwitcher.setStatus(ViewStatesSwitcher.Status.LOADING)
    }

}