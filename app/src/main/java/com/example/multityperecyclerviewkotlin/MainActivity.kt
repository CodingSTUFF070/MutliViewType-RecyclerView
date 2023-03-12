package com.example.multityperecyclerviewkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.multityperecyclerviewkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mList: ArrayList<DataItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        mList = ArrayList()
        prepareData()

        val adapter = MainAdapter(mList)
        binding.recyclerView.adapter = adapter
    }

    private fun prepareData() {

        mList.add(
            DataItem(
                "Captain America : The First Avenger",
                "During World War II, Steve Rogers decides to volunteer in an experiment that transforms his weak body. He must now battle a secret Nazi organisation headed by Johann Schmidt to defend his nation.",
                R.drawable.captain,
                null
            )
        )
        mList.add(
            DataItem(
                "The Incredible Hulk",
                null,
                null,
                R.drawable.hulk_logo
            )
        )

        mList.add(
            DataItem(
                "Avengers: Endgame",
                "After Thanos, an intergalactic warlord, disintegrates half of the universe, the Avengers must reunite and assemble again to reinvigorate their trounced allies and restore balance.",
                R.drawable.avengers_endgame,
                null
            )
        )

        mList.add(
            DataItem(
                "Doctor Strange",
                null,
                null,
                R.drawable.doc_strange_logo
            )
        )

        mList.add(
            DataItem(
                "Captain America : The First Avenger",
                "During World War II, Steve Rogers decides to volunteer in an experiment that transforms his weak body. He must now battle a secret Nazi organisation headed by Johann Schmidt to defend his nation.",
                R.drawable.captain,
                null
            )
        )

        mList.add(
            DataItem(
                "Avengers: Endgame",
                "After Thanos, an intergalactic warlord, disintegrates half of the universe, the Avengers must reunite and assemble again to reinvigorate their trounced allies and restore balance.",
                R.drawable.avengers_endgame,
                null
            )
        )

        mList.add(
            DataItem(
                "The Incredible Hulk",
                null,
                null,
                R.drawable.hulk_logo
            )
        )

    }

}