package com.acme.jdbc;
import java.sql.*;

public class DriverManagerSample {
    public static void main(String[] args) throws SQLException{
        String URL = "jdbc:derby://localhost:1527/Sample";
        String USR = "app";
        String PWD = "app";
        
        Connection con = null;
        
        try {
            con = DriverManager.getConnection(URL, USR, PWD);
            
            if(con != null && !con.isClosed()) {
                System.out.println("Conexão aberta com sucesso!");
                
                doSelect(con);    
                doUpdate(con);
            }
            
        } catch(SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.close();
        }
    } 
    
    private static void doSelect(Connection c) throws SQLException{
        Statement stmt = c.createStatement();
        String SQL = "SELECT CUSTOMER_ID, NAME, CITY FROM APP.CUSTOMER";
        
        ResultSet rs = stmt.executeQuery(SQL);
        
        while(rs.next()) {
            int id = rs.getInt("CUSTOMER_ID");
            String name = rs.getString("NAME");
            String city = rs.getString("CITY");
            
            System.out.printf(" %d - %s - %s \n", id, name, city);
        }
        rs.close();
        stmt.close();
    }
    
    private static void doUpdate(Connection c) throws SQLException {
        Statement stmt = c.createStatement();
        
        String SQL = """
                     update APP.PRODUCT 
                         set AVAILABLE = 'TRUE' 
                         where PRODUCT_ID = 980001 and MANUFACTURER_ID = 19985678;
                     """;
        int r = stmt.executeUpdate(SQL);
        System.out.println("Número de registros afetados: " + r);
        stmt.close();
    }
    
    private static void doInsert(Connection c, int id, String name, String city) {
        
        String SQL = "insert into APP.MY_TABLE(ID, NAME, CITY) VALUES(?,?,?)";
    }
}
