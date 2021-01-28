package com.eden.camerax.manager

import android.content.Context
import com.eden.camerax.R
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

private const val FILENAME_FORMAT = "yyyy-MM-dd-HH-mm-ss-SSS"

object FileManager {
    lateinit var applicationContext: Context

    fun init(context: Context) {
        applicationContext = context.applicationContext
    }

    fun getOutputDirectory(): File {
        //TODO check alternatives
        val mediaDir = applicationContext.externalMediaDirs.firstOrNull()?.let {
            File(it, applicationContext.getString(R.string.app_name)).apply { mkdirs() } }
        return if (mediaDir != null && mediaDir.exists())
            mediaDir else applicationContext.filesDir
    }

    fun preparePhotoFile(): File = File(getOutputDirectory(), SimpleDateFormat(FILENAME_FORMAT, Locale.US).format(System.currentTimeMillis()) + ".jpg")
}