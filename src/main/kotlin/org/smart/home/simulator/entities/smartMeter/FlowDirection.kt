package org.smart.home.simulator.entities.smartMeter

import org.isc.utils.annotations.GenerateTsModel
import org.isc.utils.annotations.I18nKeys

/**
 * Power flow direction
 */
@I18nKeys
@GenerateTsModel
enum class FlowDirection {

    /**
     * Power is imported and bought.
     */
    Import,

    /**
     * Power is exported and sold.
     */
    Export
}
