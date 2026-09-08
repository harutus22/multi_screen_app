package com.example.multiscreenapp

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

class MyLifecycleObserver(val name: String): DefaultLifecycleObserver {

    override fun onCreate(owner: LifecycleOwner) {
        Log.d(TAG, name + ON_CREATED);
    }

    override fun onDestroy(owner: LifecycleOwner) {
        Log.d(TAG, name + ON_DESTROYED);
    }

    override fun onPause(owner: LifecycleOwner) {
        Log.d(TAG, name + ON_PAUSED);
    }

    override fun onResume(owner: LifecycleOwner) {
        Log.d(TAG, name + ON_RESUMED);
    }

    override fun onStart(owner: LifecycleOwner) {
        Log.d(TAG, name + ON_STARTED);
    }

    override fun onStop(owner: LifecycleOwner) {
        Log.d(TAG, name + ON_STOPPED);
    }
}