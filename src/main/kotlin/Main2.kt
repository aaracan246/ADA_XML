package org.example

import java.nio.file.Path


fun main(){
    // Imprimir los empleados con un salario superior a 2000

    // Función que reciba el XML de empleados y devuelva una lista de objetos empleado

    // RSS agencia tributaria  -> Hace4r una función que reciba dicho RSS en xml y que devuelva una lista de objetos de tipo noticia (title, link, guid, pubDate, description)
    // Lectura de fichero XML

    val gestorFich = GestorFich()
    val ficheroXML = Path.of("src").resolve("main/resources/empleados.xml")

    gestorFich.devolverListaEmpleados(ficheroXML)


}