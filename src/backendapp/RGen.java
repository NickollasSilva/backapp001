/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backendapp;
import java.io.*;
import java.util.Random;
/**
 *
 * @author Windows 7
 */
public class RGen {
    public static int cpf = 0;
    Random rand = new Random();
    
    public String Name(){
        String line = null;
        try {
            FileReader fr = new FileReader("./first-names.txt");
            BufferedReader br = new BufferedReader(fr);
            StringBuilder sb = new StringBuilder();            
            
            int r = rand.nextInt(4900);
            
            for (int i = 0; i < r; i++) {
                br.readLine();              
            }            
            
            line = br.readLine();
            
        } catch (Exception e){
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        return line;
    }
    
    public int Cpf(){
        cpf++;
        return cpf;
    }
    
    public int Active(){
        int r = rand.nextInt(1);
        return r;               
    }
    
    public int Value(){
        int r = rand.nextInt(5000);
        return r;
    }
}
