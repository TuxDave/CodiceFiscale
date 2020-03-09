# CodiceFiscaleJava
Calcolatore di codice fiscale italiano scritto in Java
## Funzionalità

 - CrashSafe: Dispone di una UI testuale fatta a prova di errore, per evitare qualunque tipo di crash del programma
 - BugSave: Garantisce il calcolo corretto del codice fiscale anche in caso di nomi particolari (es in caso di nome con numero di lettere inferiore a 3).
 L'unico caso problematico è quando per via di omonimi perfetti (stesso nome e cognome, nati lo stesso giorno nella stessa città), l'ultimo carattere del codice viene cambiato manualmente durante la creazione del documento di identità: un algoritmo non può prevedere quale sia la lettera scelta dall'incaricato, in quanto questa scelta è casuale.
 

## Requisiti di Sistema
 - Java 8+ (jre52 o superiore)
 - javac 8+ (jdk52 o superiore)(opzionale in caso si voglia compilare)

## Build & Run
***RUN***
Se non si possiede un compilatore (jdk) è presente una release precompilata pronta all'esecuzione nel tab "[Release](https://github.com/TuxDave/CodiceFiscaleJava/releases)" di GitHub.
Per avviare:
In caso si abbia scaricato la versione precompilata in formato `jar` sarà sufficiente:

    java -jar CodiceFiscale.jar
In caso si abbia compilato in prima persona basterà:

    java MainPackage.Main

***BUILD***
In caso si voglia procedere alla compilazione è sufficiente compilare il CodiceFiscale con il comando:

     javac CodiceFiscale/*
in automatico verrà compilato per la vostra versione del jre.

