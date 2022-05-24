package org.household.entities.electricalDevice

import org.household.dto.ElectricalDeviceModel
import org.isc.utils.genericCrudl.services.ModelService
import org.isc.utils.models.CurrentUser
import org.isc.utils.models.NamedModel
import org.isc.utils.models.filter.FilterParameters
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ElectricalDeviceModelService @Autowired constructor(
    filterService: ElectricalDeviceFilterService,
    private val repositoryService: ElectricalDeviceRepository
) : ModelService<ElectricalDeviceModel, ElectricalDeviceEntity>(
    repositoryService = repositoryService,
    filterService = filterService,
    modelClass = ElectricalDeviceModel::class.java,
    abstractClass = NamedModel::class.java
) {

    /**
     *
     */
    fun findAllBySmartHomeId(smartHomeId: String, page: Int, currentUser: CurrentUser): List<NamedModel> =
        repositoryService
            .findAllBySmartHomeId(smartHomeId = smartHomeId, page = page, currentUser = currentUser)
            .map { convertToAbstractModel(entity = it, currentUser = currentUser) }

    override fun createModel(entity: ElectricalDeviceEntity, model: ElectricalDeviceModel, currentUser: CurrentUser) { }

    override fun createAbstractModel(entity: ElectricalDeviceEntity, model: NamedModel, currentUser: CurrentUser) {
        model.firstLine.text = entity.name
        model.secondLine.text = entity.type.name
        model.secondLine.translate = true
    }

    override fun findAllPageable(filter: FilterParameters, page: Int, currentUser: CurrentUser): List<NamedModel> =
        throw NotImplementedError()

    override fun sortByDescending(elements: List<NamedModel>): List<NamedModel> = elements
}
