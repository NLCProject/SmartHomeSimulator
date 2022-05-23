package org.household.entities.smartMeter

import org.household.entities.smartMeter.interfaces.ISmartMeterRepository
import org.isc.utils.genericCrudl.services.RepositoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SmartMeterRepository @Autowired constructor(
    repository: ISmartMeterRepository
) : RepositoryService<SmartMeterEntity>(repository = repository)
