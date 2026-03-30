/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.map.b.lab.stringheNumeri.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author pierpaolo
 */
public class ExMail {

    /**
     *
     */
    public static final String EXP_MAIL = "([a-zA-Z][\\w]*[\\.]?[\\w]+)@([a-zA-Z]+)(\\.[a-zA-Z]{2,3})";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println(EXP_MAIL);
            System.out.println(args[0].matches(EXP_MAIL));
            System.out.println("===GROUPS===");
            Pattern p = Pattern.compile(EXP_MAIL);
            Matcher m = p.matcher(args[0]);
            while (m.find()) {
                int g = m.groupCount();
                for (int i = 0; i <= g; i++) {
                    System.out.println(" Group: " + m.group(i) + " start: " + m.start(i) + " " + m.end(i));
                }
            }
        }
    }

}
