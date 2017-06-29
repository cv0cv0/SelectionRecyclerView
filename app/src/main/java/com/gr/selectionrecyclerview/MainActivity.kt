package com.gr.selectionrecyclerview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.gr.selectionrecyclerview.adapter.CityAdapter
import com.gr.selectionrecyclerview.entity.City
import com.gr.selectionrecyclerview.util.ProvinceDecoration
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val datas=parseJson()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CityAdapter(this, datas)
        recyclerView.addItemDecoration(ProvinceDecoration(datas))
    }

    private fun parseJson(): ArrayList<City> {
        val datas = ArrayList<City>()
        val jsonArray = JSONArray(readAsset())
        for (i in 0..jsonArray.length() - 1) {
            val province = jsonArray.getJSONObject(i)
            val citys = province.getJSONArray("city")
            (0..citys.length() - 1)
                    .map { citys.getJSONObject(it) }
                    .mapTo(datas) { City(it.getString("name"), province.getString("name")) }
        }
        return datas
    }

    private fun readAsset(): String {
        val inputStream = assets.open("province_data.json")
        val inputStreamReader = InputStreamReader(inputStream)
        val bufferedReader = BufferedReader(inputStreamReader)
        val stringBuilder = StringBuilder()
        while (bufferedReader.ready()) {
            stringBuilder.append(bufferedReader.readLine())
        }
        bufferedReader.close()
        inputStreamReader.close()
        inputStream.close()
        return stringBuilder.toString()
    }
}
