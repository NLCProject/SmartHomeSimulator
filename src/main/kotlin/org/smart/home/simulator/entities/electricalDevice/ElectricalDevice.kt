package org.smart.home.simulator.entities.electricalDevice

import org.isc.utils.annotations.GenerateTsModel
import org.isc.utils.annotations.I18nKeys

/**
 * Electrical device type.
 */
@I18nKeys
@GenerateTsModel
enum class ElectricalDevice {

    DishWasher,
    Lamp,
    Television,
    Oven,
    Fridge,
    Computer,
    Other
}
