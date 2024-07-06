package com.example.cdg_android_project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.cdg_android_project.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSecondBinding.inflate(inflater, container, false)

        (activity as AppCompatActivity).supportActionBar?.title = "Match details"
        (activity as AppCompatActivity).supportActionBar?.setDisplayUseLogoEnabled(false)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        fun setMatchDetailsById(matchId: Int) {
            // TODO get match info by id

            // TODO set match info

            val matchIdView = binding.root.findViewById<TextView>(R.id.txtId)
            matchIdView.text = "Match ID: $matchId"
        }

        val bundle = arguments
        if (bundle != null && bundle.containsKey("matchId")) {
            val id = bundle.getString("matchId")?.toInt()
            if (id != null) {
                setMatchDetailsById(id)
            }
        }

        return binding.root
    }
}