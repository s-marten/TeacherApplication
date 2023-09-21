package ru.marten.teacherapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.marten.teacherapplication.databinding.ActivityWithFragmentBinding

class WithFragmentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWithFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWithFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnReplace.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(binding.fragmentContainer.id, ListViewFragment.newInstance())
                .commitNow()
        }

    }
}