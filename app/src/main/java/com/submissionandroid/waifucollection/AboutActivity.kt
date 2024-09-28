package com.submissionandroid.waifucollection

import android.content.res.Resources
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val profileImageView: ImageView = findViewById(R.id.profile_image)
        val profileNameTextView: TextView = findViewById(R.id.profile_name)
        val profileEmailTextView: TextView = findViewById(R.id.profile_email)


        profileImageView.setImageResource(R.drawable.me)
        profileNameTextView.text = getString(R.string.riko_adi_ranasmita)
        profileEmailTextView.text = getString(R.string.email)
    }
}
