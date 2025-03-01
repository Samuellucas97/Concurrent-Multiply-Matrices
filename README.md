# Matrix multiplication

## Introduction  

This folder contains the implementation of the sequential and concorrent multiply matrix. Given this, it refers to one of the activities of the 1st unit of the _Concurrent Programming_ discipline taught by dr. Everton Cavalcante Bachelor of Information Technology at the Federal University of Rio Grande do Norte (__UFRN__).


- [Prerequisites](#prerequisites) - Project prerequisites
- [About the algorithm](#about-the-algorithm) - Informations about the algorithm.
- [Execution](#execution) - Information about how to execute
- [Author](#authors) - Project authors.


## Prerequisites

You need the following programs to use this repository:

 - JDK 11

_This project was loaded on Eclipse using above configurations_

## About the concurrent algorithm

For concurrent version, It's was created a thread according compute capability. The rows will be divide by threads and each thread will compute your subset like the sequencial version.  But if the division it's not exact then I will create a thread with all remaning rows  


## Execution 

In the terminal, execute: 


```
$java Matrix-multiplication/bin br.ufrn.imd.br.Main [X] [F]
```

Where:

- `X` it should substitute for 4, 8, 16, 32, 64, 128, 256, 512, 1024 and 2048 that it's avaliable dimension matrix;
- `F` it should substitute for `S` (sequential version algorithm) or `C` (concurrent version algorithm);

## Authors 


| Nome: | email: | 
| ---------- | ------------- |
|`Daniel Henrique Ferreira Gomes` 	|_danhfg@ufrn.edu.br_  
|`Samuel Lucas de Moura Ferino` 	|_samuellucas97@ufrn.edu.br_  
