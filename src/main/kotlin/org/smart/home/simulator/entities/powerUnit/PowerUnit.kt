package org.smart.home.simulator.entities.powerUnit

import org.isc.utils.annotations.GenerateTsModel
import org.isc.utils.annotations.I18nKeys

/**
 *
 */
@I18nKeys
@GenerateTsModel
enum class PowerUnit {

    /**
     *
     */
    SolarPanel,

    /**
     *
     */
    WindTurbine,

    /**
     *
     */
    Hydropower,

    /**
     *
     */
    Other
}
