package de.nebensinn.fonefwd

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.view.View

class MainActivity : Activity() {
    private val ruleModel = RuleModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // TODO extract into separate PermissionsHandler class,
        // properly following https://developer.android.com/training/permissions/requesting.html
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            val permissions = arrayOf(Manifest.permission.CALL_PHONE)
            ActivityCompat.requestPermissions(this, permissions, 0)
        }
        ruleModel.loadRules(getPreferences(Context.MODE_PRIVATE).all)
    }

    private fun switchToViewRulesActivity() {
        val intent = Intent(this, ViewRulesActivity::class.java)
        startActivity(intent)
    }

    fun viewRulesButtonClicked(@Suppress("UNUSED_PARAMETER") v: View) {
        switchToViewRulesActivity()
    }

    fun activateWiFi(ssid: String) {
        val phoneNumber = PhoneForwarder().wifiEnabled(ssid, ruleModel) ?: return
        forwardCall(phoneNumber)
    }

    private fun forwardCall(phoneNumber: String) {
        val uri = "tel:**21*$phoneNumber#"
        val intent = Intent(Intent.ACTION_CALL)
        intent.data = Uri.parse(uri)
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE)
                == PackageManager.PERMISSION_GRANTED) {
            startActivity(intent)
        }
    }
}
