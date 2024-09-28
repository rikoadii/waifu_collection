package com.submissionandroid.waifucollection

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DetailWaifuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_waifu)
        val dataWaifu = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Waifu>("key_waifu", Waifu::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("key_waifu")
        }
        if (dataWaifu != null) {
            val detailWaifuImageView: ImageView = findViewById(R.id.waifu_image)
            val detailWaifuNameTextView: TextView = findViewById(R.id.waifu_name)
            val detailWaifuAnimeTextView: TextView = findViewById(R.id.waifu_anime)
            val detailWaifuDescriptionTextView: TextView = findViewById(R.id.waifu_description)
            val detailWaifuBirthdayTextView: TextView = findViewById(R.id.waifu_birthday)
            val detailWaifuAgeTextView: TextView = findViewById(R.id.waifu_age)

            detailWaifuImageView.setImageResource(dataWaifu.photo)
            detailWaifuNameTextView.text = dataWaifu.name
            detailWaifuAnimeTextView.text = dataWaifu.anime
            detailWaifuBirthdayTextView.text = dataWaifu.birthday
            detailWaifuAgeTextView.text = dataWaifu.age
            detailWaifuDescriptionTextView.text = dataWaifu.description
        }
        val fabShare: FloatingActionButton = findViewById(R.id.action_share)
        fabShare.setOnClickListener {
            if (dataWaifu != null) {
                val shareText = "${dataWaifu.name} form anime ${dataWaifu.anime}\nBirthday : ${dataWaifu.birthday}\n Age : ${dataWaifu.age}\nDescription : ${dataWaifu.description}"
                val shareIntent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, shareText)
                    type = "text/plain"
                }
                startActivity(Intent.createChooser(shareIntent, "Share to"))
            } else {
                Toast.makeText(this, "Data waifu is null", Toast.LENGTH_SHORT).show()
            }
        }
    }
}