package com.tejas.v_authmachinetest.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData


open class BaseApplicationContextViewModel(application: Application) : AndroidViewModel(application) {

    var currentState = MutableLiveData<CommonEvents>()

}