/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.myapp.kotlinactivitylifecycle

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.myapp.kotlinactivitylifecycle.ActivityC
import com.example.myapp.kotlinactivitylifecycle.DialogActivity
import com.example.myapp.kotlinactivitylifecycle.util.StatusTracker
import com.example.myapp.kotlinactivitylifecycle.util.Utils

/**
 * Example Activity to demonstrate the lifecycle callback methods.
 */
class ActivityB : Activity() {

    private var mActivityName = ""
    lateinit private var mStatusView: TextView
    lateinit private var mStatusAllView: TextView
    private val mStatusTracker = StatusTracker.getInstance()

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)
        mActivityName = getString(R.string.activity_b_label)
        mStatusView = findViewById(R.id.status_view_b) as TextView
        mStatusAllView = findViewById(R.id.status_view_all_b) as TextView
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
    }

    fun startDialog(v: View) {
        val intent = Intent(this@ActivityB, DialogActivity::class.java)
        startActivity(intent)
    }

    fun startActivityA(v: View) {
        val intent = Intent(this@ActivityB, ActivityA::class.java)
        startActivity(intent)
    }

    fun startActivityC(v: View) {
        val intent = Intent(this@ActivityB, ActivityC::class.java)
        startActivity(intent)
    }

    fun finishActivityB(v: View) {
        this@ActivityB.finish()
    }
}
