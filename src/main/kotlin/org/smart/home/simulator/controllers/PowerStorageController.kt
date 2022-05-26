package org.smart.home.simulator.controllers

import org.isc.utils.genericCrudl.controller.CrossOriginData
import org.isc.utils.genericCrudl.controller.GenericController
import org.smart.home.simulator.dto.PowerStorageModel
import org.smart.home.simulator.entities.powerStorage.PowerStorageEntity
import org.smart.home.simulator.entities.powerStorage.PowerStorageFilterService
import org.smart.home.simulator.entities.powerStorage.PowerStorageModelService
import org.smart.home.simulator.entities.powerStorage.PowerStorageService
import org.smart.home.simulator.services.authentication.interfaces.IAuthenticationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

/**
 * REST controller to manage power storages.
 */
@Controller
@RequestMapping(path = ["power-storage"])
@CrossOrigin(origins = [CrossOriginData.origins], allowedHeaders = [CrossOriginData.allowedHeaders])
class PowerStorageController @Autowired constructor(
    entityService: PowerStorageService,
    filterService: PowerStorageFilterService,
    private val modelService: PowerStorageModelService,
    private val userAuthenticationService: IAuthenticationService
) : GenericController<PowerStorageModel, PowerStorageEntity>(
    userAuthenticationService = userAuthenticationService,
    entityService = entityService,
    filterService = filterService,
    modelService = modelService,
    rolesSave = emptyList(),
    rolesRead = emptyList()
) {

    /**
     * Returns all power storages with the given smart home ID.
     *
     * @param smartHomeId Request parameter.
     * @param page Page size. Request parameter.
     * @return List of named model.
     */
    @GetMapping("/findAllBySmartHomeId")
    fun findAllBySmartHomeId(@RequestParam smartHomeId: String, @RequestParam page: Int): ResponseEntity<*> =
        exceptionHandler.executeGetOperation {
            val currentUser = userAuthenticationService.isPermitted()
            modelService.findAllBySmartHomeId(smartHomeId = smartHomeId, page = page, currentUser = currentUser)
        }
}
