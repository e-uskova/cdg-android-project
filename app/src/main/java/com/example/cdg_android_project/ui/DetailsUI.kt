package com.example.cdg_android_project.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cdg_android_project.Match
import com.example.cdg_android_project.R
import com.example.cdg_android_project.dateUtcFormatted
import com.example.cdg_android_project.matchMock


@Preview(showSystemUi = true)
@Composable
fun PreviewDetails() {
    Details(match = matchMock)
}

@Composable
fun Details(match: Match) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
    ) {
        HeaderInfo(
            date = match.dateUtc,
            round = match.roundNumber
        )
        TeamsScore(
            homeTeamName = match.homeTeam,
            awayTeamName = match.awayTeam,
            homeTeamScore = match.homeTeamScore,
            awayTeamScore = match.awayTeamScore
        )
        FooterInfo(
            group = match.group,
            location = match.location,
            matchId = match.matchNumber
        )
    }
}

@Composable
fun HeaderInfo(
    date: String,
    round: Int
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = dateUtcFormatted(date),
            fontSize = 20.sp,
            modifier = Modifier
                .padding(top = 24.dp)
        )
        Text(
            text = stringResource(R.string.round_msg, round),
            fontSize = 16.sp,
            modifier = Modifier
                .padding(top = 24.dp)
        )
    }
}

@Composable
fun TeamsScore(
    homeTeamName: String,
    awayTeamName: String,
    homeTeamScore: Int,
    awayTeamScore: Int
) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()

    ) {
        Team(ImageBitmap.imageResource(
            id = R.drawable.football_club),
            name = homeTeamName,
            modifier = Modifier
                .weight(0.15f)
                .fillMaxHeight(0.3f)
        )
        Text(
            text = "$homeTeamScore : $awayTeamScore",
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .weight(0.1f)
        )
        Team(ImageBitmap.imageResource(
            id = R.drawable.football_club),
            name = awayTeamName,
            modifier = Modifier
                .weight(0.15f)
                .fillMaxHeight(0.3f)
        )
    }
}

@Composable
fun Team(
    image: ImageBitmap,
    name: String,
    modifier: Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(
            bitmap = image,
            contentDescription = name,
            alpha = 0.2f,
            modifier = Modifier
                .size(128.dp)
                .padding(8.dp)
//                .clip(CircleShape)
        )
        Text(
            text = name,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(8.dp)
        )
    }
}

@Composable
fun FooterInfo(
    group: String?,
    location: String,
    matchId: Int
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = group ?: "",
            fontSize = 16.sp,
            modifier = Modifier
                .padding(bottom = 24.dp)
        )
        Text(
            text = location,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )
        Text(
            text = stringResource(R.string.match_id_msg, matchId),
            fontSize = 14.sp,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )
    }
}