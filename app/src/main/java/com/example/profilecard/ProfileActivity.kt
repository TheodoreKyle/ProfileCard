package com.example.profilecard

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val username = intent.getStringExtra("username")
        val tvUsername = findViewById<TextView>(R.id.tvUser)
        tvUsername.text = username
        val btnLogout = findViewById<Button>(R.id.btnLogout)

        btnLogout.setOnClickListener {
            showLogoutDialog()
        }
    }

    private fun showLogoutDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_logout)
        dialog.setCancelable(false)

        val btnYes = dialog.findViewById<Button>(R.id.btnYes)
        val btnNo = dialog.findViewById<Button>(R.id.btnNo)

        btnNo.setOnClickListener { dialog.dismiss() }
        btnYes.setOnClickListener {
            dialog.dismiss()
            finishAffinity()
        }
        dialog.show()
        dialog.window?.apply {
            setLayout(
                (resources.displayMetrics.widthPixels * 0.9).toInt(),
                android.view.ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }
    }
}