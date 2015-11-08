package com.example.myapp.kotlinactivitylifecycle.util

import android.os.Handler
import android.widget.TextView

public class Utils {
    companion object {
        private var mStatusTracker = StatusTracker.getInstance()
        fun printStatus(viewMethods : TextView, viewStatus : TextView) {
            val handler = Handler()
            val runnable = {
                val sbMethods = StringBuilder()
                val listMethods = mStatusTracker.getMethodList()
                for (method in listMethods) {
                    sbMethods.insert(0, method + "\r\n")
                }
                if (viewMethods != null) {
                    viewMethods.text = sbMethods.toString()
                }

                // Get the status of all Activity classes and print to TextView
                val sbStatus = StringBuilder()
                for (key in mStatusTracker.keySet()) {
                    sbStatus.insert(0, key + ": " + mStatusTracker.getStatus(key) + "\n")
                }
                if (viewStatus != null) {
                    viewStatus.text = sbStatus.toString()
                }

            }
            handler.postDelayed(runnable,750)
        }
    }
}