package MainPackage;

import java.io.IOException;

public class Main {
    public static void main(String[] argv) {
        CodiceFiscale cf = null;
        try{
            cf = new CodiceFiscale("", "fo", "11/11/1234", 'm', "villasor", "su");
        } catch (IOException e) {
            String m = e.getMessage();
            System.out.println(m);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        System.out.println(cf.codeCognome() + cf.codeNome() + cf.codeYear());
    }
}