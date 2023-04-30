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


### Ejecutar test pasando nombre de Navegador por maven (Constantes)
mvn clean test -Dbrowser=CHROME
mvn clean test -Dbrowser=FIREFOX
mvn clean test -Dbrowser=EDGE


### Configurar Run/Debug Configuration Templates
* Run / Edit Configurations ...
* Edit Configurations Template
* -ea -Dbrowser=EDGE


### Usar navegador por parámetros con TestNG
Para usar el navegador dentro de un parámetro y usar tesNG 
debemos de quitar el argumento JVM de la plantilla de 
configuración y dejarlo por defecto como antes. 
Ver la sección anterior para retirar el argumento JVM de la plantilla de ejecución.

### Ejecutando test usando TestNG por linea de comandos
* Ir a la ruta https://maven.apache.org/surefire/maven-surefire-plugin/examples/testng.html y copiar el ejemplo en TestNG
* Ejecutar el comando: Tomará por defecto la configuración del testng.xml configurado en el pom.xml
```
mvn clean test 
```

* No necesariamente tienen que estar configurados en el pom.xml, ya que al ejecutarlo por consola
tomara los parámetros que indicamos por consola.
* Ejecutar por consola una configuración testng en específico:
```
mvn clean test -Dsufire.suiteXmlFiles=testng.xml
```
* Ejecutar por consola una configuración testng en específico + de 1 xml:
```
mvn clean test -Dsufire.suiteXmlFiles=testng_1.xml,testng_2.xml
```


