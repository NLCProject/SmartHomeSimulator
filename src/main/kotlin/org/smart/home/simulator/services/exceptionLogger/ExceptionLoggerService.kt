package org.smart.home.simulator.services.exceptionLogger

import org.isc.utils.enums.SportsclubExceptionI18nKey
import org.isc.utils.genericCrudl.services.exceptionHandler.AbstractExceptionLogger
import org.isc.utils.tests.CurrentUserFactory
import org.isc.utils.utils.Ids
import org.slf4j.LoggerFactory
import org.smart.home.simulator.dto.ErrorLogModel
import org.smart.home.simulator.entities.errorLog.ErrorLogService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ExceptionLoggerService @Autowired constructor(
    private val errorLogService: ErrorLogService
) : AbstractExceptionLogger() {

    private val logger = LoggerFactory.getLogger(this::class.java)
    private val system = "SYSTEM"

    override fun saveErrorLog(
        userId: String,
        organisationId: String,
        organisationName: String,
        className: String,
        i18nKey: SportsclubExceptionI18nKey,
        stackTrace: String,
        message: String?
    ) {
        try {
            val systemMessage = userId == Ids.getEmptyUUID()
            val model = ErrorLogModel()
            model.i18nKey = i18nKey.name
            model.stacktrace = stackTrace
            model.className = className
            model.userId = if (systemMessage) system else userId
            model.errorOrganisationId = if (systemMessage) system else organisationId
            model.errorOrganisationName = if (systemMessage) system else organisationName

            if (message == null || message.isEmpty()) {
                model.message = "No message"
            } else {
                model.message = message
            }

            val currentUser = CurrentUserFactory.getCurrentUser(organisationId = Ids.getEmptyUUID())
            errorLogService.saveEntity(model = model, currentUser = currentUser)
        } catch (ex: Exception) {
            logger.error("Error while saving error log: ${ex.message}")
            logger.error(ex.message)
        }
    }
}
