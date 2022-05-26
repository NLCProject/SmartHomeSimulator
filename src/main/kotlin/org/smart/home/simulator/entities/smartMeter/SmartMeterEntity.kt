package org.smart.home.simulator.entities.smartMeter

import org.isc.utils.genericCrudl.models.IscEntity
import org.isc.utils.utils.Ids
import org.smart.home.simulator.entities.smartHome.SmartHomeEntity
import javax.persistence.*

/**
 * Smart meter.
 */
@Entity
@Table(name = "smart_meter")
class SmartMeterEntity : IscEntity() {

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
     * Smart meter name.
     */
    @Column
    var name: String = String()

    /**
     * Power exported in kWh.
     */
    @Column
    var powerExported: Double = 0.0

    /**
     * Power imported in kWh.
     */
    @Column
    var powerImported: Double = 0.0

    /**
     * Current power flow rate in kWh.
     */
    @Column
    var currentFlowRate: Double = 0.0

    /**
     * Maximum power flow rate in kWh.
     */
    @Column
    var maxFlowRate: Double = 0.0

    /**
     * Power flow direction.
     */
    @Column
    var flowDirection: FlowDirection = FlowDirection.Export

    /**
     * Assigned smart home.
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "smart_home_id")
    lateinit var smartHome: SmartHomeEntity
}
