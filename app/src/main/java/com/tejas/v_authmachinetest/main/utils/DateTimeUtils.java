package com.tejas.v_authmachinetest.main.utils;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtils {

    public static String formatStringDate(String stringDate) {
        try {
            SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd MMM yyyy");
            Date date = inputDateFormat.parse("2018-04-10T04:00:00.000Z");
            return outputDateFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return stringDate;
        }
    }
}
