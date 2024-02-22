package com.example.shift_android_1.models

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.runtime.NoLiveLiterals

@NoLiveLiterals
fun Context.sendMail(to: String): String {
    try {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "vnd.android.cursor.item/email"
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(to))
        startActivity(intent)
        return "200"
    } catch (e: ActivityNotFoundException) {
        return "404"
    } catch (t: Throwable) {
        return "400"
    }
}

fun Context.makeCall(phone: String): String {
    try {
        val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))
        startActivity(intent)
        return "200"
    } catch (t: Throwable) {
        return "400"
    }
}

fun Context.findPlace(lat: String, long: String): String{
    try {
        val gmmIntentUri = Uri.parse("google.streetview:cbll=$lat,$long")
        val intent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        startActivity(intent)
        return "200"
    } catch (e: ActivityNotFoundException) {
        return "404"
    } catch (t: Throwable) {
        return "400"
    }
}

fun Context.findAddress(address: String, city: String): String{
    try {
        val gmmIntentUri = Uri.parse("geo:0,0?q=$address, $city")
        val intent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        startActivity(intent)
        return "200"
    } catch (e: ActivityNotFoundException) {
        return "404"
    } catch (t: Throwable) {
        return "400"
    }
}