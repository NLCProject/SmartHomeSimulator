package org.household.controllers

import org.household.dto.PowerUnitModel
import org.household.entities.powerUnit.PowerUnitEntity
import org.household.entities.powerUnit.PowerUnitFilterService
import org.household.entities.powerUnit.PowerUnitModelService
import org.household.entities.powerUnit.PowerUnitService
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
@RequestMapping(path = ["power-unit"])
@CrossOrigin(origins = [CrossOriginData.origins], allowedHeaders = [CrossOriginData.allowedHeaders])
class PowerUnitController @Autowired constructor(
    entityService: PowerUnitService,
    modelService: PowerUnitModelService,
    filterService: PowerUnitFilterService,
    userAuthenticationService: IAuthenticationService
) : GenericController<PowerUnitModel, PowerUnitEntity>(
    userAuthenticationService = userAuthenticationService,
    entityService = entityService,
    filterService = filterService,
    modelService = modelService,
    rolesSave = emptyList(),
    rolesRead = emptyList()
)
