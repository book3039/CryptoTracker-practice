package com.plcoding.cryptotracker.crypto.core.domain

import com.plcoding.cryptotracker.crypto.core.domain.util.NetworkError
import com.plcoding.cryptotracker.crypto.core.domain.util.Result
import com.plcoding.cryptotracker.crypto.domain.Coin

interface CoinDataSource {
    suspend fun getCoins(): Result<List<Coin>, NetworkError>
}