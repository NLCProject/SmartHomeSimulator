package org.smart.home.simulator.dto

import org.isc.utils.annotations.GenerateTsModel
import org.isc.utils.annotations.ValidateContent
import org.isc.utils.enums.ValidationType
import org.isc.utils.genericCrudl.models.IscModel

/**
 * Power Storage.
 */
@GenerateTsModel
class PowerStorageModel : IscModel() {

    /**
     * Assigned smart home ID.
     */
    @ValidateContent(type = ValidationType.StringNotEmpty)
    val smartHomeId: String = String()

    /**
     * Storage name.
     */
    @ValidateContent(type = ValidationType.StringNotEmpty)
    var name: String = String()

    /**
     * Current charging rate in kWh.
     */
    @ValidateContent(type = ValidationType.NotLowerZero)
    var currentChargingRate: Double = 0.0

    /**
     * Maximum charging rate in kWh.
     */
    @ValidateContent(type = ValidationType.NotZeroOrLower)
    var maxChargingRate: Double = 0.0

    /**
     * Maximum power in kWh.
     */
    @ValidateContent(type = ValidationType.NotZeroOrLower)
    var maxPower: Double = 0.0

    /**
     * Current power in kWh.
     */
    @ValidateContent(type = ValidationType.NotLowerZero)
    var currentPower: Double = 0.0

    /**
     * Power status.
     */
    var enabled: Boolean = false
}
