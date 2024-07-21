package com.example.cdg_android_project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import androidx.fragment.app.Fragment
import com.example.cdg_android_project.databinding.ActivityMainBinding
import com.example.cdg_android_project.databinding.FragmentSecondBinding
import com.example.cdg_android_project.ui.Details
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale

class SecondFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lateinit var match: FMatch

        val bundle = arguments
        if (bundle != null && bundle.containsKey("matchId")) {
            val id = bundle.getString("matchId")?.toInt()
            if (id != null) {
                match = matchById(id)
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