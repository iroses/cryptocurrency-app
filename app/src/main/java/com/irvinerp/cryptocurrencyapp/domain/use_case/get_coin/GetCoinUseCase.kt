package com.irvinerp.cryptocurrencyapp.domain.use_case.get_coin

import com.irvinerp.cryptocurrencyapp.common.Resource
import com.irvinerp.cryptocurrencyapp.common.Resource.Error
import com.irvinerp.cryptocurrencyapp.common.Resource.Loading
import com.irvinerp.cryptocurrencyapp.common.Resource.Success
import com.irvinerp.cryptocurrencyapp.data.remote.dto.toCoinDetail
import com.irvinerp.cryptocurrencyapp.domain.model.CoinDetail
import com.irvinerp.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
  private val repository: CoinRepository
) {

  operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
    try {
      emit(Loading())
      val coin = repository.getCoinById(coinId = coinId).toCoinDetail()
      emit(Success(coin))
    } catch (e: HttpException) {
      // request error
      emit(Error(e.localizedMessage ?: "An unexpected error occurred"))
    } catch (e: IOException) {
      // red error
      emit(Error("Couldn't reach server. Check your internet connection."))
    }
  }
}