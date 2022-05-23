package org.household.entities.smartHome

import org.household.dto.SmartHomeModel
import org.isc.utils.genericCrudl.services.ModelService
import org.isc.utils.models.CurrentUser
import org.isc.utils.models.NamedModel
import org.isc.utils.models.filter.FilterParameters
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

    override fun createModel(entity: SmartHomeEntity, model: SmartHomeModel, currentUser: CurrentUser) { }

    override fun createAbstractModel(entity: SmartHomeEntity, model: NamedModel, currentUser: CurrentUser) { }

    override fun findAllPageable(filter: FilterParameters, page: Int, currentUser: CurrentUser): List<NamedModel> =
        throw NotImplementedError()

    override fun sortByDescending(elements: List<NamedModel>): List<NamedModel> = elements
}
