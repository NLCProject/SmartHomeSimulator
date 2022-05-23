package org.household.entities.electricalDevice

import org.household.entities.smartHome.SmartHomeEntity
import org.isc.utils.genericCrudl.models.IscEntity
import org.isc.utils.utils.Ids
import javax.persistence.*

/**
 *
 */
@Entity
@Table(name = "electrical_device")
class ElectricalDeviceEntity : IscEntity() {

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
    var currentPowerConsumption: Double = 0.0

    /**
     *
     */
    @Column
    var maxPowerConsumption: Double = 0.0

    /**
     *
     */
    @Column
    var enabled: Boolean = false

    /**
     *
     */
    @Enumerated(value = EnumType.STRING)
    var type: ElectricalDevice = ElectricalDevice.Other
}
