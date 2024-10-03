import org.w3c.dom.Element
import org.w3c.dom.Node
import java.nio.file.Path
import javax.xml.parsers.DocumentBuilderFactory
import kotlin.coroutines.CoroutineContext
import kotlin.io.path.exists


fun conversorIVA(listaProd: MutableList<Producto>): MutableList<Producto>{

    for (item in listaProd){

        val itemIVA = item.precio * 1.21

        item.precio = itemIVA
        listaProd.add(item)
    }

    return listaProd
}


class GestorFichEjIVA {

    fun lectorFich(ficheroXML: Path): MutableList<Producto>{

        val dbf: DocumentBuilderFactory = DocumentBuilderFactory.newInstance()

        val db = dbf.newDocumentBuilder()

        val document = db.parse(ficheroXML.toFile())

        val root: Element = document.documentElement

        root.normalize()

        val listaNodos = root.getElementsByTagName("producto")

        val listaProductos = mutableListOf<Producto>()

        for (i in 0 until listaNodos.length){

            val nodo = listaNodos.item(i)

            if (nodo.nodeType == Node.ELEMENT_NODE){
                val nodoElemento = nodo as Element

                val elementoNombre = nodoElemento.getElementsByTagName("nombre")
                val elementoPrecio = nodoElemento.getElementsByTagName("precio")

                val textContentNombre = elementoNombre.item(0).textContent
                val textContentPrecio = elementoPrecio.item(0).textContent.toDouble()

                val producto = Producto(textContentNombre, textContentPrecio)
                listaProductos.add(producto)
            }

        }
        println(listaProductos)
        return listaProductos
    }


}