package org.smart.home.simulator.dto

import org.isc.utils.annotations.GenerateTsModel
import org.isc.utils.annotations.ValidateContent
import org.isc.utils.enums.ValidationType
import org.isc.utils.genericCrudl.models.IscModel
import org.smart.home.simulator.entities.smartMeter.FlowDirection

/**
 * Smart meter.
 */
@GenerateTsModel
class SmartMeterModel : IscModel() {

    /**
     * Assigned smart home ID.
     */
    @ValidateContent(type = ValidationType.StringNotEmpty)
    val smartHomeId: String = String()

    /**
     * Smart meter name.
     */
    @ValidateContent(type = ValidationType.StringNotEmpty)
    var name: String = String()

    /**
     * Power exported in kWh.
     */
    @ValidateContent(type = ValidationType.NotLowerZero)
    var powerExported: Double = 0.0

    /**
     * Power imported in kWh.
     */
    @ValidateContent(type = ValidationType.NotLowerZero)
    var powerImported: Double = 0.0

    /**
     * Current power flow rate in kWh.
     */
    @ValidateContent(type = ValidationType.NotLowerZero)
    var currentFlowRate: Double = 0.0

    /**
     * Maximum power flow rate in kWh.
     */
    @ValidateContent(type = ValidationType.NotZeroOrLower)
    var maxFlowRate: Double = 0.0

    /**
     * Power flow direction.
     */
    var flowDirection: FlowDirection = FlowDirection.Export
}
