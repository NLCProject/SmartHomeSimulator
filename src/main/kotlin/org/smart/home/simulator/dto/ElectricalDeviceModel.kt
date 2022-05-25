package org.smart.home.simulator.dto

import org.isc.utils.annotations.GenerateTsModel
import org.isc.utils.annotations.ValidateContent
import org.isc.utils.enums.ValidationType
import org.isc.utils.genericCrudl.models.IscModel
import org.smart.home.simulator.entities.electricalDevice.ElectricalDevice

/**
 *
 */
@GenerateTsModel
class ElectricalDeviceModel : IscModel() {

    /**
     *
     */
    @ValidateContent(type = ValidationType.StringNotEmpty)
    val smartHomeId: String = String()

    /**
     *
     */
    @ValidateContent(type = ValidationType.StringNotEmpty)
    var name: String = String()

    /**
     *
     */
    @ValidateContent(type = ValidationType.NotLowerZero)
    var currentPowerConsumption: Double = 0.0

    /**
     *
     */
    @ValidateContent(type = ValidationType.NotZeroOrLower)
    var maxPowerConsumption: Double = 0.0

    /**
     *
     */
    var enabled: Boolean = false

    /**
     *
     */
    var type: ElectricalDevice = ElectricalDevice.Other
}
