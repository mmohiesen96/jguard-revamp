import jakarta.xml.bind.JAXBContext
import org.jguard.port.function.SheetFunction
import org.jguard.port.model.Sheet
import org.springframework.core.io.ResourceLoader

class SheetProcessor(private val resourceLoader: ResourceLoader) : SheetFunction {

    override fun parseSheet(lang: String): Sheet = JAXBContext
        .newInstance(Sheet::class.java)
        .createUnmarshaller()
        .unmarshal(resourceLoader.getResource("classpath:sheets/$lang-sheet.xml").inputStream) as Sheet
}