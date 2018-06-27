/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autocompletionproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class AutocompletionProject {

    public static void main(String[] args) {

        System.out.println("Enter a list of words for autocompletion (across ,) ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String strComplite = "";
        String str = "";
        int f = 0;
        
        while (f == 0){
            try {
                str = reader.readLine();
            } catch (IOException ex) {
                Logger.getLogger(AutocompletionProject.class.getName()).log(Level.SEVERE, null, ex);
            }
            strComplite += str;
            System.out.println("Continue input? (y/n) ");
            try {
                str = reader.readLine();
            } catch (IOException ex) {
                Logger.getLogger(AutocompletionProject.class.getName()).log(Level.SEVERE, null, ex);
            }
            if ( "y".equals(str) || "Y".equals(str) ){
                f = 0;
            } else{
                f = 1;
            }
        }
        
        if (strComplite != null){
            String strWithoutSpace = strComplite.replaceAll("\\s+","");   //Удаление пробелов 
            String[] dictionary;
            String delimeter = "[\\p{P}]"; 
            dictionary = strWithoutSpace.split(delimeter);                  //Разделение на слова
            do{
                System.out.println("Enter the prefix ");
                try {
                    str = reader.readLine();
                } catch (IOException ex) {
                    Logger.getLogger(AutocompletionProject.class.getName()).log(Level.SEVERE, null, ex);
                } 
                String prefix = str.replaceAll("\\s+","");
                f = 0;
                for (int i = 0; i < dictionary.length; i ++){
                    if ( dictionary[i].length() >= prefix.length() ){
                        if ( prefix.equals( dictionary[i].substring( 0, prefix.length() ) ) ){
                            System.out.println(dictionary[i]);
                            f = 1;
                        }
                    }
                }
                if (f == 0){
                    System.out.println("Matches in dictionary not found");
                }
                System.out.println("To finish work? (y/n)");
                try {
                    str = reader.readLine();
                } catch (IOException ex) {
                    Logger.getLogger(AutocompletionProject.class.getName()).log(Level.SEVERE, null, ex);
                }
                if ( "y".equals(str) || "Y".equals(str) ){
                    f = 1;
                } else{
                    f = 0;
                }
            } while (f == 0);
        }else {
            System.out.println("Dictionary is empty ");
        }
    }
}

