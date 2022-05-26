package org.smart.home.simulator.entities.powerUnit

import org.isc.utils.genericCrudl.models.IscEntity
import org.isc.utils.utils.Ids
import org.smart.home.simulator.entities.smartHome.SmartHomeEntity
import javax.persistence.*

/**
 * Power unit.
 */
@Entity
@Table(name = "power_unit")
class PowerUnitEntity : IscEntity() {

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
     * Unit name
     */
    @Column
    var name: String = String()

    /**
     * Maximum power generation in kWh.
     */
    @Column
    var maxPowerGeneration: Double = 0.0

    /**
     * Current power generation in kWh.
     */
    @Column
    var currentPowerGeneration: Double = 0.0

    /**
     * Power unit type.
     */
    @Enumerated(value = EnumType.STRING)
    var type: PowerUnit = PowerUnit.Other

    /**
     * Power status.
     */
    @Column
    var enabled: Boolean = false

    /**
     * Assigned smart home.
     */
    @ManyToOne(cascade = [CascadeType.MERGE])
    @JoinColumn(name = "smart_home_id")
    lateinit var smartHome: SmartHomeEntity
}
