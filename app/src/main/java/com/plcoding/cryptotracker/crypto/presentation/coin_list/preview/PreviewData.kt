package com.plcoding.cryptotracker.crypto.presentation.coin_list.preview

import com.plcoding.cryptotracker.crypto.domain.Coin
import com.plcoding.cryptotracker.crypto.presentation.models.toCoinUi

internal val previewCoin = Coin(
    id = "bitcoin",
    rank = 1,
    name = "Bitcoin",
    symbol = "BTC",
    marketCapUsd = 1241273958896.75,
    priceUsd = 62858.15,
    changePercent24Hr = -0.1
).toCoinUi()