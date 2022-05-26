package org.smart.home.simulator.dto

import org.isc.utils.annotations.GenerateTsModel
import org.isc.utils.annotations.ValidateContent
import org.isc.utils.enums.ValidationType
import org.isc.utils.genericCrudl.models.IscModel

/**
 * Smart Home.
 */
@GenerateTsModel
class SmartHomeModel : IscModel() {

    /**
     * Smart Home name.
     */
    @ValidateContent(type = ValidationType.StringNotEmpty)
    var name: String = String()

    /**
     * Is true if another entity is assigned to this (e.g. electrical device or power unit).
     */
    var canBeDeleted: Boolean = false
}
