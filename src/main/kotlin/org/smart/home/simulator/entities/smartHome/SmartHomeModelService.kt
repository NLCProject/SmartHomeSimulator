package org.smart.home.simulator.entities.smartHome

import org.isc.utils.genericCrudl.services.ModelService
import org.isc.utils.models.CurrentUser
import org.isc.utils.models.NamedModel
import org.isc.utils.models.filter.FilterParameters
import org.smart.home.simulator.dto.SmartHomeModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SmartHomeModelService @Autowired constructor(
    repositoryService: SmartHomeRepository,
    filterService: SmartHomeFilterService
) : ModelService<SmartHomeModel, SmartHomeEntity>(
    repositoryService = repositoryService,
    filterService = filterService,
    modelClass = SmartHomeModel::class.java,
    abstractClass = NamedModel::class.java
) {

    override fun createModel(entity: SmartHomeEntity, model: SmartHomeModel, currentUser: CurrentUser) {
        model.canBeDeleted = !entity.isUnitAttached()
    }

    override fun createAbstractModel(entity: SmartHomeEntity, model: NamedModel, currentUser: CurrentUser) {
        model.firstLine.text = entity.name
    }

    override fun findAllPageable(filter: FilterParameters, page: Int, currentUser: CurrentUser): List<NamedModel> =
        throw NotImplementedError()

    override fun sortByDescending(elements: List<NamedModel>): List<NamedModel> = elements
}
