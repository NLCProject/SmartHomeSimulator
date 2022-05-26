package org.smart.home.simulator.dto

import org.isc.utils.annotations.GenerateTsModel
import org.isc.utils.annotations.ValidateContent
import org.isc.utils.enums.ValidationType
import org.isc.utils.genericCrudl.models.IscModel
import org.smart.home.simulator.entities.electricalDevice.ElectricalDevice

/**
 * Electrical devices (e.g. computer, television or fridge).
 */
@GenerateTsModel
class ElectricalDeviceModel : IscModel() {

    /**
     * Assigned smart home ID.
     */
    @ValidateContent(type = ValidationType.StringNotEmpty)
    val smartHomeId: String = String()

    /**
     * Device name.
     */
    @ValidateContent(type = ValidationType.StringNotEmpty)
    var name: String = String()

    /**
     * Current power consumption in kWh.
     */
    @ValidateContent(type = ValidationType.NotLowerZero)
    var currentPowerConsumption: Double = 0.0

    /**
     * Max power consumption in kWh.
     */
    @ValidateContent(type = ValidationType.NotZeroOrLower)
    var maxPowerConsumption: Double = 0.0

    /**
     * Power status.
     */
    var enabled: Boolean = false

    /**
     * Device type.
     */
    var type: ElectricalDevice = ElectricalDevice.Other
}
