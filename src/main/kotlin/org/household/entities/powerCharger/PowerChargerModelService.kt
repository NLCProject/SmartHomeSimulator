package org.household.entities.powerCharger

import org.household.dto.PowerChargerModel
import org.isc.utils.genericCrudl.services.ModelService
import org.isc.utils.models.CurrentUser
import org.isc.utils.models.NamedModel
import org.isc.utils.models.filter.FilterParameters
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PowerChargerModelService @Autowired constructor(
    filterService: PowerChargerFilterService,
    private val repositoryService: PowerChargerRepository
) : ModelService<PowerChargerModel, PowerChargerEntity>(
    repositoryService = repositoryService,
    filterService = filterService,
    modelClass = PowerChargerModel::class.java,
    abstractClass = NamedModel::class.java
) {

    /**
     *
     */
    fun findAllBySmartHomeId(smartHomeId: String, page: Int, currentUser: CurrentUser): List<NamedModel> =
        repositoryService
            .findAllBySmartHomeId(smartHomeId = smartHomeId, page = page, currentUser = currentUser)
            .map { convertToAbstractModel(entity = it, currentUser = currentUser) }

    override fun createModel(entity: PowerChargerEntity, model: PowerChargerModel, currentUser: CurrentUser) { }

    override fun createAbstractModel(entity: PowerChargerEntity, model: NamedModel, currentUser: CurrentUser) {
        model.firstLine.text = entity.name
    }

    override fun findAllPageable(filter: FilterParameters, page: Int, currentUser: CurrentUser): List<NamedModel> =
        throw NotImplementedError()

    override fun sortByDescending(elements: List<NamedModel>): List<NamedModel> = elements
}
