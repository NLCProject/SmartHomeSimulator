package org.smart.home.simulator.services.migration.data

/**
 *
 */
object SmartHomes {

    val data = listOf(
        SmartHome(name = "Smart Home #1", id = "83ab1a38-ea46-40b2-8a63-ee61ed57355a"),
        SmartHome(name = "Smart Home #2", id = "ebe3c27b-364b-45d0-af41-46f411251f99"),
        SmartHome(name = "Smart Home #3", id = "2823dad2-f921-477a-9657-8f39ca25c9b6"),
        SmartHome(name = "Smart Home #4", id = "85a3988c-6743-4c4b-a913-9fa97c47c62d"),
        SmartHome(name = "Smart Home #5", id = "a78536db-9964-467f-98ac-d60cc55faa5a")
    )

    public class SmartHome(val name: String, val id: String)
}