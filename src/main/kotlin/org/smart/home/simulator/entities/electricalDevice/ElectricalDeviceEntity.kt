package org.smart.home.simulator.entities.electricalDevice

import org.isc.utils.genericCrudl.models.IscEntity
import org.isc.utils.utils.Ids
import org.smart.home.simulator.entities.smartHome.SmartHomeEntity
import javax.persistence.*

/**
 * Electrical devices (e.g. computer, television or fridge).
 */
@Entity
@Table(name = "electrical_device")
class ElectricalDeviceEntity : IscEntity() {

    @Id
    @Column
    override var id: String = Ids.getRandomId()

    @Column
    override var organisationId: String = String()

    @Column
    override var timestampCreated: Long = System.currentTimeMillis()

    @Column
    override var timestampLastModified: Long = 0

    /**
     * Assigned smart home.
     */
    @ManyToOne(cascade = [CascadeType.MERGE])
    @JoinColumn(name = "smart_home_id")
    lateinit var smartHome: SmartHomeEntity

    /**
     * Device name.
     */
    @Column
    var name: String = String()

    /**
     * Current power consumption in kWh.
     */
    @Column
    var currentPowerConsumption: Double = 0.0

    /**
     * Max power consumption in kWh.
     */
    @Column
    var maxPowerConsumption: Double = 0.0

    /**
     * Power status.
     */
    @Column
    var enabled: Boolean = false

    /**
     * Device type.
     */
    @Enumerated(value = EnumType.STRING)
    var type: ElectricalDevice = ElectricalDevice.Other
}
