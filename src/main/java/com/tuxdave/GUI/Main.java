package com.tuxdave.GUI;

import com.tuxdave.CodiceFiscale.CodiceFiscale;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main{
    public static void main(String[] argv)throws IOException {
        Gui a = new Gui();
        a.setVisible(true);
        a.pack();
        Scanner lettore = new Scanner(System.in);
        System.out.println("Benvenuto nel calcolatore di Codice Fiscale Italiano!\n ---La Versione Grafica sarà disponibile a breve!---");
        System.out.println("Provvedi inserendo i dati quando richiesti\n");
        CodiceFiscale cf = null;
        try{
            cf = new CodiceFiscale();
        }catch(NullPointerException e){
            System.out.println("File catasto.csv non trovato! Posizionarlo nel percorso \"./db/catasto.csv\" rispetto al com.tuxdave.GUI");
            System.out.println("Arrivederci");
            System.exit(0);
        }
        System.out.print("\nInserisci il cognome (omettere accenti ed apostrofi) ==> ");
        cf.setCognome(lettore.nextLine());
        System.out.print("Inserisci il nome (omettere accenti ed apostrofi) ==> ");
        cf.setNome(lettore.nextLine());
        do{
            System.out.print("Inserire la data di nascita nel formato [GG/MM/AAAA] ==> ");
            try{
                cf.setData(lettore.nextLine());
                break;
            }catch(IllegalArgumentException e){
                System.out.println("    " + e.getMessage());
            }
        }while(true);
        do{
            System.out.print("Inserire il proprio sesso [M/F] ==> ");
            String s = lettore.nextLine();
            s = s.toUpperCase();
            try{
                cf.setSesso(s.toCharArray()[0]);
                break;
            }catch(IllegalArgumentException e){
                System.out.println("    " + e.getMessage());
            }
        }while(true);
        do{
            System.out.print("Inserire la città di nascita seguita da uno spazio e la sigla di quella citta (es: torino TO) ==> ");
            try{
                cf.setComune(lettore.next(), lettore.next());
                break;
            }catch(IllegalArgumentException e){
                System.out.println("    " + e.getMessage());
            }
        }while(true);
        System.out.println("\nCODICE FISCALE ==> " + cf.codeCF() + "\n\nArrivederci!");
        lettore.close();
    }
}