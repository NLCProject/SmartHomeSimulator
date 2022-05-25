package org.smart.home.simulator.services.migration

import org.isc.utils.models.CurrentUser
import org.isc.utils.tests.CurrentUserFactory
import org.slf4j.LoggerFactory
import org.smart.home.simulator.Organisation
import org.smart.home.simulator.entities.smartHome.SmartHomeRepository
import org.smart.home.simulator.services.migration.data.*
import org.smart.home.simulator.services.migration.interfaces.IMigrationService
import org.smart.home.simulator.test.TestHelperService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class MigrationService @Autowired constructor(
    private val smartHomeRepository: SmartHomeRepository,
    private val testHelperService: TestHelperService
) : IMigrationService {

    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun startMigration() {
        logger.info("Starting data migration")
        val currentUser = CurrentUserFactory.getCurrentUser(
            organisationId = Organisation.id,
            organisationName = Organisation.name
        )

        importSmartHomes(currentUser = currentUser)
        importSmartMeters(currentUser = currentUser)
        importElectricalDevices(currentUser = currentUser)
        importPowerChargers(currentUser = currentUser)
        importPowerStorages(currentUser = currentUser)
        importPowerUnits(currentUser = currentUser)
        logger.info("Data migration finished")
    }

    private fun importSmartHomes(currentUser: CurrentUser) {
        logger.info("Importing smart homes")
        SmartHomes.data.forEach {
            testHelperService.createSmartHome(id = it.id, name = it.name, currentUser = currentUser)
        }
    }

    private fun importSmartMeters(currentUser: CurrentUser) {
        logger.info("Importing smart meters")
        SmartMeters.data.forEach {
            val smartHome = smartHomeRepository.findById(id = it.smartHomeId, currentUser = currentUser)
            testHelperService.createSmartMeter(
                name = it.name,
                currentFlowRate = it.currentFlowRate,
                maxFlowRate = it.maxFlowRate,
                powerExported = it.powerExported,
                powerImported = it.powerImported,
                flowDirection = it.flowDirection,
                smartHome = smartHome,
                currentUser = currentUser
            )
        }
    }

    private fun importElectricalDevices(currentUser: CurrentUser) {
        logger.info("Importing electrical devices")
        ElectricalDevices.data.forEach {
            val smartHome = smartHomeRepository.findById(id = it.smartHomeId, currentUser = currentUser)
            testHelperService.createElectricalDevice(
                name = it.name,
                currentPowerConsumption = it.currentPowerConsumption,
                maxPowerConsumption = it.maxPowerConsumption,
                type = it.type,
                enabled = it.enabled,
                smartHome = smartHome,
                currentUser = currentUser
            )
        }
    }

    private fun importPowerChargers(currentUser: CurrentUser) {
        logger.info("Importing power chargers")
        PowerChargers.data.forEach {
            val smartHome = smartHomeRepository.findById(id = it.smartHomeId, currentUser = currentUser)
            testHelperService.createPowerCharger(
                name = it.name,
                currentChargingRate = it.currentChargingRate,
                maxChargingRate = it.maxChargingRate,
                enabled = it.enabled,
                smartHome = smartHome,
                currentUser = currentUser
            )
        }
    }

    private fun importPowerStorages(currentUser: CurrentUser) {
        logger.info("Importing power storages")
        PowerStorages.data.forEach {
            val smartHome = smartHomeRepository.findById(id = it.smartHomeId, currentUser = currentUser)
            testHelperService.createPowerStorage(
                name = it.name,
                currentPower = it.currentPower,
                maxPower = it.maxPower,
                maxChargingRate = it.maxChargingRate,
                currentChargingRate = it.currentChargingRate,
                enabled = it.enabled,
                smartHome = smartHome,
                currentUser = currentUser
            )
        }
    }

    private fun importPowerUnits(currentUser: CurrentUser) {
        logger.info("Importing power units")
        PowerUnits.data.forEach {
            val smartHome = smartHomeRepository.findById(id = it.smartHomeId, currentUser = currentUser)
            testHelperService.createPowerUnit(
                name = it.name,
                currentPowerGeneration = it.currentPowerGeneration,
                maxPowerGeneration = it.maxPowerGeneration,
                type = it.type,
                enabled = it.enabled,
                smartHome = smartHome,
                currentUser = currentUser
            )
        }
    }
}
