package com.example.amphibian

import com.squareup.moshi.Json

data class AmphibianData(
    @Json (name = "name") val name: String,
    @Json (name = "type") val type: String,
    @Json (name ="description") val description: String
)
