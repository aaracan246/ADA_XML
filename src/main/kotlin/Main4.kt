import org.example.GestorFich
import org.w3c.dom.DOMImplementation
import org.w3c.dom.Document
import java.io.File
import javax.xml.parsers.DocumentBuilder
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.transform.stream.StreamResult
import kotlin.io.path.Path

fun main() {

    val gestorFichEjIVA = GestorFichEjIVA()
    val ficheroProducto = Path("C:\\Users\\UsuarioT\\PROG\\ADA\\TeoriaLecturaXML\\src\\main\\resources\\productosWrite.xml")

    gestorFichEjIVA

    val factory: DocumentBuilderFactory = DocumentBuilderFactory.newInstance()

    val builder: DocumentBuilder = factory.newDocumentBuilder()

    val imp: DOMImplementation = builder.domImplementation

    val document: Document = imp.createDocument(null, "productos", null)

    val producto1 = document.createElement("producto")
    document.documentElement.appendChild(producto1)

    val producto2 = document.createElement("producto")
    document.documentElement.appendChild(producto2)



    val result: StreamResult = StreamResult(java.nio.file.Path.of("src/main/resources/productosWrite2.xml").toFile())
}