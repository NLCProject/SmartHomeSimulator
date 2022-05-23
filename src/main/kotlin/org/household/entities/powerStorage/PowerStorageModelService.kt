package org.household.entities.powerStorage

import org.household.dto.PowerStorageModel
import org.isc.utils.genericCrudl.services.ModelService
import org.isc.utils.models.CurrentUser
import org.isc.utils.models.NamedModel
import org.isc.utils.models.filter.FilterParameters
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PowerStorageModelService @Autowired constructor(
    repositoryService: PowerStorageRepository,
    filterService: PowerStorageFilterService
) : ModelService<PowerStorageModel, PowerStorageEntity>(
    repositoryService = repositoryService,
    filterService = filterService,
    modelClass = PowerStorageModel::class.java,
    abstractClass = NamedModel::class.java
) {

    override fun createModel(entity: PowerStorageEntity, model: PowerStorageModel, currentUser: CurrentUser) { }

    override fun createAbstractModel(entity: PowerStorageEntity, model: NamedModel, currentUser: CurrentUser) { }

    override fun findAllPageable(filter: FilterParameters, page: Int, currentUser: CurrentUser): List<NamedModel> =
        throw NotImplementedError()

    override fun sortByDescending(elements: List<NamedModel>): List<NamedModel> = elements
}
