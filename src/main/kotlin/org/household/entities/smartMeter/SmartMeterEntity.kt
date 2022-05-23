package org.household.entities.smartMeter

import org.household.entities.smartHome.SmartHomeEntity
import org.isc.utils.genericCrudl.models.IscEntity
import org.isc.utils.utils.Ids
import javax.persistence.*

/**
 *
 */
@Entity
@Table(name = "smart_meter")
class SmartMeterEntity : IscEntity() {

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
    var name: String = String()

    /**
     *
     */
    @Column
    var powerExported: Double = 0.0

    /**
     *
     */
    @Column
    var powerImported: Double = 0.0

    /**
     *
     */
    @Column
    var currentFlowRate: Double = 0.0

    /**
     *
     */
    @Column
    var maxFlowRate: Double = 0.0

    /**
     *
     */
    @Column
    var flowDirection: FlowDirection = FlowDirection.Export

    /**
     *
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "smart_home_id")
    lateinit var smartHome: SmartHomeEntity
}
