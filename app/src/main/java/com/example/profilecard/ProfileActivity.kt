package com.example.profilecard

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val username = intent.getStringExtra("username")
        val tvUsername = findViewById<TextView>(R.id.tvUser)
        tvUsername.text = username

        val layout2 = findViewById<LinearLayout>(R.id.layout2)

        val btnGenerate = findViewById<Button>(R.id.btnGenerate)
        val tvNum1 = findViewById<TextView>(R.id.tvNum1)
        val tvNum2 = findViewById<TextView>(R.id.tvNum2)
        val tvNum3 = findViewById<TextView>(R.id.tvNum3)

        btnGenerate.setOnClickListener {
            layout2.visibility = View.VISIBLE
            /* Only when the Generate Numbers button is clicked
               will the Visibility of the LinearLayout is true/seen */

            val num1 = (0..999999).random()
            val num2 = (0..999999).random()
            val num3 = (0..999999).random()
            // For larger numbers

            tvNum1.text = "First Number: " + num1.toString()
            tvNum2.text = "Second Number: " + num2.toString()
            tvNum3.text = "Third Number: " + num3.toString()
        }

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