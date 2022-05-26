package org.smart.home.simulator.test

import org.isc.utils.models.CurrentUser
import org.isc.utils.utils.Ids
import org.smart.home.simulator.entities.electricalDevice.ElectricalDevice
import org.smart.home.simulator.entities.electricalDevice.ElectricalDeviceEntity
import org.smart.home.simulator.entities.electricalDevice.ElectricalDeviceRepository
import org.smart.home.simulator.entities.powerCharger.PowerChargerEntity
import org.smart.home.simulator.entities.powerCharger.PowerChargerRepository
import org.smart.home.simulator.entities.powerStorage.PowerStorageEntity
import org.smart.home.simulator.entities.powerStorage.PowerStorageRepository
import org.smart.home.simulator.entities.powerUnit.PowerUnit
import org.smart.home.simulator.entities.powerUnit.PowerUnitEntity
import org.smart.home.simulator.entities.powerUnit.PowerUnitRepository
import org.smart.home.simulator.entities.smartHome.SmartHomeEntity
import org.smart.home.simulator.entities.smartHome.SmartHomeRepository
import org.smart.home.simulator.entities.smartMeter.FlowDirection
import org.smart.home.simulator.entities.smartMeter.SmartMeterEntity
import org.smart.home.simulator.entities.smartMeter.SmartMeterRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotlin.random.Random

/**
 * Service is used for testing purpose to create and save valid entities.
 */
@Service
class TestHelperService @Autowired constructor(
    private val electricalDeviceRepository: ElectricalDeviceRepository,
    private val powerChargerRepository: PowerChargerRepository,
    private val powerStorageRepository: PowerStorageRepository,
    private val powerUnitRepository: PowerUnitRepository,
    private val smartMeterRepository: SmartMeterRepository,
    private val smartHomeRepository: SmartHomeRepository
) {

    fun createSmartHome(
        id: String = Ids.getRandomId(),
        name: String = Ids.getRandomId(),
        currentUser: CurrentUser
    ): SmartHomeEntity {
        val smartHome = SmartHomeEntity()
        smartHome.id = id
        smartHome.name = name
        smartHome.organisationId = currentUser.organisationId
        return smartHomeRepository.save(entity = smartHome, currentUser = currentUser)
    }

    fun createElectricalDevice(
        name: String = Ids.getRandomId(),
        currentPowerConsumption: Double = getRandomDouble(),
        maxPowerConsumption: Double = getRandomDouble(),
        type: ElectricalDevice = ElectricalDevice.values().random(),
        enabled: Boolean = getRandomBoolean(),
        smartHome: SmartHomeEntity? = null,
        currentUser: CurrentUser
    ): ElectricalDeviceEntity {
        val device = ElectricalDeviceEntity()
        device.name = name
        device.currentPowerConsumption = currentPowerConsumption
        device.maxPowerConsumption = maxPowerConsumption
        device.type = type
        device.enabled = enabled
        device.smartHome = smartHome ?: createSmartHome(currentUser = currentUser)
        device.organisationId = currentUser.organisationId
        return electricalDeviceRepository.save(entity = device, currentUser = currentUser)
    }

    fun createPowerCharger(
        name: String = Ids.getRandomId(),
        currentChargingRate: Double = getRandomDouble(),
        maxChargingRate: Double = getRandomDouble(),
        smartHome: SmartHomeEntity? = null,
        enabled: Boolean = getRandomBoolean(),
        currentUser: CurrentUser
    ): PowerChargerEntity {
        val powerCharger = PowerChargerEntity()
        powerCharger.name = name
        powerCharger.currentChargingRate = currentChargingRate
        powerCharger.maxChargingRate = maxChargingRate
        powerCharger.enabled = enabled
        powerCharger.smartHome = smartHome ?: createSmartHome(currentUser = currentUser)
        powerCharger.organisationId = currentUser.organisationId
        return powerChargerRepository.save(entity = powerCharger, currentUser = currentUser)
    }

    fun createPowerStorage(
        name: String = Ids.getRandomId(),
        currentChargingRate: Double = getRandomDouble(),
        maxChargingRate: Double = getRandomDouble(),
        currentPower: Double = getRandomDouble(),
        maxPower: Double = getRandomDouble(),
        enabled: Boolean = getRandomBoolean(),
        smartHome: SmartHomeEntity? = null,
        currentUser: CurrentUser
    ): PowerStorageEntity {
        val powerStorage = PowerStorageEntity()
        powerStorage.name = name
        powerStorage.currentChargingRate = currentChargingRate
        powerStorage.maxChargingRate = maxChargingRate
        powerStorage.maxPower = maxPower
        powerStorage.currentPower = currentPower
        powerStorage.enabled = enabled
        powerStorage.smartHome = smartHome ?: createSmartHome(currentUser = currentUser)
        powerStorage.organisationId = currentUser.organisationId
        return powerStorageRepository.save(entity = powerStorage, currentUser = currentUser)
    }

    fun createPowerUnit(
        name: String = Ids.getRandomId(),
        currentPowerGeneration: Double = getRandomDouble(),
        maxPowerGeneration: Double = getRandomDouble(),
        type: PowerUnit = PowerUnit.values().random(),
        enabled: Boolean = getRandomBoolean(),
        smartHome: SmartHomeEntity? = null,
        currentUser: CurrentUser
    ): PowerUnitEntity {
        val powerUnit = PowerUnitEntity()
        powerUnit.name = name
        powerUnit.currentPowerGeneration = currentPowerGeneration
        powerUnit.maxPowerGeneration = maxPowerGeneration
        powerUnit.enabled = enabled
        powerUnit.type = type
        powerUnit.smartHome = smartHome ?: createSmartHome(currentUser = currentUser)
        powerUnit.organisationId = currentUser.organisationId
        return powerUnitRepository.save(entity = powerUnit, currentUser = currentUser)
    }

    fun createSmartMeter(
        name: String = Ids.getRandomId(),
        currentFlowRate: Double = getRandomDouble(),
        maxFlowRate: Double = getRandomDouble(),
        powerExported: Double = getRandomDouble(),
        powerImported: Double = getRandomDouble(),
        flowDirection: FlowDirection = FlowDirection.values().random(),
        smartHome: SmartHomeEntity? = null,
        currentUser: CurrentUser
    ): SmartMeterEntity {
        val powerUnit = SmartMeterEntity()
        powerUnit.name = name
        powerUnit.currentFlowRate = currentFlowRate
        powerUnit.maxFlowRate = maxFlowRate
        powerUnit.powerExported = powerExported
        powerUnit.powerImported = powerImported
        powerUnit.flowDirection = flowDirection
        powerUnit.smartHome = smartHome ?: createSmartHome(currentUser = currentUser)
        powerUnit.organisationId = currentUser.organisationId
        return smartMeterRepository.save(entity = powerUnit, currentUser = currentUser)
    }

    private fun getRandomBoolean(): Boolean = Random.nextBoolean()

    private fun getRandomDouble(min: Double = 0.0, max: Double = 10000.0): Double =
        Random.nextDouble(from = min, until = max)
}
