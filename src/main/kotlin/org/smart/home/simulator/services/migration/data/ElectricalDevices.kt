package org.smart.home.simulator.services.migration.data

/**
 *
 */
object ElectricalDevices {

    val data = listOf(
        ElectricalDevice(
            name = "Computer Wohnzimmer",
            smartHomeId = "83ab1a38-ea46-40b2-8a63-ee61ed57355a",
            currentPowerConsumption = 59.1,
            maxPowerConsumption = 75.0,
            enabled = true,
            type = org.smart.home.simulator.entities.electricalDevice.ElectricalDevice.Computer
        ),

        ElectricalDevice(
            name = "Backofen",
            smartHomeId = "83ab1a38-ea46-40b2-8a63-ee61ed57355a",
            currentPowerConsumption = 0.0,
            maxPowerConsumption = 230.0,
            enabled = false,
            type = org.smart.home.simulator.entities.electricalDevice.ElectricalDevice.Other
        ),

        ElectricalDevice(
            name = "Kühlschrank",
            smartHomeId = "83ab1a38-ea46-40b2-8a63-ee61ed57355a",
            currentPowerConsumption = 160.4,
            maxPowerConsumption = 190.0,
            enabled = true,
            type = org.smart.home.simulator.entities.electricalDevice.ElectricalDevice.Fridge
        ),

        ElectricalDevice(
            name = "Lampe #1",
            smartHomeId = "83ab1a38-ea46-40b2-8a63-ee61ed57355a",
            currentPowerConsumption = 20.4,
            maxPowerConsumption = 25.0,
            enabled = true,
            type = org.smart.home.simulator.entities.electricalDevice.ElectricalDevice.Lamp
        ),

        ElectricalDevice(
            name = "Lampe #2",
            smartHomeId = "83ab1a38-ea46-40b2-8a63-ee61ed57355a",
            currentPowerConsumption = 0.0,
            maxPowerConsumption = 25.0,
            enabled = true,
            type = org.smart.home.simulator.entities.electricalDevice.ElectricalDevice.Lamp
        ),

        ElectricalDevice(
            name = "Arbeitsplatz #1",
            smartHomeId = "ebe3c27b-364b-45d0-af41-46f411251f99",
            currentPowerConsumption = 106.1,
            maxPowerConsumption = 120.0,
            enabled = true,
            type = org.smart.home.simulator.entities.electricalDevice.ElectricalDevice.Other
        ),

        ElectricalDevice(
            name = "Arbeitsplatz #2",
            smartHomeId = "ebe3c27b-364b-45d0-af41-46f411251f99",
            currentPowerConsumption = 95.3,
            maxPowerConsumption = 120.0,
            enabled = true,
            type = org.smart.home.simulator.entities.electricalDevice.ElectricalDevice.Other
        ),

        ElectricalDevice(
            name = "Arbeitsplatz #3",
            smartHomeId = "ebe3c27b-364b-45d0-af41-46f411251f99",
            currentPowerConsumption = 0.0,
            maxPowerConsumption = 120.0,
            enabled = false,
            type = org.smart.home.simulator.entities.electricalDevice.ElectricalDevice.Other
        ),

        ElectricalDevice(
            name = "Arbeitsplatz #4",
            smartHomeId = "ebe3c27b-364b-45d0-af41-46f411251f99",
            currentPowerConsumption = 120.6,
            maxPowerConsumption = 140.0,
            enabled = true,
            type = org.smart.home.simulator.entities.electricalDevice.ElectricalDevice.Other
        ),

        ElectricalDevice(
            name = "Arbeitsplatz #5",
            smartHomeId = "ebe3c27b-364b-45d0-af41-46f411251f99",
            currentPowerConsumption = 80.0,
            maxPowerConsumption = 120.0,
            enabled = true,
            type = org.smart.home.simulator.entities.electricalDevice.ElectricalDevice.Other
        )
    )

    class ElectricalDevice(
        var name: String,
        var smartHomeId: String,
        var currentPowerConsumption: Double,
        var maxPowerConsumption: Double,
        var enabled: Boolean,
        var type: org.smart.home.simulator.entities.electricalDevice.ElectricalDevice
    )
}
