package com.eden.camerax.manager

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

val REQUIRED_PERMISSIONS = arrayOf(Manifest.permission.CAMERA)
const val REQUEST_CODE_CAMERA_PERMISSIONS = 10

object PermissionManager {
    lateinit var applicationContext: Context

    fun init(context: Context) {
        applicationContext = context.applicationContext
    }

    fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(applicationContext, it) == PackageManager.PERMISSION_GRANTED
    }

    fun requestCameraPermission(activity: AppCompatActivity) {
        ActivityCompat.requestPermissions(activity, REQUIRED_PERMISSIONS, REQUEST_CODE_CAMERA_PERMISSIONS)
    }
}