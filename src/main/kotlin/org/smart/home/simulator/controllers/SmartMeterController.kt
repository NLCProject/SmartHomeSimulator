package org.smart.home.simulator.controllers

import org.isc.utils.genericCrudl.controller.CrossOriginData
import org.isc.utils.genericCrudl.controller.GenericController
import org.smart.home.simulator.dto.SmartMeterModel
import org.smart.home.simulator.entities.smartMeter.SmartMeterEntity
import org.smart.home.simulator.entities.smartMeter.SmartMeterFilterService
import org.smart.home.simulator.entities.smartMeter.SmartMeterModelService
import org.smart.home.simulator.entities.smartMeter.SmartMeterService
import org.smart.home.simulator.services.authentication.interfaces.IAuthenticationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
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
    filterService: SmartMeterFilterService,
    private val modelService: SmartMeterModelService,
    private val userAuthenticationService: IAuthenticationService
) : GenericController<SmartMeterModel, SmartMeterEntity>(
    userAuthenticationService = userAuthenticationService,
    entityService = entityService,
    filterService = filterService,
    modelService = modelService,
    rolesSave = emptyList(),
    rolesRead = emptyList()
) {

    /**
     *
     */
    @GetMapping("/findBySmartHomeId")
    fun findBySmartHomeId(@RequestParam smartHomeId: String): ResponseEntity<*> =
        exceptionHandler.executeGetOperation {
            val currentUser = userAuthenticationService.isPermitted()
            modelService.findBySmartHomeId(smartHomeId = smartHomeId, currentUser = currentUser)
        }
}
