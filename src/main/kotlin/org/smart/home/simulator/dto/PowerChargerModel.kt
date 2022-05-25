package org.smart.home.simulator.dto

import org.isc.utils.annotations.GenerateTsModel
import org.isc.utils.annotations.ValidateContent
import org.isc.utils.enums.ValidationType
import org.isc.utils.genericCrudl.models.IscModel

/**
 *
 */
@GenerateTsModel
class PowerChargerModel : IscModel() {

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
    var currentChargingRate: Double = 0.0

    /**
     *
     */
    @ValidateContent(type = ValidationType.NotZeroOrLower)
    var maxChargingRate: Double = 0.0

    /**
     *
     */
    var enabled: Boolean = false
}
