package MainPackage;

import java.io.IOException;

public class Main {
    public static void main(String[] argv) {
        CodiceFiscale cf = null;
        try{
            cf = new CodiceFiscale("", "", "01/01/1999", 'm', "torino", "to");
        } catch (IOException e) {
            String m = e.getMessage();
            System.out.println(m);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        System.out.println(cf.codeCF());
    }
}