package com.archi.ebiddersystem.utils;


import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {


    public static boolean isValidEmailAddress(String emailAddress) {
        String expression = "[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})";
        CharSequence inputStr = emailAddress;
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        return matcher.matches();
    }

    public final static boolean isValidOrganizationEmail(String target) {

        String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*.edu";
        if (!Pattern.matches(regex, target)) {
            return false;
        } else {
            return true;
        }

    }

    private static final String PASSWORD_PATTERN = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z]).{6,40})";

    public static boolean validatePassword(final String password) {
        Pattern pattern;
        Matcher matcher;
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        Log.e("isMatch of" + password, matcher.matches() + "");

        return matcher.matches();


    }

    public static boolean isInternetConnected(Context mContext) {

        try {
            ConnectivityManager connect = null;
            connect = (ConnectivityManager) mContext
                    .getSystemService(Context.CONNECTIVITY_SERVICE);

            if (connect != null) {
                NetworkInfo resultMobile = connect
                        .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

                NetworkInfo resultWifi = connect
                        .getNetworkInfo(ConnectivityManager.TYPE_WIFI);

                if ((resultMobile != null && resultMobile
                        .isConnectedOrConnecting())
                        || (resultWifi != null && resultWifi
                        .isConnectedOrConnecting())) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


    public static void saveToUserDefaults(Context context, String key,
                                          String value) {

        Log.d("Utils", "Saving:" + key + ":" + value);
        SharedPreferences preferences = context.getSharedPreferences(
                Constant.SHARED_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.commit();

    }

    public static String getFromUserDefaults(Context context, String key) {
        Log.d("Utils", "Get:" + key);
        SharedPreferences preferences = context.getSharedPreferences(
                Constant.SHARED_PREFS, Context.MODE_PRIVATE);
        return preferences.getString(key, "");
    }


}
