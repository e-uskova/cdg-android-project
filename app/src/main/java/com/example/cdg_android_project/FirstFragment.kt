package com.example.cdg_android_project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cdg_android_project.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private val previewAdapter: PreviewAdapter by lazy { PreviewAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentFirstBinding.inflate(inflater, container, false)

        (activity as AppCompatActivity).supportActionBar?.title = "  Premier League Fixtures"
        (activity as AppCompatActivity).supportActionBar?.setDisplayUseLogoEnabled(true)
        (activity as AppCompatActivity).supportActionBar?.setLogo(R.drawable.baseline_sports_soccer_24)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<RecyclerView>(R.id.recyclerView).apply {
            this.adapter = previewAdapter
            setHasFixedSize(true)
            addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }

        // TODO get data
        previewAdapter.submitList(generateFakeValues())

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

    private fun generateFakeValues(): List<String> = List(20) { i -> "Match $i"}
}