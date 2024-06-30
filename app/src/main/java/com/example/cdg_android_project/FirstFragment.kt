package com.example.cdg_android_project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.cdg_android_project.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentFirstBinding.inflate(inflater, container, false)

        binding.btnDetails.setOnClickListener() {
            val fragment = SecondFragment()
            val ft = getParentFragmentManager().beginTransaction()
            ft.replace(R.id.frame_layout, fragment)
            ft.commit()
        }

        (activity as AppCompatActivity).supportActionBar?.title = "  Premier League Fixtures"
        (activity as AppCompatActivity).supportActionBar?.setDisplayUseLogoEnabled(true)
        (activity as AppCompatActivity).supportActionBar?.setLogo(R.drawable.baseline_sports_soccer_24)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)

        return binding.root
    }
}