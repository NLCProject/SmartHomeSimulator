package org.smart.home.simulator.services.migration

import org.isc.utils.models.CurrentUser
import org.isc.utils.tests.CurrentUserFactory
import org.slf4j.LoggerFactory
import org.smart.home.simulator.Organisation
import org.smart.home.simulator.services.migration.data.SmartHomes
import org.smart.home.simulator.services.migration.interfaces.IMigrationService
import org.smart.home.simulator.test.TestHelperService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MigrationService @Autowired constructor(
    private val testHelperService: TestHelperService
): IMigrationService {

    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun startMigration() {
        logger.info("Starting data migration")
        val currentUser = CurrentUserFactory.getCurrentUser(
            organisationId = Organisation.id,
            organisationName = Organisation.name
        )

        importSmartHomes(currentUser = currentUser)
        logger.info("Data migration finished")
    }

    private fun importSmartHomes(currentUser: CurrentUser) {
        logger.info("Importing smart homes")
        SmartHomes.data.forEach {
            testHelperService.createSmartHome(id = it.id, name = it.name, currentUser = currentUser)
        }
    }
}