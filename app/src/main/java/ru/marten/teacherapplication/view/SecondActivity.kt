package ru.marten.teacherapplication.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import ru.marten.teacherapplication.BaseActivity
import ru.marten.teacherapplication.MyRvAdapter
import ru.marten.teacherapplication.databinding.ActivitySecondBinding
import ru.marten.teacherapplication.viewmodel.SpellsViewModel

class SecondActivity : BaseActivity(SecondActivity::class.java.name) {

    private lateinit var binding: ActivitySecondBinding

    private val spellsViewModel: SpellsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        spellsViewModel.fetchSpells()

        spellsViewModel.spellsData.observe(this) { data ->
            binding.recyclerContainer.apply {
                layoutManager = LinearLayoutManager(this@SecondActivity)
                adapter = MyRvAdapter(data)
            }
        }
    }
}