package com.eden.camerax

import android.app.Application
import com.eden.camerax.manager.FileManager
import com.eden.camerax.manager.PermissionManager

class Application: Application() {

    override fun onCreate() {
        super.onCreate()
        PermissionManager.init(this)
        FileManager.init(this)
    }
}