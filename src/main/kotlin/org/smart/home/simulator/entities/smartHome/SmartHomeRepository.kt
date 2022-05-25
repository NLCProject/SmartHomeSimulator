package org.smart.home.simulator.entities.smartHome

import org.isc.utils.genericCrudl.services.RepositoryService
import org.smart.home.simulator.entities.smartHome.interfaces.ISmartHomeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SmartHomeRepository @Autowired constructor(
    repository: ISmartHomeRepository
) : RepositoryService<SmartHomeEntity>(repository = repository)
