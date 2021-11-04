package com.irvinerp.cryptocurrencyapp.presentation.coin_detail

import com.irvinerp.cryptocurrencyapp.domain.model.CoinDetail

data class CoinDetailState(
  val isLoading: Boolean = false,
  val coin: CoinDetail? = null,
  val error: String = ""
)