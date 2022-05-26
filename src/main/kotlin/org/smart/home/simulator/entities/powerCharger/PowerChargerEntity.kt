package org.smart.home.simulator.entities.powerCharger

import org.isc.utils.genericCrudl.models.IscEntity
import org.isc.utils.utils.Ids
import org.smart.home.simulator.entities.smartHome.SmartHomeEntity
import javax.persistence.*

/**
 * Power Charger
 */
@Entity
@Table(name = "power_charger")
class PowerChargerEntity : IscEntity() {

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
     * Charger name.
     */
    @Column
    var name: String = String()

    /**
     * Current charging rate in kWh.
     */
    @Column
    var currentChargingRate: Double = 0.0

    /**
     * Max charging rate in kWh.
     */
    @Column
    var maxChargingRate: Double = 0.0

    /**
     * Power status.
     */
    @Column
    var enabled: Boolean = false
}
