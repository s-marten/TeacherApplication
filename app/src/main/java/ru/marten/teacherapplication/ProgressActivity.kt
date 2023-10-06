package ru.marten.teacherapplication

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import androidx.appcompat.app.AppCompatActivity
import ru.marten.teacherapplication.databinding.ActivityProgressBinding

class ProgressActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProgressBinding

    private var progress: Int = 0

    private val progressThread = Runnable {
        while (progress < 100) {
            handler.sendMessage(handler.obtainMessage())
            Thread.sleep(1000)
        }
    }

    private val handler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            progress += 10
            binding.horizontalProgress.setProgress(progress, true)
        }
    }

    private val thread = Thread(progressThread)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProgressBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            progress = 0
            thread.start()
//            startOnUiThread()
        }
    }

    private fun startOnUiThread() {
        while (progress < 100) {
            progress += 10
            binding.horizontalProgress.setProgress(progress, true)
            Thread.sleep(1000)
        }
    }
}