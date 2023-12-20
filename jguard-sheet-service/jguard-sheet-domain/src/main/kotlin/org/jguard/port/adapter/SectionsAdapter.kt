package org.jguard.port.adapter

import jakarta.xml.bind.annotation.adapters.XmlAdapter
import org.jguard.port.model.Section
import org.jguard.port.model.Sections

class SectionsAdapter : XmlAdapter<Sections, Map<String, Section>>() {
    override fun unmarshal(sections: Sections): Map<String, Section> = sections.sections.associateBy { it.key }
    override fun marshal(sectionsMap: Map<String, Section>): Sections? = null
}