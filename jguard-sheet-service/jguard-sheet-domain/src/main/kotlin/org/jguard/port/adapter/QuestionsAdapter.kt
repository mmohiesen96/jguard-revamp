package org.jguard.port.adapter

import org.jguard.port.model.Question
import org.jguard.port.model.Questions
import jakarta.xml.bind.annotation.adapters.XmlAdapter

class QuestionsAdapter : XmlAdapter<Questions, Map<String, Question>>() {

    override fun unmarshal(questions: Questions): Map<String, Question> = questions.questions.associateBy { it.key }

    override fun marshal(stringQuestionMap: Map<String, Question>): Questions? = null

}