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
        val binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).supportActionBar?.apply{
            title = "Match details"
            setDisplayUseLogoEnabled(false)
            setDisplayHomeAsUpEnabled(true)
        }

        val bundle = arguments
        if (bundle != null && bundle.containsKey("matchId")) {
            val id = bundle.getString("matchId")?.toInt()
            if (id != null) {
                setMatchDetailsById(view, id)
            }
        }
    }

    private fun setMatchDetailsById(view: View, matchId: Int) {
        // TODO get match info by id
        val match = matchById(matchId)

        // TODO set match info
        view.apply {
            findViewById<TextView>(R.id.txtDate).text = dateUtcFormatted(match.dateUtc)
            findViewById<TextView>(R.id.txtRound).text = getString(R.string.round_msg, match.roundNumber)
            findViewById<TextView>(R.id.txtHomeTeam).text = match.homeTeam
            findViewById<TextView>(R.id.txtAwayTeam).text = match.awayTeam
            findViewById<TextView>(R.id.txtScore).text = getString(R.string.score_msg, match.homeTeamScore, match.awayTeamScore)
            findViewById<TextView>(R.id.txtGroup).text = if (match.group != null) getString(R.string.group_msg, match.group) else ""
            findViewById<TextView>(R.id.txtLocation).text = match.location
            findViewById<TextView>(R.id.txtMatchId).text = getString(R.string.match_id_msg, matchId)
        }
    }

    private fun dateUtcFormatted(dateUtc: String): String {
        val localDate = LocalDateTime
            .parse(
                dateUtc,
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss'Z'")
            )
            .atZone(ZoneId.of("UTC"))
        val dayOfWeek = localDate.dayOfWeek.getDisplayName(
            TextStyle.FULL,
            Locale("en", "EN")
        )
        val formatter = DateTimeFormatter
            .ofPattern(
                "dd MMMM yyyy - HH:mm",
                Locale("en", "EN")
            )
            .withZone(ZoneId.systemDefault())

        return "$dayOfWeek, ${localDate.format(formatter)}"
    }
}