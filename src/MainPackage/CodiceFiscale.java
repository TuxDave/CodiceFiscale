package MainPackage;

import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CodiceFiscale{
    private String cognome;
    private String nome;
    private String data;
    private char sesso;
    private String[] comune = new String[2];
    private String cc;
    
    //COSTRUTTORI
    public CodiceFiscale(String cognome, String nome, String data, char sesso, String comune, String sigla)throws IOException, FileNotFoundException{
        this.setCognome(cognome);
        this.setNome(nome);
        this.setData(data);
        this.setSesso(sesso);
        this.setComune(comune, sigla);
    }

    //Getter-Setter
    public String getCognome(){
        return this.cognome;
    }
    public void setCognome(String s){
        this.cognome = s.toUpperCase();
    }
    public String getNome(){
        return this.nome;
    }
    public void setNome(String s){;
        this.nome = s.toUpperCase();
    }
    public String getData(){
        return this.data;
    }
    public void setData(String s){
        if(!Pattern.matches("^[0-9]{1,2}\\/[0-9]{1,2}\\/[0-9]{4}", s)){ //se la data non è nel formato giusto:
            throw new IllegalArgumentException("La data inserita non è nel formato corretto [GG/MM/AAAA]");
        }else{
            this.data = s;
        }
    }
    public char getSesso(){
        return this.sesso;
    }
    public void setSesso(char c){
        c = Character.toUpperCase(c);
        if(c != 'M' && c != 'F'){
            throw new IllegalArgumentException("Il sesso può essere soltanto M o F");
        }else{
            this.sesso = c;
        }
    }
    public String getComune(){
        return new String(this.comune[0] + " (" + this.comune[1] + ")");
    }
    public void setComune(String a, String b) throws FileNotFoundException, IOException{ //a = nomeComune, b = sigla
        a = a.replace(' ', '_');
        a = a.toLowerCase();
        b = b.toUpperCase();
        if(!Pattern.matches("[A-Z][A-Z]", b)){
            throw new IllegalArgumentException("Sigla città non valida, usare formato [XX] es. TO");
        }
        FileReader file = new FileReader("./db/catasto.csv");
        BufferedReader lettore = new BufferedReader(file);
        String[] riga = new String[3];
        riga[0] = lettore.readLine();
        boolean found = false;
        do{
            riga = riga[0].split(",");
            if(riga[0].equals(a) && riga[1].equals(b)){
                this.comune[0] = riga[0];
                this.comune[1] = riga[1];
                this.cc = riga[2];
                found = true;
                break;
            }
            riga[0] = lettore.readLine();
        }while(riga[0] != null);
        file.close();
        if(!found){
            throw new IllegalArgumentException("Nome della città o sigla non corrette!");
        }
    }
}