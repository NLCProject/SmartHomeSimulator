package org.smart.home.simulator.controllers

import org.smart.home.simulator.dto.SmartHomeModel
import org.smart.home.simulator.entities.smartHome.SmartHomeEntity
import org.smart.home.simulator.entities.smartHome.SmartHomeFilterService
import org.smart.home.simulator.entities.smartHome.SmartHomeModelService
import org.smart.home.simulator.entities.smartHome.SmartHomeService
import org.smart.home.simulator.services.authentication.interfaces.IAuthenticationService
import org.isc.utils.genericCrudl.controller.CrossOriginData
import org.isc.utils.genericCrudl.controller.GenericController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

/**
 *
 */
@Controller
@RequestMapping(path = ["smart-home"])
@CrossOrigin(origins = [CrossOriginData.origins], allowedHeaders = [CrossOriginData.allowedHeaders])
class SmartHomeController @Autowired constructor(
    entityService: SmartHomeService,
    modelService: SmartHomeModelService,
    filterService: SmartHomeFilterService,
    userAuthenticationService: IAuthenticationService
) : GenericController<SmartHomeModel, SmartHomeEntity>(
    userAuthenticationService = userAuthenticationService,
    entityService = entityService,
    filterService = filterService,
    modelService = modelService,
    rolesSave = emptyList(),
    rolesRead = emptyList()
)
