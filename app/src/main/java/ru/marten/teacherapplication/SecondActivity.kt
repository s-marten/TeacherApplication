package ru.marten.teacherapplication

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import ru.marten.teacherapplication.databinding.ActivitySecondBinding

class SecondActivity : BaseActivity(SecondActivity::class.java.name) {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerContainer.apply {
            layoutManager = LinearLayoutManager(this@SecondActivity)
            adapter = MyRvAdapter(getItemsList())
        }
    }

    private fun getItemsList(): List<String> {
        val items = mutableListOf<String>()

        for (i in 0..20) {
            items.add(i.toString())
        }

        return items
    }
}