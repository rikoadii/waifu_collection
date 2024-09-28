package com.submissionandroid.waifucollection

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvWaifu: RecyclerView
    private val list = ArrayList<Waifu>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvWaifu = findViewById(R.id.rv_waifu)
        rvWaifu.setHasFixedSize(true)

        list.addAll(getListWaifu())
        showRecyclerList()
    }

    private fun getListWaifu(): ArrayList<Waifu> {
        val dataName = resources.getStringArray(R.array.name_waifu_array)
        val dataAnime = resources.getStringArray(R.array.anime_waifu_array)
        val dataDescription = resources.getStringArray(R.array.description_waifu_array)
        val dataCheckWiki = resources.getStringArray(R.array.waifu_wiki_array)
        val dataPhoto = resources.obtainTypedArray(R.array.image_waifu_array)
        val dataWatchAnime = resources.getStringArray(R.array.watch_anime_array)
        val dataBirthday = resources.getStringArray(R.array.waifu_birthday)
        val dataAge = resources.getStringArray(R.array.waifu_age)
        val listWaifu = ArrayList<Waifu>()
        for (i in dataName.indices) {
            val waifu = Waifu(
                dataName[i],
                dataAnime[i],
                dataDescription[i],
                dataCheckWiki[i],
                dataPhoto.getResourceId(i, -1),
                dataBirthday[i],
                dataAge[i],
                dataWatchAnime[i]
            )
            listWaifu.add(waifu)
        }
        dataPhoto.recycle()
        return listWaifu
    }

    private fun showRecyclerList() {
        rvWaifu.layoutManager = LinearLayoutManager(this)
        val listWaifuAdapter = ListWaifuAdapter(list)
        rvWaifu.adapter = listWaifuAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.about_page -> {

                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
