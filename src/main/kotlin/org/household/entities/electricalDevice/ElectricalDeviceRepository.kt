package org.household.entities.electricalDevice

import org.household.entities.electricalDevice.interfaces.IElectricalDeviceRepository
import org.isc.utils.genericCrudl.services.RepositoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ElectricalDeviceRepository @Autowired constructor(
    repository: IElectricalDeviceRepository
) : RepositoryService<ElectricalDeviceEntity>(repository = repository)
