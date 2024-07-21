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

        // TODO get data
        //previewAdapter.submitList(generateFakeValues())

        lifecycleScope.launch(Dispatchers.IO) {
            previewAdapter.submitList(getData())
        }

        previewAdapter.setOnItemClickListener(object : PreviewAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                val bundle = Bundle()
                // TODO get id by position
                bundle.putString("matchId", position.toString())

                val details: SecondFragment = SecondFragment()
                details.setArguments(bundle)

                val ft = getParentFragmentManager().beginTransaction()
                ft.replace(R.id.frame_layout, details)
                ft.commit()
            }
        })
    }

    private suspend fun getData(): List<String> {
        val listValues = mutableListOf<String>()
        val webApi = WebApi()
        webApi.getMatches().collect {
            listValues.add(it)
        }
        return listValues
    }

    private fun generateFakeValues(): List<String> = List(20) { i -> "Match $i"}
}