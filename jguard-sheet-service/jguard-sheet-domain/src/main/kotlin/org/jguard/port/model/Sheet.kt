package org.jguard.port.model

import jakarta.xml.bind.annotation.XmlAccessType
import jakarta.xml.bind.annotation.XmlAccessorType
import jakarta.xml.bind.annotation.XmlElement
import jakarta.xml.bind.annotation.XmlRootElement
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter
import org.jguard.port.adapter.SectionsAdapter
import java.io.Serializable


@XmlRootElement(name = "sectionsDetails")
@XmlAccessorType(XmlAccessType.FIELD)
data class Sheet(

    @XmlJavaTypeAdapter(SectionsAdapter::class)
    @XmlElement(name = "sections")
    var sections: Map<String, Section>
) : Serializable {
    constructor() : this(mapOf<String, Section>().toMutableMap())
}
