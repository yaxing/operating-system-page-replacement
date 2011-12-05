//======================================//
|Operating Systems Project #3: Paging    |
|Prof. Mohamed Zahran                    |
|                                        |
|Student Name: Yaxing Chen               |
|NID: 16929794                           |
|email: yc1116@nyu.edu                   |
//======================================//

//===========Environment================//
Language: JAVA

OS: 
	wrote & works on: Darwin 10.8.0 (Mac OS X 10.6.8)
    works on        : CIMS server: SunOS Generic_144488-06 (access.cims.nyu.edu)

Other:
	JRE 6, JDK 1.6


//===========Things in .zip===============//
1. Runnable Jar: replace_page
2. Source code: ./src
3. JAR MANIFEST file: jar-manifest
4. Test input files: in1, in2, in3
5. Output: output & console
6. README.txt


//=====How to compile(interpret)=========//
(Notice: 
you can skip this step and directly run the runnable JAR file referring to following section)

1. javac src/main/*.java src/policy/*.java
2. jar cvfm replace_page jar-manifest -C src/ .


//===============How to run=============//

java -jar replace_page <policy_mode> <memory_size> <input_file>