package org.household.entities.errorLog

import org.isc.utils.enums.FilterKey
import org.isc.utils.enums.I18nKey
import org.isc.utils.genericCrudl.services.FilterService
import org.isc.utils.models.CurrentUser
import org.isc.utils.models.filter.*
import org.springframework.stereotype.Service

@Service
class ErrorLogFilterService : FilterService<ErrorLogEntity>() {

    override fun createSearchHintModel(filter: FilterParameters, currentUser: CurrentUser): List<SearchHintModel> =
        emptyList()

    override fun getFilterModels(currentUser: CurrentUser): FilterOptions {
        val filterOption = FilterOption(
            i18nKey = I18nKey.FilterKey,
            className = FilterKey::class.java.simpleName,
            keys = listOf(KeyOption(key = FilterKey.Highlighted, preSelected = false))
        )

        return FilterOptions(options = listOf(filterOption))
    }
}
