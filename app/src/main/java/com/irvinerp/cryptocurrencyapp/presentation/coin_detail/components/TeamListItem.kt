package com.irvinerp.cryptocurrencyapp.presentation.coin_detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.irvinerp.cryptocurrencyapp.data.remote.dto.TeamMember
import com.irvinerp.cryptocurrencyapp.presentation.ui.theme.CryptocurrencyAppTheme

@Composable
fun TeamListItem(
  teamMember: TeamMember,
  modifier: Modifier = Modifier
) {
  Column(
    modifier = modifier,
    verticalArrangement = Arrangement.Center
  ) {
    Text(
      text = teamMember.name,
      style = MaterialTheme.typography.h4
    )
    Spacer(modifier = Modifier.height(4.dp))
    Text(
      text = teamMember.position,
      style = MaterialTheme.typography.body2,
      fontStyle = FontStyle.Italic
    )
  }
}

@Preview(showBackground = true)
@Composable
fun TeamListItemPreview() {
  CryptocurrencyAppTheme {
    TeamListItem(
      teamMember = TeamMember(
        id = "0",
        name = "Irvin",
        position = "1"
      )
    )
  }
}