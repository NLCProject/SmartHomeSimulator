package org.household.test

import org.household.entities.electricalDevice.ElectricalDevice
import org.household.entities.electricalDevice.ElectricalDeviceEntity
import org.household.entities.electricalDevice.ElectricalDeviceRepository
import org.household.entities.powerCharger.PowerChargerEntity
import org.household.entities.powerCharger.PowerChargerRepository
import org.household.entities.powerStorage.PowerStorageEntity
import org.household.entities.powerStorage.PowerStorageRepository
import org.household.entities.powerUnit.PowerUnit
import org.household.entities.powerUnit.PowerUnitEntity
import org.household.entities.powerUnit.PowerUnitRepository
import org.household.entities.smartHome.SmartHomeEntity
import org.household.entities.smartHome.SmartHomeRepository
import org.household.entities.smartMeter.FlowDirection
import org.household.entities.smartMeter.SmartMeterEntity
import org.household.entities.smartMeter.SmartMeterRepository
import org.isc.utils.models.CurrentUser
import org.isc.utils.utils.Ids
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotlin.random.Random

/**
 *
 */
@Service
class TestHelperService @Autowired constructor(
    private val electricalDeviceRepository: ElectricalDeviceRepository,
    private val powerChargerRepository: PowerChargerRepository,
    private val powerStorageRepository: PowerStorageRepository,
    private val powerUnitRepository: PowerUnitRepository,
    private val smartMeterRepository: SmartMeterRepository,
    private val smartHomeRepository: SmartHomeRepository,
) {

    /**
     *
     */
    fun createSmartHome(currentUser: CurrentUser): SmartHomeEntity {
        val smartHome = SmartHomeEntity()
        smartHome.name = Ids.getRandomId()
        smartHome.organisationId = currentUser.organisationId
        return smartHomeRepository.save(entity = smartHome, currentUser = currentUser)
    }

    /**
     *
     */
    fun createElectricalDevice(
        smartHome: SmartHomeEntity? = null,
        currentUser: CurrentUser
    ): ElectricalDeviceEntity {
        val device = ElectricalDeviceEntity()
        device.name = Ids.getRandomId()
        device.currentPowerConsumption = getRandomDouble()
        device.maxPowerConsumption = getRandomDouble()
        device.type = ElectricalDevice.values().random()
        device.enabled = getRandomBoolean()
        device.smartHome = smartHome ?: createSmartHome(currentUser = currentUser)
        device.organisationId = currentUser.organisationId
        return electricalDeviceRepository.save(entity = device, currentUser = currentUser)
    }

    /**
     *
     */
    fun createPowerCharger(
        smartHome: SmartHomeEntity? = null,
        currentUser: CurrentUser
    ): PowerChargerEntity {
        val powerCharger = PowerChargerEntity()
        powerCharger.name = Ids.getRandomId()
        powerCharger.currentChargingRate = getRandomDouble()
        powerCharger.maxChargingRate = getRandomDouble()
        powerCharger.enabled = getRandomBoolean()
        powerCharger.smartHome = smartHome ?: createSmartHome(currentUser = currentUser)
        powerCharger.organisationId = currentUser.organisationId
        return powerChargerRepository.save(entity = powerCharger, currentUser = currentUser)
    }

    /**
     *
     */
    fun createPowerStorage(
        smartHome: SmartHomeEntity? = null,
        currentUser: CurrentUser
    ): PowerStorageEntity {
        val powerStorage = PowerStorageEntity()
        powerStorage.name = Ids.getRandomId()
        powerStorage.currentChargingRate = getRandomDouble()
        powerStorage.maxChargingRate = getRandomDouble()
        powerStorage.currentChargingRate = getRandomDouble()
        powerStorage.maxChargingRate = getRandomDouble()
        powerStorage.enabled = getRandomBoolean()
        powerStorage.smartHome = smartHome ?: createSmartHome(currentUser = currentUser)
        powerStorage.organisationId = currentUser.organisationId
        return powerStorageRepository.save(entity = powerStorage, currentUser = currentUser)
    }

    /**
     *
     */
    fun createPowerUnit(
        smartHome: SmartHomeEntity? = null,
        currentUser: CurrentUser
    ): PowerUnitEntity {
        val powerUnit = PowerUnitEntity()
        powerUnit.name = Ids.getRandomId()
        powerUnit.currentPowerGeneration = getRandomDouble()
        powerUnit.maxPowerGeneration = getRandomDouble()
        powerUnit.enabled = getRandomBoolean()
        powerUnit.type = PowerUnit.values().random()
        powerUnit.smartHome = smartHome ?: createSmartHome(currentUser = currentUser)
        powerUnit.organisationId = currentUser.organisationId
        return powerUnitRepository.save(entity = powerUnit, currentUser = currentUser)
    }

    /**
     *
     */
    fun createSmartMeter(currentUser: CurrentUser): SmartMeterEntity {
        val powerUnit = SmartMeterEntity()
        powerUnit.name = Ids.getRandomId()
        powerUnit.currentFlowRate = getRandomDouble()
        powerUnit.maxFlowRate = getRandomDouble()
        powerUnit.powerExported = getRandomDouble()
        powerUnit.powerImported = getRandomDouble()
        powerUnit.flowDirection = FlowDirection.values().random()
        powerUnit.smartHome = createSmartHome(currentUser = currentUser)
        powerUnit.organisationId = currentUser.organisationId
        return smartMeterRepository.save(entity = powerUnit, currentUser = currentUser)
    }

    private fun getRandomBoolean(): Boolean = Random.nextBoolean()

    private fun getRandomDouble(min: Double = 0.0, max: Double = 10000.0): Double =
        Random.nextDouble(from = min, until = max)
}