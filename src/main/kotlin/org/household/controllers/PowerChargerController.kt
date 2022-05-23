package org.household.controllers

import org.household.dto.PowerChargerModel
import org.household.entities.powerCharger.PowerChargerEntity
import org.household.entities.powerCharger.PowerChargerFilterService
import org.household.entities.powerCharger.PowerChargerModelService
import org.household.entities.powerCharger.PowerChargerService
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
@RequestMapping(path = ["power-charger"])
@CrossOrigin(origins = [CrossOriginData.origins], allowedHeaders = [CrossOriginData.allowedHeaders])
class PowerChargerController @Autowired constructor(
    entityService: PowerChargerService,
    modelService: PowerChargerModelService,
    filterService: PowerChargerFilterService,
    userAuthenticationService: IAuthenticationService
) : GenericController<PowerChargerModel, PowerChargerEntity>(
    userAuthenticationService = userAuthenticationService,
    entityService = entityService,
    filterService = filterService,
    modelService = modelService,
    rolesSave = emptyList(),
    rolesRead = emptyList()
)
