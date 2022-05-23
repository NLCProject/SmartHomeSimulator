package org.household.controllers

import org.household.dto.ElectricalDeviceModel
import org.household.entities.electricalDevice.ElectricalDeviceEntity
import org.household.entities.electricalDevice.ElectricalDeviceFilterService
import org.household.entities.electricalDevice.ElectricalDeviceModelService
import org.household.entities.electricalDevice.ElectricalDeviceService
import org.household.services.authentication.interfaces.IAuthenticationService
import org.isc.utils.genericCrudl.controller.CrossOriginData
import org.isc.utils.genericCrudl.controller.GenericController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

/**
 *
 */
@Controller
@RequestMapping(path = ["electrical-device"])
@CrossOrigin(origins = [CrossOriginData.origins], allowedHeaders = [CrossOriginData.allowedHeaders])
class ElectricalDeviceController @Autowired constructor(
    entityService: ElectricalDeviceService,
    filterService: ElectricalDeviceFilterService,
    private val modelService: ElectricalDeviceModelService,
    private val userAuthenticationService: IAuthenticationService
) : GenericController<ElectricalDeviceModel, ElectricalDeviceEntity>(
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
    fun findAllBySmartHomeId(@RequestParam smartHomeId: String): ResponseEntity<*> =
        exceptionHandler.executeGetOperation {
            val currentUser = userAuthenticationService.isPermitted()
            modelService.findAllBySmartHomeId(smartHomeId = smartHomeId, currentUser = currentUser)
        }
}
