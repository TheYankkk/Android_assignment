package com.example.justeat;


import android.content.Context;
import android.text.TextUtils;


/**
 * Created by 0xLLLLH on 16-5-19.
 *
 * This file contains account relate methods, such as login, logout and register.
 * If user had login, variety isLogin would set to true, and information of user would be saved in shared preference.
 */
public class UserUtils{


    public static String mUsername = null;
    private static Context context;

    public static int minimumUsernameLength = 4;
    public static int minimumPasswordLength = 6;

    public static boolean isUsernameValid(String username){
        if (Character.isDigit(username.charAt(0))||username.length()< UserUtils.minimumUsernameLength)
            return false;
        return true;
    }
    public static boolean isPasswordValid(String password) {
        if (TextUtils.isEmpty(password)||password.length()< UserUtils.minimumPasswordLength)
            return false;
        return true;
    }
}