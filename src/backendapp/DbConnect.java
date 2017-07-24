/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backendapp;
import java.sql.*;
import java.math.*; 
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Windows 7
 */
public class DbConnect {
    public Connection conn = null;

    public void Connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String URL = "jdbc:mysql://localhost:3306/backapp";
            String USER = "root";
            String PASS = "";
            conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }
    
    public void Close(){
        try{
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }
    
    public void Insert(int cpf, String name, int active, int value){
        PreparedStatement pstmt = null;
        String SQL = "INSERT INTO tb_customer_account(cpf_cnpj, nm_customer, is_active, vl_total) "
                   + "VALUES (" + cpf + ", '" + name + "', " + active + ", "+ value +");";
        try {           
           pstmt = conn.prepareStatement(SQL);
           Boolean ret = pstmt.execute(SQL);
           System.out.println("Return value is : " + ret.toString() );
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        finally {
            try {
                pstmt.close();
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println(e.getClass().getName()+": "+e.getMessage());
                System.exit(0);
            }
        } 
    }
    
    public void SelectSet(){
        Statement stmt = null;
        String SQL = "SELECT * "
                + "FROM tb_customer_account "
                + "WHERE vl_total > 560 AND id_customer BETWEEN 1500 and 2700 "
                + "ORDER BY vl_total DESC;";
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while(rs.next()){
                int id  = rs.getInt("id_customer");
                int cpf = rs.getInt("cpf_cnpj");
                String name = rs.getString("nm_customer");
                int value = rs.getInt("vl_total");

                System.out.print("ID: " + id);
                System.out.print(", Valor: " + value);
                System.out.print(", CPF: " + cpf);
                System.out.println(", Nome: " + name);
            }
            rs.close();
    
        } catch (Exception e){
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }
    
    public void SelectAvg(){
        Statement stmt = null;
        String SQL = "SELECT AVG(vl_total) "
                + "FROM tb_customer_account "
                + "WHERE vl_total > 560 AND id_customer BETWEEN 1500 and 2700 "
                + "ORDER BY vl_total DESC;";
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while(rs.next()){
                int value = rs.getInt(1);
                System.out.println("Media dos valores: " + value);
            }
            rs.close();
    
        } catch (Exception e){
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }
        
    public void Delete(){
        PreparedStatement pstmt = null;
        String SQL = "DELETE FROM tb_customer_account";
        
        try {           
           pstmt = conn.prepareStatement(SQL);
           Boolean ret = pstmt.execute(SQL);
           System.out.println("Return value is : " + ret.toString() );
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        finally {
            try {
                pstmt.close();
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println(e.getClass().getName()+": "+e.getMessage());
                System.exit(0);
            }
        } 
    }
    
}
