package org.jguard.port.model

import java.io.Serializable
import jakarta.xml.bind.annotation.XmlAccessType
import jakarta.xml.bind.annotation.XmlAccessorType
import jakarta.xml.bind.annotation.XmlAttribute
import jakarta.xml.bind.annotation.XmlValue

@XmlAccessorType(XmlAccessType.FIELD)
data class Question(
    @XmlValue var body: String,
    @XmlAttribute(name = "key") var key: String
) : Serializable
