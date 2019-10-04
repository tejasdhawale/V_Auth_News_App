package com.tejas.v_authmachinetest.main.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateTimeUtils {

    public static String formatStringDate(String stringDate) {
        try {

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.UK);
            Date date = dateFormat.parse(stringDate);//You will get date object relative to server/client timezone wherever it is parsed
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()); //If you need time just put specific format for time like 'HH:mm:ss'
            return formatter.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return stringDate;
        }
    }

}
