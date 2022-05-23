package org.household.entities.powerUnit

import org.household.dto.PowerUnitModel
import org.isc.utils.genericCrudl.services.ModelService
import org.isc.utils.models.CurrentUser
import org.isc.utils.models.NamedModel
import org.isc.utils.models.filter.FilterParameters
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PowerUnitModelService @Autowired constructor(
    repositoryService: PowerUnitRepository,
    filterService: PowerUnitFilterService
) : ModelService<PowerUnitModel, PowerUnitEntity>(
    repositoryService = repositoryService,
    filterService = filterService,
    modelClass = PowerUnitModel::class.java,
    abstractClass = NamedModel::class.java
) {

    override fun createModel(entity: PowerUnitEntity, model: PowerUnitModel, currentUser: CurrentUser) { }

    override fun createAbstractModel(entity: PowerUnitEntity, model: NamedModel, currentUser: CurrentUser) { }

    override fun findAllPageable(filter: FilterParameters, page: Int, currentUser: CurrentUser): List<NamedModel> =
        throw NotImplementedError()

    override fun sortByDescending(elements: List<NamedModel>): List<NamedModel> = elements
}
