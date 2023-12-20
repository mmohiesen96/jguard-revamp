package org.jguard.port.model

import org.jguard.port.adapter.QuestionsAdapter
import java.io.Serializable
import jakarta.xml.bind.annotation.XmlAccessType
import jakarta.xml.bind.annotation.XmlAccessorType
import jakarta.xml.bind.annotation.XmlAttribute
import jakarta.xml.bind.annotation.XmlElement
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter

@XmlAccessorType(XmlAccessType.FIELD)
data class Section(
    @XmlAttribute(name = "key") var key: String,
    @XmlAttribute(name = "subSection") var subSection: Boolean,
    @XmlAttribute(name = "name") var name: String,
    @XmlJavaTypeAdapter(QuestionsAdapter::class)
    @XmlElement(name = "questions") var questions: Map<String, Question>
) : Serializable
