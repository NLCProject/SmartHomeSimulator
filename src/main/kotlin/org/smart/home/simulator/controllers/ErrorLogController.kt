package org.smart.home.simulator.controllers

import org.smart.home.simulator.dto.ErrorLogModel
import org.smart.home.simulator.entities.errorLog.ErrorLogEntity
import org.smart.home.simulator.entities.errorLog.ErrorLogFilterService
import org.smart.home.simulator.entities.errorLog.ErrorLogModelService
import org.smart.home.simulator.entities.errorLog.ErrorLogService
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
@RequestMapping(path = ["error-log"])
@CrossOrigin(origins = [CrossOriginData.origins], allowedHeaders = [CrossOriginData.allowedHeaders])
class ErrorLogController @Autowired constructor(
    modelService: ErrorLogModelService,
    filterService: ErrorLogFilterService,
    entityService: ErrorLogService,
    userAuthenticationService: IAuthenticationService
) : GenericController<ErrorLogModel, ErrorLogEntity>(
    userAuthenticationService = userAuthenticationService,
    entityService = entityService,
    filterService = filterService,
    modelService = modelService,
    rolesSave = emptyList(),
    rolesRead = emptyList(),
    lockSave = true
)
