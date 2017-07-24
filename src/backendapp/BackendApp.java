/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backendapp;

import java.util.Scanner;

/**
 *
 * @author Windows 7
 */
public class BackendApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DbConnect dbc = new DbConnect();
        dbc.Connect();      
        RGen rgen = new RGen();        
        Scanner sc = new Scanner(System.in);     
        int opc = 0;
        int cpf;
        String name;
        int active;
        int value;
        
        while(opc != 9){
            System.out.println("Select an option:");            
            System.out.println("1 - Insert 1 record;");
            System.out.println("2 - Insert 3000 records;");
            System.out.println("3 - Delete everything");
            System.out.println("4 - Get that result set");
            System.out.println("9 - Exit");
            opc = sc.nextInt();
            switch(opc){
                case 1:
                    cpf = rgen.Cpf();
                    name = rgen.Name();
                    active = rgen.Active();                    
                    value = rgen.Value();
                    dbc.Insert(cpf, name, active, value);
                    break;
                case 2:
                    for(int i = 0; i < 3000; i++){
                        cpf = rgen.Cpf();
                        name = rgen.Name();
                        active = rgen.Active();                    
                        value = rgen.Value();
                        dbc.Insert(cpf, name, active, value);
                    }
                    break;
                case 3:
                    dbc.Delete();
                    break;
                case 4:
                    dbc.SelectSet();
                    dbc.SelectAvg();
                    break;
                case 9:
                    break;
                default:
                    System.out.println("please do not do that");
                    break;
            }
        }
        
        dbc.Close();
        
    }
    
}
