package org.household.entities.smartHome

import org.household.entities.electricalDevice.ElectricalDeviceEntity
import org.household.entities.powerCharger.PowerChargerEntity
import org.household.entities.powerStorage.PowerStorageEntity
import org.household.entities.powerUnit.PowerUnitEntity
import org.household.entities.smartMeter.SmartMeterEntity
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

    /**
     *
     */
    @Column
    var name: String = String()

    /**
     *
     */
    @OneToMany(cascade = [CascadeType.MERGE], mappedBy = "smartHome")
    var electricalDevices: List<ElectricalDeviceEntity> = emptyList()

    /**
     *
     */
    @OneToMany(cascade = [CascadeType.MERGE], mappedBy = "smartHome")
    var powerChargers: List<PowerChargerEntity> = emptyList()

    /**
     *
     */
    @OneToMany(cascade = [CascadeType.MERGE], mappedBy = "smartHome")
    var powerStorages: List<PowerStorageEntity> = emptyList()

    /**
     *
     */
    @OneToMany(cascade = [CascadeType.MERGE], mappedBy = "smartHome")
    var powerUnits: List<PowerUnitEntity> = emptyList()

    /**
     *
     */
    @OneToOne(mappedBy = "smartHome")
    var smartMeter: SmartMeterEntity? = null

    /**
     *
     */
    public fun isUnitAttached(): Boolean = electricalDevices.isNotEmpty() ||
        powerChargers.isNotEmpty() ||
        powerStorages.isNotEmpty() ||
        powerUnits.isNotEmpty() ||
        smartMeter != null
}
