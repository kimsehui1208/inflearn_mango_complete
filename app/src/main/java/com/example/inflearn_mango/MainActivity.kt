package com.example.inflearn_mango

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val items = mutableListOf<ContentsModel>()


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bookmarkButton = findViewById<TextView>(R.id.bookmarkBtn)
        bookmarkButton.setOnClickListener {

            val intent = Intent(this, BookmarkActivity::class.java)
            startActivity(intent)
        }


        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/XRoMziImmYCC",
            "https://mp-seoul-image-production-s3.mangoplate.com/331247/60039_1596540913676_34054?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
            "뉴욕택시디저트"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/LKE4ycSOaEnd",
                "https://mp-seoul-image-production-s3.mangoplate.com/132097_1662381451917629.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "컨시어지 커피"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/IP_JKNwjYkyz",
                "https://mp-seoul-image-production-s3.mangoplate.com/1841276_1614760706342622.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "아키비스트"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/QqeR-5G5uWnd",
                "https://mp-seoul-image-production-s3.mangoplate.com/1433827_1600236996000090.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "카카오봄"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/vCgSj_O_Xjy9",
                "https://mp-seoul-image-production-s3.mangoplate.com/457540/9239_1633409173661_73196?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "프롤라"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/85X6w7IYsEEj",
                "https://mp-seoul-image-production-s3.mangoplate.com/705256_1640252159456331.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "구테로이테"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/6CZwyyCzr6qI",
                "https://mp-seoul-image-production-s3.mangoplate.com/957883_1678107233984074.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "조이스팔라펠 "
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/T8JmmKQ0hcD-",
                "https://mp-seoul-image-production-s3.mangoplate.com/333417_1638514844880617.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "바이두부"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/t2fQWuwIP4Bv",
                "https://mp-seoul-image-production-s3.mangoplate.com/910432_1679028291342377.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "푸드더즈매터"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/LKE4ycSOaEnd",
                "https://mp-seoul-image-production-s3.mangoplate.com/132097_1662381451917629.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "컨시어지 커피"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/TDG9lv1aXWkG",
                "https://mp-seoul-image-production-s3.mangoplate.com/113339_1669223738083249.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "피봇"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/vaSEEQafFwKF",
                "https://mp-seoul-image-production-s3.mangoplate.com/added_restaurants/354889_1473237481855916.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "지노스뉴욕피자"
            )
        )

        val recyclerview = findViewById<RecyclerView>(R.id.rv)
        val rvAdapter = RVAdapter(this,items)
        recyclerview.adapter = rvAdapter

        rvAdapter.itemClick = object:RVAdapter.ItemClick{
            override fun onClick(view : View, position: Int){

                val intent = Intent(baseContext, ViewActivity::class.java)
                intent.putExtra("url",items[position].url)
                intent.putExtra("title",items[position].titleText)
                intent.putExtra("imageUrl",items[position].imageUrl)

                startActivity(intent)
            }

        }

        recyclerview.layoutManager = GridLayoutManager(this,2)

    }
}