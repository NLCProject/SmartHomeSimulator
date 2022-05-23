package org.household.entities.powerUnit

import org.household.entities.powerUnit.interfaces.IPowerUnitRepository
import org.isc.utils.genericCrudl.services.RepositoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PowerUnitRepository @Autowired constructor(
    repository: IPowerUnitRepository
) : RepositoryService<PowerUnitEntity>(repository = repository)
