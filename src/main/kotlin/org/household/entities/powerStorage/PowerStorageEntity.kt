package org.household.entities.powerStorage

import org.household.entities.smartHome.SmartHomeEntity
import org.isc.utils.genericCrudl.models.IscEntity
import org.isc.utils.utils.Ids
import javax.persistence.*

/**
 *
 */
@Entity
@Table(name = "power_storage")
class PowerStorageEntity : IscEntity() {

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
    @ManyToOne(cascade = [CascadeType.MERGE])
    @JoinColumn(name = "smart_home_id")
    lateinit var smartHome: SmartHomeEntity

    /**
     *
     */
    @Column
    var name: String = String()

    /**
     *
     */
    @Column
    var currentChargingRate: Double = 0.0

    /**
     *
     */
    @Column
    var maxChargingRate: Double = 0.0

    /**
     *
     */
    @Column
    var maxPower: Double = 0.0

    /**
     *
     */
    @Column
    var currentPower: Double = 0.0

    /**
     *
     */
    @Column
    var enabled: Boolean = false
}
