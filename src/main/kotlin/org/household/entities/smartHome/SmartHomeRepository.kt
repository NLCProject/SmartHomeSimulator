package org.household.entities.smartHome

import org.household.entities.smartHome.interfaces.ISmartHomeRepository
import org.isc.utils.genericCrudl.services.RepositoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SmartHomeRepository @Autowired constructor(
    repository: ISmartHomeRepository
) : RepositoryService<SmartHomeEntity>(repository = repository)
