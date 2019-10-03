package com.tejas.v_authmachinetest.main.dashboard

import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.tejas.v_authmachinetest.R
import com.tejas.v_authmachinetest.databinding.ActivityMainBinding
import com.tejas.v_authmachinetest.main.AppNavigator
import com.tejas.v_authmachinetest.main.BaseActivity
import com.tejas.v_authmachinetest.main.CommonEvents

class MainActivity : BaseActivity() {

    private var mBinding: ActivityMainBinding? = null
    var mViewModel: MainViewModel? = null

    companion object {
        const val SHOW_DETAIL_SCREEN = 1
    }

    override fun getCurrentFragment(): Fragment? {
        return null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        mBinding?.vm = mViewModel
        mBinding?.lifecycleOwner = this

        mViewModel?.getData()

        setObserver()
        setToolBar()
    }

    private fun setToolBar() {
        supportActionBar?.title = "V-Test News App"
    }

    private fun setObserver() {
        mViewModel?.currentState?.observe(this, Observer {
            when (it) {
                is CommonEvents.ShowToast -> {
                    Toast.makeText(this, it.text, Toast.LENGTH_LONG).show()
                }

                is CommonEvents.NavToNext -> {
                    if (it.flag == SHOW_DETAIL_SCREEN) {
                        AppNavigator.navigateToDetailActivity(
                            this,
                            mViewModel?.meetingData?.value!!
                        )
                    }
                }

            }
        })

    }
}
