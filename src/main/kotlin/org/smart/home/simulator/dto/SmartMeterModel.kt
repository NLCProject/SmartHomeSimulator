package org.smart.home.simulator.dto

import org.isc.utils.annotations.GenerateTsModel
import org.isc.utils.annotations.ValidateContent
import org.isc.utils.enums.ValidationType
import org.isc.utils.genericCrudl.models.IscModel
import org.smart.home.simulator.entities.smartMeter.FlowDirection

/**
 *
 */
@GenerateTsModel
class SmartMeterModel : IscModel() {

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
    var powerExported: Double = 0.0

    /**
     *
     */
    @ValidateContent(type = ValidationType.NotLowerZero)
    var powerImported: Double = 0.0

    /**
     *
     */
    @ValidateContent(type = ValidationType.NotLowerZero)
    var currentFlowRate: Double = 0.0

    /**
     *
     */
    @ValidateContent(type = ValidationType.NotZeroOrLower)
    var maxFlowRate: Double = 0.0

    /**
     *
     */
    var flowDirection: FlowDirection = FlowDirection.Export
}
