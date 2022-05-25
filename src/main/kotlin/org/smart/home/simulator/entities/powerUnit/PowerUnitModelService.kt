package org.smart.home.simulator.entities.powerUnit

import org.smart.home.simulator.dto.PowerUnitModel
import org.isc.utils.genericCrudl.services.ModelService
import org.isc.utils.models.CurrentUser
import org.isc.utils.models.NamedModel
import org.isc.utils.models.filter.FilterParameters
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PowerUnitModelService @Autowired constructor(
    filterService: PowerUnitFilterService,
    private val repositoryService: PowerUnitRepository
) : ModelService<PowerUnitModel, PowerUnitEntity>(
    repositoryService = repositoryService,
    filterService = filterService,
    modelClass = PowerUnitModel::class.java,
    abstractClass = NamedModel::class.java
) {

    /**
     *
     */
    fun findAllBySmartHomeId(smartHomeId: String, page: Int, currentUser: CurrentUser): List<NamedModel> =
        repositoryService
            .findAllBySmartHomeId(smartHomeId = smartHomeId, page = page, currentUser = currentUser)
            .map { convertToAbstractModel(entity = it, currentUser = currentUser) }

    override fun createModel(entity: PowerUnitEntity, model: PowerUnitModel, currentUser: CurrentUser) { }

    override fun createAbstractModel(entity: PowerUnitEntity, model: NamedModel, currentUser: CurrentUser) {
        model.firstLine.text = entity.name
        model.secondLine.text = entity.type.name
        model.secondLine.translate = true
    }

    override fun findAllPageable(filter: FilterParameters, page: Int, currentUser: CurrentUser): List<NamedModel> =
        throw NotImplementedError()

    override fun sortByDescending(elements: List<NamedModel>): List<NamedModel> = elements
}
