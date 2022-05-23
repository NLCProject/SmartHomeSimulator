package org.household.dto

import org.household.entities.powerUnit.PowerUnit
import org.isc.utils.annotations.GenerateTsModel
import org.isc.utils.annotations.ValidateContent
import org.isc.utils.enums.ValidationType
import org.isc.utils.genericCrudl.models.IscModel

/**
 *
 */
@GenerateTsModel
class PowerUnitModel : IscModel() {

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
    @ValidateContent(type = ValidationType.NotZeroOrLower)
    var maxPowerGeneration: Double = 0.0

    /**
     *
     */
    @ValidateContent(type = ValidationType.NotLowerZero)
    var currentPowerGeneration: Double = 0.0

    /**
     *
     */
    var type: PowerUnit = PowerUnit.Other
}
