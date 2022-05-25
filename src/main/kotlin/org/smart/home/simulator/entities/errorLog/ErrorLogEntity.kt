package org.smart.home.simulator.entities.errorLog

import org.isc.utils.genericCrudl.models.IscEntity
import org.isc.utils.utils.Ids
import javax.persistence.*

/**
 *
 */
@Entity
@Table(name = "error_log")
class ErrorLogEntity : IscEntity() {

    /**
     *
     */
    @Id
    @Column
    override var id: String = Ids.getRandomId()

    /**
     *
     */
    @Column
    override var organisationId: String = String()

    /**
     *
     */
    @Column
    override var timestampCreated: Long = System.currentTimeMillis()

    /**
     *
     */
    @Column
    override var timestampLastModified: Long = 0

    /**
     *
     */
    @Column
    var className: String = String()

    /**
     *
     */
    @Column
    var errorOrganisationId: String = String()

    /**
     *
     */
    @Column
    var errorOrganisationName: String = String()

    /**
     *
     */
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    var message: String = String()

    /**
     *
     */
    @Column
    var i18nKey: String = String()

    /**
     *
     */
    @Column
    var userId: String = String()

    /**
     *
     */
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    var stacktrace: String = String()

    /**
     *
     */
    @Column
    var dateCreated: String = String()

    /**
     *
     */
    @Column
    var time: String = String()

    /**
     *
     */
    @Column
    var highlighted: Boolean = false
}
