# Crear Proyecto en Maven - Intellij
```
Seleccionar Maven, 
Name: Nombre Proyecto
Location: ~\Desktop
JDK: 20 Oracle  -> version JAVA SUPERIOR AL 8
Archetype: org.apache.maven.archetypes:maven-archetype-quickstart
Clic en el Botón Create.
```

### Cambiar idioma IDE Intellij, Pycharm "Corrección Ortográfica"
```
File / Settings / Editor / Natural Lenguages  / Agregar Español
```

### Link de pruebas: https://askomdch.com/
- iniciarte sesión en el sistema para las pruebas.

---------------------------------------------------

### Instalar Maven de manera local --> https://maven.apache.org/download.cgi
* Descargar maven:
```
  https://dlcdn.apache.org/maven/maven-3/3.9.1/binaries/apache-maven-3.9.1-bin.zip
```
* Ponerlo en la ruta: 
```
C:\apache-maven-3.9.1\bin
```
* Agregar mvn a las variables de entorno
* Validar Maven en el sistema
```
mvn -version
```

### Correr pruebas por Línea de comandos en Maven
```
mvn clean test
```

### Ejecutar test pasando nombre de Navegador por maven
mvn clean test -Dbrowser=Chrome
mvn clean test -Dbrowser=Firefox
mvn clean test -Dbrowser=Edge