package org.household.entities.powerCharger

import org.household.entities.powerCharger.interfaces.IPowerChargerRepository
import org.isc.utils.genericCrudl.services.RepositoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PowerChargerRepository @Autowired constructor(
    repository: IPowerChargerRepository
) : RepositoryService<PowerChargerEntity>(repository = repository)
