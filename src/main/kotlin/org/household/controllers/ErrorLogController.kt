package org.household.controllers

import org.household.dto.ErrorLogModel
import org.household.entities.errorLog.ErrorLogEntity
import org.household.entities.errorLog.ErrorLogFilterService
import org.household.entities.errorLog.ErrorLogModelService
import org.household.entities.errorLog.ErrorLogService
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
