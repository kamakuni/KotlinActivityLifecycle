package com.example.myapp.kotlinactivitylifecycle

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.myapp.kotlinactivitylifecycle.util.StatusTracker
import com.example.myapp.kotlinactivitylifecycle.util.Utils

class ActivityA : Activity() {

    private var mActivityName = ""
    lateinit private var mStatusView : TextView
    lateinit private var mStatusAllView : TextView
    private val mStatusTracker = StatusTracker.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set the user interface layout for this Activity

        setContentView(R.layout.activity_a)
        mActivityName = getString(R.string.activity_a)
        mStatusView = findViewById(R.id.status_view_a) as TextView
        mStatusAllView = findViewById(R.id.status_view_all_a) as TextView
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_create))
        Utils.printStatus(mStatusView, mStatusAllView)
    }

    override fun onStart() {
        super.onStart()
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_start))
        Utils.printStatus(mStatusView, mStatusAllView)
    }

    override fun onRestart() {
        super.onRestart()
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_restart))
        Utils.printStatus(mStatusView, mStatusAllView)
    }

    override fun onResume() {
        super.onResume()
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_resume))
        Utils.printStatus(mStatusView, mStatusAllView)
    }

    override fun onPause() {
        super.onPause()
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_pause))
        Utils.printStatus(mStatusView, mStatusAllView)
    }

    override fun onStop() {
        super.onStop()
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_stop))
    }

    override fun onDestroy() {
        super.onDestroy()
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_destroy))
        mStatusTracker.clear()
    }

    fun startDialog(v: View) {
        val intent = Intent(this@ActivityA, DialogActivity::class.java)
        startActivity(intent)
    }

    fun startActivityB(v: View) {
        val intent = Intent(this@ActivityA, ActivityB::class.java)
        startActivity(intent)
    }

    fun startActivityC(v: View) {
        val intent = Intent(this@ActivityA, ActivityC::class.java)
        startActivity(intent)
    }

    fun finishActivityA(v: View) {
        this@ActivityA.finish()
    }

}
