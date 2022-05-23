package org.household.controllers

import org.household.dto.SmartMeterModel
import org.household.entities.smartMeter.SmartMeterEntity
import org.household.entities.smartMeter.SmartMeterFilterService
import org.household.entities.smartMeter.SmartMeterModelService
import org.household.entities.smartMeter.SmartMeterService
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
@RequestMapping(path = ["smart-meter"])
@CrossOrigin(origins = [CrossOriginData.origins], allowedHeaders = [CrossOriginData.allowedHeaders])
class SmartMeterController @Autowired constructor(
    entityService: SmartMeterService,
    modelService: SmartMeterModelService,
    filterService: SmartMeterFilterService,
    userAuthenticationService: IAuthenticationService
) : GenericController<SmartMeterModel, SmartMeterEntity>(
    userAuthenticationService = userAuthenticationService,
    entityService = entityService,
    filterService = filterService,
    modelService = modelService,
    rolesSave = emptyList(),
    rolesRead = emptyList()
)
