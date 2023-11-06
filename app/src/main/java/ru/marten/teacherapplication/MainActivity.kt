package ru.marten.teacherapplication

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import ru.marten.teacherapplication.databinding.ActivityMainBinding
import ru.marten.teacherapplication.view.LoginActivity
import ru.marten.teacherapplication.view.SaveDataActivity
import ru.marten.teacherapplication.view.SecondActivity

class MainActivity : BaseActivity(MainActivity::class.java.name) {

    lateinit var binding: ActivityMainBinding

    var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.testBtn.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

//        binding.textView.text = (applicationContext as MyApplication).counter.toString()

        binding.incrementBtn.setOnClickListener {
//            CounterHolder.getInstance().increment()
//            (applicationContext as MyApplication).counter = (applicationContext as MyApplication).counter + 1
//            binding.textView.text = (applicationContext as MyApplication).counter.toString()
        }

        binding.thirdBtn.setOnClickListener {
            startActivity(Intent(this, WithFragmentActivity::class.java))
        }

        binding.btnLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        binding.btnProgress.setOnClickListener {
            startActivity(Intent(this, ProgressActivity::class.java))
        }

        binding.btnSaveData.setOnClickListener {
            startActivity(Intent(this, SaveDataActivity::class.java))
        }
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putInt(COUNTER_KEY, counter)
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle?,
        persistentState: PersistableBundle?
    ) {
        super.onRestoreInstanceState(savedInstanceState, persistentState)
        savedInstanceState?.let {
            counter = it.getInt(COUNTER_KEY)
            binding.textView.text = counter.toString()
        }
    }

    companion object {
        const val COUNTER_KEY = "counter"
    }

}