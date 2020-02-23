package MainPackage;

import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

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
    public CodiceFiscale() throws IOException, FileNotFoundException{
        this("","","01/01/1999",'f',"roma", "ro");
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

    //Metodi Calcolatori del CF
    public String codeCognome(){
        String vocali = "", consonanti = "", v="AEIOU";
        for(char lettera : this.getCognome().toCharArray()){
            if(v.contains(Character.toString(lettera))){
                vocali += lettera;
            }else if(!v.contains(Character.toString(lettera)) && lettera != ' ' && lettera != '\''){
                consonanti += lettera;
            }
        }
        v = consonanti + vocali;
        String c = "";
        if(v.length() >= 3){
            c = v.substring(0, 3);
        }else{
            c = v;
            c += "X".repeat(3 - v.length());
        }
        return c;
    }
    public String codeNome(){
        String vocali = "", consonanti = "", v="AEIOU";
        for(char lettera : this.getNome().toCharArray()){
            if(v.contains(Character.toString(lettera))){
                vocali += lettera;
            }else if(!v.contains(Character.toString(lettera)) && lettera != ' ' && lettera != '\''){
                consonanti += lettera;
            }
        }
        String n = "";
        vocali += "XXX";
        if(consonanti.length() >= 4){
            n += new String(consonanti.toCharArray()[0] + consonanti.substring(2, 4));
        }else{
            n = consonanti;
            n += vocali.substring(0, (3 - consonanti.length()));
        }
        return n;
    }
    public String codeYear(){
        return new String(this.getData().substring(8,10));
    }
    public String codeMese(){
        int m = Integer.parseInt(this.getData().substring(3,5));
        String[] corr = new String[12];
        corr[0] = "A";
        corr[1] = "B";
        corr[2] = "C";
        corr[3] = "D";
        corr[4] = "E";
        corr[5] = "H";
        corr[6] = "L";
        corr[7] = "M";
        corr[8] = "P";
        corr[9] = "R";
        corr[10] = "S";
        corr[11] = "T";
        return corr[m - 1];
    }
    public String codeDay(){
        String d = this.getData().substring(0,2);
        if(this.getSesso() == 'F'){
            int ret = Integer.parseInt(d);
            ret += 40;
            d = Integer.toString(ret);
        }
        return d;
    }
    private String codeParziale(){
        return new String(this.codeCognome() + this.codeNome() + this.codeYear() + this.codeMese() + this.codeDay() + this.cc);
    }
    private String codeCDC(){
        TreeMap<Character, Integer> dispari = new TreeMap<>();
        TreeMap<Character, Integer> pari = new TreeMap<>();
        String stringaDispari = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String stringaPari = stringaDispari;
        int[] interiDispari = {1,0,5,7,9,13,15,17,19,21,1,0,5,7,9,13,15,17,19,21,2,4,18,20,11,3,6,8,12,14,16,10,22,25,24,23};
        int[] interiPari = {0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
        for(int i = 0; i < stringaDispari.length(); i++){
            dispari.put(stringaDispari.toCharArray()[i], interiDispari[i]);
            pari.put(stringaPari.toCharArray()[i], interiPari[i]);
        }
        String p1 = "", p2 = "", parziale = this.codeParziale();
        int s = 0;
        for (int i = 0; i < 15; i++){
            if (i % 2 == 0){ //dispari
                p1 += parziale.toCharArray()[i];
            }else{ //pari
                p2 += parziale.toCharArray()[i];
            }
        }
        for(char lettera : p1.toCharArray()){ //dispari
            s += dispari.get(lettera);
        }
        for(char lettera : p2.toCharArray()){ //pari
            s += pari.get(lettera);
        }
        p1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        s = s % 26;
        return Character.toString(p1.toCharArray()[s]);
    }
    public String codeCF(){
        return new String(this.codeParziale() + this.codeCDC());
    }
}