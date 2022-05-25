package org.smart.home.simulator.entities.smartMeter

import org.smart.home.simulator.dto.SmartMeterModel
import org.isc.utils.genericCrudl.services.ModelService
import org.isc.utils.models.CurrentUser
import org.isc.utils.models.NamedModel
import org.isc.utils.models.filter.FilterParameters
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SmartMeterModelService @Autowired constructor(
    filterService: SmartMeterFilterService,
    private val repositoryService: SmartMeterRepository
) : ModelService<SmartMeterModel, SmartMeterEntity>(
    repositoryService = repositoryService,
    filterService = filterService,
    modelClass = SmartMeterModel::class.java,
    abstractClass = NamedModel::class.java
) {

    /**
     *
     */
    fun findBySmartHomeId(smartHomeId: String, currentUser: CurrentUser): SmartMeterModel? {
        val optional = repositoryService.findBySmartHomeId(smartHomeId = smartHomeId, currentUser = currentUser)
        if (!optional.isPresent)
            return null

        return convertToModel(entity = optional.get(), currentUser = currentUser)
    }

    override fun createModel(entity: SmartMeterEntity, model: SmartMeterModel, currentUser: CurrentUser) { }

    override fun createAbstractModel(entity: SmartMeterEntity, model: NamedModel, currentUser: CurrentUser) {
        model.firstLine.text = entity.name
        model.secondLine.text = entity.flowDirection.name
        model.secondLine.translate = true
    }

    override fun findAllPageable(filter: FilterParameters, page: Int, currentUser: CurrentUser): List<NamedModel> =
        throw NotImplementedError()

    override fun sortByDescending(elements: List<NamedModel>): List<NamedModel> = elements
}
