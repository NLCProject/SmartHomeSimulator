package org.smart.home.simulator.services.migration.data

object PowerChargers {

    val data = listOf(
        PowerCharger(
            name = "Power Charger #1",
            smartHomeId = "83ab1a38-ea46-40b2-8a63-ee61ed57355a",
            currentChargingRate = 308.4,
            maxChargingRate = 350.0,
            enabled = true
        ),

        PowerCharger(
            name = "Power Charger #1",
            smartHomeId = "ebe3c27b-364b-45d0-af41-46f411251f99",
            currentChargingRate = 246.8,
            maxChargingRate = 300.0,
            enabled = true
        ),

        PowerCharger(
            name = "Power Charger #2",
            smartHomeId = "ebe3c27b-364b-45d0-af41-46f411251f99",
            currentChargingRate = 0.0,
            maxChargingRate = 300.0,
            enabled = false
        )
    )

    class PowerCharger(
        var name: String,
        var smartHomeId: String,
        var currentChargingRate: Double,
        var maxChargingRate: Double,
        var enabled: Boolean
    )
}
