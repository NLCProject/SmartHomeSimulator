package org.household.dto

import org.household.entities.smartMeter.FlowDirection
import org.isc.utils.annotations.GenerateTsModel
import org.isc.utils.annotations.ValidateContent
import org.isc.utils.enums.ValidationType
import org.isc.utils.genericCrudl.models.IscModel

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
