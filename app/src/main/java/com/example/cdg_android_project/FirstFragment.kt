package com.example.cdg_android_project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cdg_android_project.databinding.FragmentFirstBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FirstFragment : Fragment() {
    private val previewAdapter: PreviewAdapter by lazy { PreviewAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "  Premier League Fixtures"
            setDisplayUseLogoEnabled(true)
            setLogo(R.drawable.baseline_sports_soccer_24)
            setDisplayHomeAsUpEnabled(false)
        }

        view.findViewById<RecyclerView>(R.id.recyclerView).apply {
            this.adapter = previewAdapter
            setHasFixedSize(true)
            addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }

        lifecycleScope.launch(Dispatchers.IO) {
            previewAdapter.submitList(getData())
        }

        previewAdapter.setOnItemClickListener(object : PreviewAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                val bundle = Bundle()
                bundle.putParcelable("match", previewAdapter.getItem(position))

                val details = SecondFragment()
                details.setArguments(bundle)

                val ft = getParentFragmentManager().beginTransaction()
                ft.replace(R.id.frame_layout, details)
                ft.commit()
            }
        })
    }

    private suspend fun getData(): List<Match> {
        val listValues = mutableListOf<Match>()
        getMatchesInfo(20).collect {
            listValues.add(it)
        }
        return listValues
    }
}
