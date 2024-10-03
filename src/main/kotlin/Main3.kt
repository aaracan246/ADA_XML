import org.w3c.dom.DOMImplementation
import org.w3c.dom.Document
import org.w3c.dom.Element
import org.w3c.dom.Text
import javax.xml.parsers.DocumentBuilder
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.transform.Source
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult
import java.nio.file.Path
import javax.xml.transform.OutputKeys
import javax.xml.transform.Transformer
import javax.xml.transform.TransformerFactory


fun main(){


    val factory: DocumentBuilderFactory = DocumentBuilderFactory.newInstance()

    val builder: DocumentBuilder = factory.newDocumentBuilder()

    val imp: DOMImplementation = builder.domImplementation

    // Esto pilla el nodo "padre" (namespaceURI, qualifiedName, doctype)
    val document: Document = imp.createDocument(null, "productos", null)

    // Ahora toca pillar los "hijos"
    val producto1: Element = document.createElement("producto")
    document.documentElement.appendChild(producto1)

    val nombreP1: Element = document.createElement("nombre")
    val precioP1: Element = document.createElement("precio")

    val textoNombreP1: Text = document.createTextNode("Agua")
    val textoPrecioP1: Text = document.createTextNode("1.50")

    nombreP1.appendChild(textoNombreP1)
    precioP1.appendChild(textoPrecioP1)

    producto1.appendChild(nombreP1)
    producto1.appendChild(precioP1)


    val producto2: Element = document.createElement("producto")
    document.documentElement.appendChild(producto2)

    val nombreP2: Element = document.createElement("nombre")
    val precioP2: Element = document.createElement("precio")

    val textoNombreP2: Text = document.createTextNode("CocaCola")
    val textoPrecioP2: Text = document.createTextNode("1.75")

    nombreP2.appendChild(textoNombreP2)
    precioP2.appendChild(textoPrecioP2)

    producto2.appendChild(nombreP2)
    producto2.appendChild(precioP2)



    val source1: Source = DOMSource(document)

    val result: StreamResult = StreamResult(Path.of("src/main/resources/productosWrite.xml").toFile())

    val transformer: Transformer = TransformerFactory.newInstance().newTransformer()

    transformer.setOutputProperty(OutputKeys.INDENT, "yes")
    transformer.transform(source1, result)
}