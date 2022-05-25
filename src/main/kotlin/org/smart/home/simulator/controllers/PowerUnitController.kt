package org.smart.home.simulator.controllers

import org.isc.utils.genericCrudl.controller.CrossOriginData
import org.isc.utils.genericCrudl.controller.GenericController
import org.smart.home.simulator.dto.PowerUnitModel
import org.smart.home.simulator.entities.powerUnit.PowerUnitEntity
import org.smart.home.simulator.entities.powerUnit.PowerUnitFilterService
import org.smart.home.simulator.entities.powerUnit.PowerUnitModelService
import org.smart.home.simulator.entities.powerUnit.PowerUnitService
import org.smart.home.simulator.services.authentication.interfaces.IAuthenticationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
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
    filterService: PowerUnitFilterService,
    private val modelService: PowerUnitModelService,
    private val userAuthenticationService: IAuthenticationService
) : GenericController<PowerUnitModel, PowerUnitEntity>(
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
    @GetMapping("/findAllBySmartHomeId")
    fun findAllBySmartHomeId(@RequestParam smartHomeId: String, @RequestParam page: Int): ResponseEntity<*> =
        exceptionHandler.executeGetOperation {
            val currentUser = userAuthenticationService.isPermitted()
            modelService.findAllBySmartHomeId(smartHomeId = smartHomeId, page = page, currentUser = currentUser)
        }
}
