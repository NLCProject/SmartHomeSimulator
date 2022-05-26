package org.smart.home.simulator.services.migration.data

object PowerUnits {

    val data = listOf(
        PowerUnit(
            name = "Solarpanel #1",
            smartHomeId = "83ab1a38-ea46-40b2-8a63-ee61ed57355a",
            maxPowerGeneration = 950.0,
            currentPowerGeneration = 260.7,
            type = org.smart.home.simulator.entities.powerUnit.PowerUnit.SolarPanel,
            enabled = true
        ),

        PowerUnit(
            name = "Solarpanel #2",
            smartHomeId = "83ab1a38-ea46-40b2-8a63-ee61ed57355a",
            maxPowerGeneration = 950.0,
            currentPowerGeneration = 264.5,
            type = org.smart.home.simulator.entities.powerUnit.PowerUnit.SolarPanel,
            enabled = true
        ),

        PowerUnit(
            name = "Solarpanel #1",
            smartHomeId = "ebe3c27b-364b-45d0-af41-46f411251f99",
            maxPowerGeneration = 1300.0,
            currentPowerGeneration = 840.0,
            type = org.smart.home.simulator.entities.powerUnit.PowerUnit.SolarPanel,
            enabled = true
        ),

        PowerUnit(
            name = "Solarpanel #2",
            smartHomeId = "ebe3c27b-364b-45d0-af41-46f411251f99",
            maxPowerGeneration = 1250.0,
            currentPowerGeneration = 836.4,
            type = org.smart.home.simulator.entities.powerUnit.PowerUnit.SolarPanel,
            enabled = true
        )
    )

    class PowerUnit(
        var name: String,
        var smartHomeId: String,
        var maxPowerGeneration: Double,
        var currentPowerGeneration: Double,
        var type: org.smart.home.simulator.entities.powerUnit.PowerUnit,
        var enabled: Boolean
    )
}
