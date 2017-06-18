package com.mostafaelhaw.task_1.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.support.annotation.NonNull;

/**
 * Created by mostafa_elhaw on 6/18/2017.
 */
    public class InternetConnection {

        /**
         * CHECK WHETHER INTERNET CONNECTION IS AVAILABLE OR NOT
         */
        public static boolean checkConnection(@NonNull Context context) {
            return ((ConnectivityManager) context.getSystemService
                    (Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo() != null;
        }
    }
