# UADE: Algoritmos Y Estructuras De Datos II - Programación II

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

Este repositorio contiene todo lo necesario para poder seguir la materia desde el inicio hasta el final.

## Tabla de contenidos

Los siguientes son los puntos más importantes en este archivo:
- [Requisitos](#requisitos)
- [Comprobar requisitos](#comprobar-requisitos)
- [FAQ](#faq)

## Requisitos

Para poder realizar el curso necesitas tener instalado en tu computadora las siguientes herramientas:
- [Java](http://jdk.java.net/)
- [Maven](https://maven.apache.org/)
- [Git](https://git-scm.com/)

Si no tienes algunas de estas herramientas instaladas en tu computadora, sigue las instrucciones en la documentación oficial de cada herramienta o los videos creados como guía para esta materia.

## Comprobar requisitos

Si instalaste en tu computadora algunas de estas herramientas anteriormente o lo acabas de hacer ahora, verifica si todo funciona bien.

- Comprueba si la versión de Java está correctamente instalada usando el siguiente comando:
   ````
   % java -version
   openjdk 21.0.2 2024-01-16
   OpenJDK Runtime Environment GraalVM CE 21.0.2+13.1 (build 21.0.2+13-jvmci-23.1-b30)
   OpenJDK 64-Bit Server VM GraalVM CE 21.0.2+13.1 (build 21.0.2+13-jvmci-23.1-b30, mixed mode, sharing)
   ````

- Comprueba si la versión de Maven en tu computadora es 3.8.0 o superior. Podés ver qué versión de Maven tenés usando el siguiente comando:
   ````
   % mvn --version
   Apache Maven 3.8.3
   Maven home: /usr/share/maven
   ````

- Comprueba si tienes instalado de manera correcta en tu computadora Git usando el siguiente comando:
   ````
   % git --version
   git version 2.34.1
   ````


ESTRUCTURA
NOMENCLATURA
PREGUNTAS ACERCA DE PORQUE USAR UNA U OTRA
LINKS DE FORMAS DE INSTALACION Y VIDEOS
REGLAS A SEGUIR
CODE CONVENTIONS

## Estándares de código

Java tiene una serie de reglas definidas para desarrollar algo, ya sea una aplicación o una librería, y que todos los desarrolladores usen los mismos criterios. Existen las siguientes formas de validar si se está siguiendo el formato correcto: 

- **Code conventions**: Este [documento](https://www.oracle.com/technetwork/java/codeconventions-150003.pdf) que fue creado en 1997 con el fin de definir los estándares de código que debería seguir cualquier desarrollador que usa Java.

- **SonarLint**: Es un plugin que nos ayuda al código fuente, siga los estándares de Java y reducir los bugs que podrían generarse. Esta herramienta tiene soporte para casi todos los IDE existentes, dentro de los más conocidos tiene soporte en:
    - [IntelliJ](https://plugins.jetbrains.com/plugin/7973-sonarlint)
    - [Eclipse](https://marketplace.eclipse.org/content/sonarqube-ide)
    - [Visual Studio Code](https://marketplace.visualstudio.com/items?itemName=SonarSource.sonarlint-vscode)

## Estructura del proyecto

El proyecto que se usara a lo largo de la cursada tiene estructura similar a la siguiente:

````
src/
  └── main
      └── java
          └── org
              └── uade
                  ├── algorithm
                  ├── exception
                  ├── structure
                  │   ├── definition
                  │   └── implementation
                  │       ├── dynamic
                  │       │   └── extras
                  │       └── fixed
                  └── util
````

Como se puede ver en la estructura existen una serie de paquetes donde cada uno tiene una funcionalidad en particular. En la siguiente tabla se detalla cada uno de los paquetes como asi tambien si deben o no tener prefijos los archivos en su interior:



https://www.jetbrains.com/lp/devecosystem-2023/java/

https://www.jrebel.com/success/resources/2024-Java-developer-productivity-report

https://survey.stackoverflow.co/2024/technology#1-integrated-development-environment
