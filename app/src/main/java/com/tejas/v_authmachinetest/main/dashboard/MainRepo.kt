package com.tejas.v_authmachinetest.main.dashboard

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.tejas.v_authmachinetest.main.CommonEvents
import com.tejas.v_authmachinetest.main.api.ApiClient
import com.tejas.v_authmachinetest.main.api.ApiInterface
import com.tejas.v_authmachinetest.main.model.mainResponse
import org.json.JSONException
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainRepo {

    val mutableLiveData = MutableLiveData<mainResponse>()
    val modelEvents = MutableLiveData<CommonEvents>()

    fun getResponseData(): MutableLiveData<mainResponse> {
        return mutableLiveData
    }
    fun getmodelEvents(): MutableLiveData<CommonEvents> {
        return modelEvents
    }

    @Throws(JSONException::class)
    fun getDataList() {

        val apiInterface = ApiClient.getClient().create(ApiInterface::class.java)
        modelEvents.value = CommonEvents.ShowProgress(true)

        val call = apiInterface.getList("us", "2352d41b50804fcebefbbe2fde7d8b13")
        call.enqueue(object : Callback<mainResponse> {
            override fun onResponse(call: Call<mainResponse>, response: Response<mainResponse>) {
                Log.d("TAG", response.code().toString() + " ")
                val resource1 = response.body()
                mutableLiveData.value = resource1
                modelEvents.value = CommonEvents.ShowProgress(false)
            }

            override fun onFailure(call: Call<mainResponse>, t: Throwable) {
                call.cancel()
                modelEvents.value = CommonEvents.ShowProgress(false)
                modelEvents.value = CommonEvents.ShowToast("Failed to load data from server")
            }
        })
    }


}