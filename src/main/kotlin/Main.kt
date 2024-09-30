package org.example

import org.w3c.dom.Element
import org.w3c.dom.Node
import org.w3c.dom.NodeList
import java.nio.file.Path
import javax.xml.parsers.DocumentBuilderFactory

fun main() {
    // Lectura de fichero XML

    // El objetivo es parsear un fichero XML a árbol DOM

    // Lo primero sería instanciar un objeto DocumentBuilderFactory
    val dbf = DocumentBuilderFactory.newInstance()

    // Con el dbf, podemos crear un objeto de tipo DocumentBuilder
    val db = dbf.newDocumentBuilder()

    // Cuando tenemos el db, ya podemos "parsear"
    val ficheroXML = Path.of("src").resolve("main/resources/productos.xml")

    // Ahora sí, "parseamos"
    val document = db.parse(ficheroXML.toFile())

    // Dentro de la clase Document, tenemos más métodos importantes:
    // 1. Para obtener el elemento root
    val root: Element = document.documentElement

    // 2. para "normalizar" el árbol (borra sobrantes, etc.)
    root.normalize()

    // 3. para obtener elementos por el nombre de la etiqueta
    val listaNodos: NodeList = root.getElementsByTagName("producto")

    // Cuando tenemos la NodeList, podemos iterar sobre ella
    for(i in 0..listaNodos.length){

        // Para acceder a un item en particular, accedemos a través del idex
        val nodo = listaNodos.item(i)

        // Para acceder al tipo del nodo, usamos .nodeType
         if (nodo.nodeType == Node.ELEMENT_NODE){

             // "Casteamos" a Element
             val nodoElemento = nodo as Element

             // Podemos buscar los elementos que nos convienen
             val elementoNombre = nodoElemento.getElementsByTagName("nombre")

             val elementoPrecio = nodoElemento.getElementsByTagName("precio")

             // Una vez tenemos el elemento que queremos podemos acceder a su contenido
             val textContentNombre = elementoNombre.item(0).textContent

             val textContentPrecio = elementoPrecio.item(0).textContent

             // imprimimos:
             println("Producto: ${i}:\n\t - nombre: ${textContentNombre} - precio: ${i}:\n\t ${textContentPrecio}.")

         }
    }
}