# LOC Counting

LOC Counting es un programa que permite contar las lineas dentro de un archivo. Funciona de dos formas: 

## Conteo de lineas físcas
Cuenta las lineas fisicas dentro de un archivo y, para uso requiere de dos parametros:
- El primero nos refiere al tipo de conteo: "phy"
- El segundo nos indica la ruta del archivo que queremos contar: "path"

## Conteo de lineas de código
Cuenta las lineas de codigo eliminando toda linea en blanco o comentarios del lenguaje java. Para su uso requiere de dos parametrosÑ
- El primero nos refiere al tipo de conteo: "loc"
- El segundo nos indica la ruta de archivo que queremos contar: "path"

### Conteo de horas

* Horas trabajadas: 4
* Lineas de código: 68
* Loc/h: 17

### Prerequisitos
Se recomienda contar con las siguientes versiones instaladas:
```
version de java: 15
version de compilador: 1.8
Apache maven: 3.63 
```

### Instalación
Para uso del proyecto requerimos clonar este repositorio. Siga los pasos:

1. Clonamos el repositorio con ayuda de git
```
git clone https://github.com/JohannCepeda16/ARSW-Lab1.git
```

2. Accedemos a la carpeta donde hemos clonado
```
cd ARSW-Lab1
```

3. Compilamos nuestro proyecto para generar el target
```
mvn package
```

4. Abrimos el proyecto con nuestro editor de preferencia
```
code .
```

### Corriendo las pruebas
Si queremos ejecutar las pruebas de nuestro proyecto debemos ubicarnos en la raiz del pryecto y usar el comando
```
mvn test
```
![test](https://github.com/JohannCepeda16/ARSW-Lab1/blob/main/resources/test.PNG)


## Programa hecho con

* [Maven](https://maven.apache.org/) - Dependency Management

## Actor

* **Johann Cepeda** - [johanncepeda16](https://github.com/JohannCepeda16)


## Licencia

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.txt) file for details

## Diseño

Para mas información del diseño del proyecto puede ver el siguiente [documento](https://github.com/JohannCepeda16/ARSW-Lab1/blob/main/resources/LOC%20Counting.pdf)

## Report de pruebas
Para mas informacion de las pruebas del proyecto, siga el siguente [enlace](https://github.com/JohannCepeda16/ARSW-Lab1/blob/main/resources/TestReportpdf.pdf)

## JavaDoc

La documentación del proyecto la puede econtrar siguiendo este  [enlace](https://github.com/JohannCepeda16/ARSW-Lab1/tree/main/src/site/apidocs)





