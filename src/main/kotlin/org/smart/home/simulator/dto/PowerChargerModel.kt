package org.smart.home.simulator.dto

import org.isc.utils.annotations.GenerateTsModel
import org.isc.utils.annotations.ValidateContent
import org.isc.utils.enums.ValidationType
import org.isc.utils.genericCrudl.models.IscModel

/**
 * Power Charger
 */
@GenerateTsModel
class PowerChargerModel : IscModel() {

    /**
     * Assigned smart home ID.
     */
    @ValidateContent(type = ValidationType.StringNotEmpty)
    val smartHomeId: String = String()

    /**
     * Charger name.
     */
    @ValidateContent(type = ValidationType.StringNotEmpty)
    var name: String = String()

    /**
     * Current charging rate in kWh.
     */
    @ValidateContent(type = ValidationType.NotLowerZero)
    var currentChargingRate: Double = 0.0

    /**
     * Max charging rate in kWh.
     */
    @ValidateContent(type = ValidationType.NotZeroOrLower)
    var maxChargingRate: Double = 0.0

    /**
     * Power status.
     */
    var enabled: Boolean = false
}
