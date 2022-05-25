package org.smart.home.simulator.services.migration.interfaces

import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener

/**
 *
 */
interface IMigrationService {

    @EventListener(ApplicationReadyEvent::class)
    fun startMigration()
}
