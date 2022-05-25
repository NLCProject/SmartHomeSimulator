package org.smart.home.simulator.services.migration.data

/**
 *
 */
object PowerStorages {

    val data = listOf(
        PowerStorage(
            name = "Energiespeicher",
            smartHomeId = "83ab1a38-ea46-40b2-8a63-ee61ed57355a",
            currentChargingRate = 0.0,
            maxChargingRate = 1800.0,
            maxPower = 12_000.0,
            currentPower = 11_768.4,
            enabled = true
        ),

        PowerStorage(
            name = "Energiespeicher",
            smartHomeId = "ebe3c27b-364b-45d0-af41-46f411251f99",
            currentChargingRate = 453.0,
            maxChargingRate = 2000.0,
            maxPower = 50_000.0,
            currentPower = 2_452.0,
            enabled = true
        )
    )

    class PowerStorage(
        var name: String,
        var smartHomeId: String,
        var currentChargingRate: Double,
        var maxChargingRate: Double,
        var maxPower: Double,
        var currentPower: Double,
        var enabled: Boolean
    )
}
