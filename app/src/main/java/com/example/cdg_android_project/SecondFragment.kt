package com.example.cdg_android_project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.example.cdg_android_project.ui.Details

class SecondFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lateinit var match: Match

        val bundle = arguments

        if (bundle != null && bundle.containsKey("match")) {
            val matchBundle = bundle.getParcelable<Match>("match")
            if (matchBundle != null) {
                match = matchBundle
            } else {
                throw NullPointerException()
            }
        } else {
            throw NullPointerException()
        }

        (view as ComposeView).apply {
            setContent {
                Details(match = match)
            }
        }

        (requireActivity() as AppCompatActivity).supportActionBar?.apply{
            title = "Match details"
            setDisplayUseLogoEnabled(false)
            setDisplayHomeAsUpEnabled(true)
        }
    }
}
