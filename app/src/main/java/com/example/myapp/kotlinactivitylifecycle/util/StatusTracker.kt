package com.example.myapp.kotlinactivitylifecycle.util

import java.util.*

class StatusTracker private constructor() {

    private val mStatusMap : MutableMap<String, String>
    private val mMethodList : MutableList<String>
    val STATUS_SUFFIX = "ed"

    init {
        mStatusMap = LinkedHashMap<String, String>()
        mMethodList = ArrayList<String>()
    }

    companion object {
        private var ourInstance = StatusTracker()
        fun getInstance(): StatusTracker {
            return ourInstance
        }
    }

    fun getMethodList(): List<String>{
        return mMethodList
    }

    fun clear() {
        mMethodList.clear()
        mStatusMap.clear()
    }

    fun setStatus(activityName : String, status : String){
        mMethodList.add("$activityName.$status()")
        if (mStatusMap.containsKey(activityName)) mStatusMap.remove(activityName)
        mStatusMap.put(activityName,status)
    }

    fun getStatus(activityName: String) : String?{
        var status = mStatusMap.get(activityName)
        /*
        var length:Int? = status?.length()
        status = status?.substring(2, length?)
        if(status?.endsWith("e") == true) {
            status?.substring(0, status?.length()?.minus(1))
        }
        if(status?.endsWith("p") == true) {
            status + "p"
        }*/
        status += STATUS_SUFFIX
        return status
    }

    fun keySet() : Set<String>{
        return mStatusMap.keySet()
    }
}