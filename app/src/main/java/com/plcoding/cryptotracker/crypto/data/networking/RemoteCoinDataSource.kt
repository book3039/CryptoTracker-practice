package com.plcoding.cryptotracker.crypto.data.networking

import android.util.Log
import com.plcoding.cryptotracker.BuildConfig
import com.plcoding.cryptotracker.crypto.core.data.networking.constructUrl
import com.plcoding.cryptotracker.crypto.core.data.networking.safeCall
import com.plcoding.cryptotracker.crypto.core.domain.CoinDataSource
import com.plcoding.cryptotracker.crypto.core.domain.util.NetworkError
import com.plcoding.cryptotracker.crypto.core.domain.util.Result
import com.plcoding.cryptotracker.crypto.core.domain.util.map
import com.plcoding.cryptotracker.crypto.data.mappers.toCoin
import com.plcoding.cryptotracker.crypto.data.networking.dto.CoinsResponseDto
import com.plcoding.cryptotracker.crypto.domain.Coin
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class RemoteCoinDataSource(
    private val httpClient: HttpClient
) : CoinDataSource {
    override suspend fun getCoins(): Result<List<Coin>, NetworkError> {
        return safeCall<CoinsResponseDto> {
            httpClient.get(
                urlString = constructUrl("/assets?apiKey=${BuildConfig.API_KEY}")
            )
        }.map { response ->
            response.data.map { it.toCoin() }
        }
    }
}