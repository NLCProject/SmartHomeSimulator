package org.smart.home.simulator.dto

import kotlinx.serialization.Serializable
import org.isc.utils.annotations.GenerateTsModel
import org.isc.utils.annotations.RestrictModelToEntityConversion
import org.isc.utils.enums.ConversionRestriction
import org.isc.utils.genericCrudl.models.IscModel

/**
 *
 */
@Serializable
@GenerateTsModel
class ErrorLogModel : IscModel() {

    /**
     *
     */
    var className: String = String()

    /**
     *
     */
    var errorOrganisationId: String = String()

    /**
     *
     */
    var errorOrganisationName: String = String()

    /**
     *
     */
    var message: String = String()

    /**
     *
     */
    var userId: String = String()

    /**
     *
     */
    var stacktrace: String = String()

    /**
     *
     */
    var i18nKey: String = String()

    /**
     *
     */
    @RestrictModelToEntityConversion(restriction = ConversionRestriction.Ignore)
    var dateCreated: String = String()

    /**
     *
     */
    @RestrictModelToEntityConversion(restriction = ConversionRestriction.Ignore)
    var time: String = String()

    /**
     *
     */
    var highlighted: Boolean = false
}
