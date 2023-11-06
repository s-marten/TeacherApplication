package ru.marten.teacherapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import ru.marten.teacherapplication.R
import ru.marten.teacherapplication.databinding.ActivityProgressBinding
import ru.marten.teacherapplication.databinding.ActivitySaveDataBinding
import ru.marten.teacherapplication.model.LoginRepository
import ru.marten.teacherapplication.util.createWithFactory
import ru.marten.teacherapplication.viewmodel.LoginViewModel
import ru.marten.teacherapplication.viewmodel.SaveDataViewModel

class SaveDataActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySaveDataBinding

    private val saveDataViewModel by lazy {
        ViewModelProvider(
            this,
            createWithFactory {
                SaveDataViewModel(this)
            }
        )[SaveDataViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySaveDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveToPrefsBtn.setOnClickListener {
            saveData(SaveDataViewModel.SHARED_PREFS)
        }
        binding.readFromPrefsBtn.setOnClickListener {
            saveDataViewModel.read(SaveDataViewModel.SHARED_PREFS)
        }
        binding.saveToStoreBtn.setOnClickListener {
            saveData(SaveDataViewModel.DATA_STORE)
        }
        binding.readFromStoreBtn.setOnClickListener {
            saveDataViewModel.read(SaveDataViewModel.DATA_STORE)
        }
        binding.saveToDbBtn.setOnClickListener {
            saveData(SaveDataViewModel.DATA_BASE)
        }
        binding.readFromDbBtn.setOnClickListener {
            saveDataViewModel.read(SaveDataViewModel.DATA_BASE)
        }

        saveDataViewModel.data.observe(this) {
            binding.dataTextView.text = it
        }
    }

    private fun saveData(saveTo: String) {
        binding.editData.text.toString().apply {
            saveDataViewModel.save(saveTo, this)
            binding.dataTextView.text = this
            binding.editData.text.clear()
        }
    }
}