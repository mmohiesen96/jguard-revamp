package org.jguard.port.model

import java.io.Serializable
import jakarta.xml.bind.annotation.XmlAccessType
import jakarta.xml.bind.annotation.XmlAccessorType
import jakarta.xml.bind.annotation.XmlElement

@XmlAccessorType(XmlAccessType.FIELD)
data class Questions(
    @XmlElement(name = "question") var questions: List<Question>
) : Serializable
