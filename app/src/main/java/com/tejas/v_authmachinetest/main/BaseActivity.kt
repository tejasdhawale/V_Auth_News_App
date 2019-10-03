package com.tejas.v_authmachinetest.main

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import pl.tajchert.nammu.Nammu


abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        Nammu.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }





    abstract fun getCurrentFragment(): Fragment?

}