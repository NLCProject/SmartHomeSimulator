package org.household.entities.powerStorage

import org.household.entities.powerStorage.interfaces.IPowerStorageRepository
import org.isc.utils.genericCrudl.services.RepositoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PowerStorageRepository @Autowired constructor(
    repository: IPowerStorageRepository
) : RepositoryService<PowerStorageEntity>(repository = repository)
