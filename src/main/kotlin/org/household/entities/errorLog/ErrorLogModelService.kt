package org.household.entities.errorLog

import org.household.dto.ErrorLogModel
import org.isc.utils.enums.FilterKey
import org.isc.utils.enums.IconEnum
import org.isc.utils.genericCrudl.services.ModelService
import org.isc.utils.models.CurrentUser
import org.isc.utils.models.NamedModel
import org.isc.utils.models.filter.FilterParameters
import org.isc.utils.utils.StringUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ErrorLogModelService @Autowired constructor(
    filterService: ErrorLogFilterService,
    private val repositoryService: ErrorLogRepository
) : ModelService<ErrorLogModel, ErrorLogEntity>(
    repositoryService = repositoryService,
    filterService = filterService,
    modelClass = ErrorLogModel::class.java,
    abstractClass = NamedModel::class.java
) {

    override fun findAllPageable(filter: FilterParameters, page: Int, currentUser: CurrentUser): List<NamedModel> =
        when {
            filter.hasFilterKey(key = FilterKey.Highlighted) -> repositoryService.findByHighlighted(
                highlighted = true,
                page = page,
                currentUser = currentUser
            )

            else -> repositoryService.findAllPageable(page = page, currentUser = currentUser)
        }
            .sortedByDescending { it.timestampCreated }
            .map { super.convertToAbstractModel(entity = it, currentUser = currentUser) }

    override fun createModel(
        entity: ErrorLogEntity,
        model: ErrorLogModel,
        currentUser: CurrentUser
    ) { }

    override fun createAbstractModel(entity: ErrorLogEntity, model: NamedModel, currentUser: CurrentUser) {
        model.firstLine.text = entity.message
        model.userId = entity.userId

        var organisation = entity.errorOrganisationName
        if (organisation.isEmpty())
            organisation = entity.errorOrganisationId

        model.secondLine.text = StringUtil.joinWithSeparatorWithSpace(
            separator = "|",
            entity.dateCreated,
            entity.time,
            organisation
        )

        if (entity.highlighted)
            model.addIcon(icon = IconEnum.CRITICAL)
    }

    override fun sortByDescending(elements: List<NamedModel>): List<NamedModel> =
        elements.sortedByDescending { it.timestampCreated }
}
