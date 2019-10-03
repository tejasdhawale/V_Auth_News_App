package com.tejas.v_authmachinetest.main

sealed class CommonEvents {
    class ShowToast(val text: String) : CommonEvents()
    class ShowProgress(val show: Boolean) : CommonEvents()
    class NavToNext(val flag: Int) : CommonEvents()
}