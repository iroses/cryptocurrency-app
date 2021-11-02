package com.irvinerp.cryptocurrencyapp.domain.repository

import com.irvinerp.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.irvinerp.cryptocurrencyapp.data.remote.dto.CoinDto

interface CoinRepository {

  suspend fun getCoins(): List<CoinDto>

  suspend fun getCoinById(coinId: String): CoinDetailDto
}