package org.smart.home.simulator.dto

import org.isc.utils.annotations.GenerateTsModel
import org.isc.utils.annotations.ValidateContent
import org.isc.utils.enums.ValidationType
import org.isc.utils.genericCrudl.models.IscModel
import org.smart.home.simulator.entities.powerUnit.PowerUnit

/**
 * Power unit.
 */
@GenerateTsModel
class PowerUnitModel : IscModel() {

    /**
     * Assigned smart home ID.
     */
    @ValidateContent(type = ValidationType.StringNotEmpty)
    val smartHomeId: String = String()

    /**
     * Unit name
     */
    @ValidateContent(type = ValidationType.StringNotEmpty)
    var name: String = String()

    /**
     * Maximum power generation in kWh.
     */
    @ValidateContent(type = ValidationType.NotZeroOrLower)
    var maxPowerGeneration: Double = 0.0

    /**
     * Current power generation in kWh.
     */
    @ValidateContent(type = ValidationType.NotLowerZero)
    var currentPowerGeneration: Double = 0.0

    /**
     * Power unit type.
     */
    var type: PowerUnit = PowerUnit.Other

    /**
     * Power status.
     */
    var enabled: Boolean = false
}
