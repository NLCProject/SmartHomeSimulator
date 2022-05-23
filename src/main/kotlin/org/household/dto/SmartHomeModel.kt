package org.household.dto

import org.isc.utils.annotations.GenerateTsModel
import org.isc.utils.annotations.ValidateContent
import org.isc.utils.enums.ValidationType
import org.isc.utils.genericCrudl.models.IscModel

/**
 *
 */
@GenerateTsModel
class SmartHomeModel : IscModel() {

    /**
     *
     */
    @ValidateContent(type = ValidationType.StringNotEmpty)
    var name: String = String()

    /**
     *
     */
    var canBeDeleted: Boolean = false
}
