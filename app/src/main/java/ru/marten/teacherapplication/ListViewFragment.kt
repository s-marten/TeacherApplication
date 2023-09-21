package ru.marten.teacherapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import ru.marten.teacherapplication.databinding.ListViewFragmentBinding

class ListViewFragment: Fragment()  {

    private var _binding: ListViewFragmentBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ListViewFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.listView.apply {
            adapter = ArrayAdapter(
                this@ListViewFragment.requireContext(),
                android.R.layout.simple_list_item_1,
                getItemsList())
        }
    }

    private fun getItemsList(): List<String> {
        val items = mutableListOf<String>()

        for (i in 0..20) {
            items.add(i.toString())
        }

        return items
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = ListViewFragment()
    }
}