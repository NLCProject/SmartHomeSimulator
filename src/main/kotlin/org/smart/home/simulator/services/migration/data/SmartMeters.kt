package org.smart.home.simulator.services.migration.data

import org.smart.home.simulator.entities.smartMeter.FlowDirection

object SmartMeters {

    val data = listOf(
        SmartMeter(
            name = "Smart Meter",
            smartHomeId = "83ab1a38-ea46-40b2-8a63-ee61ed57355a",
            powerExported = 36_781.2,
            powerImported = 109_450.6,
            currentFlowRate = 106.4,
            maxFlowRate = 250.0,
            flowDirection = FlowDirection.Export
        ),

        SmartMeter(
            name = "Smart Meter",
            smartHomeId = "ebe3c27b-364b-45d0-af41-46f411251f99",
            powerExported = 78_403.9,
            powerImported = 16_008.6,
            currentFlowRate = 183.0,
            maxFlowRate = 400.0,
            flowDirection = FlowDirection.Export
        )
    )

    class SmartMeter(
        var name: String,
        var smartHomeId: String,
        var powerExported: Double,
        var powerImported: Double,
        var currentFlowRate: Double,
        var maxFlowRate: Double,
        var flowDirection: FlowDirection
    )
}
