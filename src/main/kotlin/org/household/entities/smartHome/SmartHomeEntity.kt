package org.household.entities.smartHome

import org.isc.utils.genericCrudl.models.IscEntity
import org.isc.utils.utils.Ids
import javax.persistence.*

/**
 *
 */
@Entity
@Table(name = "smart_home")
class SmartHomeEntity : IscEntity() {

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
}
