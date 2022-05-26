package org.smart.home.simulator.entities.powerUnit

import org.isc.utils.annotations.GenerateTsModel
import org.isc.utils.annotations.I18nKeys

/**
 * Power unit type.
 */
@I18nKeys
@GenerateTsModel
enum class PowerUnit {

    SolarPanel,
    WindTurbine,
    Hydropower,
    Other
}
