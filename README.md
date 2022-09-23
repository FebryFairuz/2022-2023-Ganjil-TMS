## Source Code Materi Pemograman Berbasis Objek & Lab

Academic Calendar 2022-2023 Ganjil 
Class of TI-21-PA (A1 and A2) and TI-21-KA

Institute Business and Informatics Kesatuan Bogor

## Tools for this course

- JAVA SDK KIT [here](https://www.oracle.com/java/technologies/downloads/#jdk17-windows).
- IDE Text Editor ([Notepad++](https://notepad-plus-plus.org/downloads/), [Sublime](https://www.sublimetext.com/3), [VSCode](https://code.visualstudio.com/download), [Eclipse](https://www.eclipse.org/downloads/), [Netbeans](https://www.oracle.com/java/technologies/javase-jdk-7-netbeans-downloads.html))
- Command Line (Windows) or Terminal (Linux)
- UML Online [here](https://www.diagrameditor.com/)
- UML offline tools Star UML [here](https://staruml.io/download)
- Apache Maven [here](https://maven.apache.org/download.cgi) 
- Library Eclipse Window Builder [here](https://download.eclipse.org/windowbuilder/latest/)

## How to compile and Run JAVA File

1. Open terminal/command line
2. Enter to directory of your project
3. Type this for compiling : javac NameFile.java
4. Type this for run : java NameClass 

Example how to `compile` and `run` the project

> d:\IBIK\2020-2021\PBO>cd src/karyawan/Pertemuan1

> d:\IBIK\2020-2021\PBO\src\karyawan\Pertemuan1>javac Handphone.java

> d:\IBIK\2020-2021\PBO\src\karyawan\Pertemuan1>java Handphone

## How to compile and Run JAVA File with Package

1. Open terminal/command line
2. Enter to directory of your project
3. Type this for compiling : `javac -d ../bin packageName/NameFile.java`
4. Type this for run : `java -cp ../bin packageName.NamaClass`


## How to Install Maven

1. Download Apache Maven
2. Extract the file and copy folder to c:/Program File
3. Create JAVA_HOME in environment variable on your PC
4. Click `New` put Variable Name : `JAVA_HOME` and Variable Value : `C:\Program Files\Java\jdk-17.0.1` and then OK
5. Still in environtment variable, choose variable `PATH`. Click `Edit` and then click button `New` put the path of maven `C:\Program Files\apache-maven-3.8.3\bin` and then klik `OK` and `OK`
6. Open terminal type `mvn -v`

## How to create and run the project Maven
1. Open terminal dan tulis script dibawah ini 
	`mvn -B archetype:generate -DgroupId=com.sample.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4`
2. Masuk kedalam path project yang telah dibuat
	`cd my-app`
3. Compiler untuk maven `mvn clean package`
4. Runing project `mvn exec:java -Dexec.mainClass="com.sample.app.App"`	

## Collection of Practical Assignments

Upload your source code to version control by GIT such as GITHUB/GITLAB/BITBUCKET and add `@FebryFairuz` to your repository as a member with role Maintener.
Or you can push your code to repl.it and add @FebryFairuz 
