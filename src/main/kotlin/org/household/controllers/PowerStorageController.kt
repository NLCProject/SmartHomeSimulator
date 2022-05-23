package org.household.controllers

import org.household.dto.PowerStorageModel
import org.household.entities.powerStorage.PowerStorageEntity
import org.household.entities.powerStorage.PowerStorageFilterService
import org.household.entities.powerStorage.PowerStorageModelService
import org.household.entities.powerStorage.PowerStorageService
import org.household.services.authentication.interfaces.IAuthenticationService
import org.isc.utils.genericCrudl.controller.CrossOriginData
import org.isc.utils.genericCrudl.controller.GenericController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

/**
 *
 */
@Controller
@RequestMapping(path = ["power-storage"])
@CrossOrigin(origins = [CrossOriginData.origins], allowedHeaders = [CrossOriginData.allowedHeaders])
class PowerStorageController @Autowired constructor(
    entityService: PowerStorageService,
    modelService: PowerStorageModelService,
    filterService: PowerStorageFilterService,
    userAuthenticationService: IAuthenticationService
) : GenericController<PowerStorageModel, PowerStorageEntity>(
    userAuthenticationService = userAuthenticationService,
    entityService = entityService,
    filterService = filterService,
    modelService = modelService,
    rolesSave = emptyList(),
    rolesRead = emptyList()
)
