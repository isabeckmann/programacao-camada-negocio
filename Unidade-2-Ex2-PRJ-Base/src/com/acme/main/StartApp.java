package com.acme.main;
import com.acme.db.DBManager;
import com.acme.entity.Author;
import com.acme.entity.Book;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StartApp {

    public static void main(String[] args) {
       
            List<Book> myBooks  = new ArrayList();
            Book b1 = new Book();
            b1.setTitle("Java in Action");
            b1.setLanguage("eng");
            b1.setIsbn("12345678");
            b1.setPages((byte) 100);
            b1.setVolume((byte)1);
            b1.setYear((byte)2025);
            
            Author a1 = new Author();
            a1.setName("Isa");
            a1.setAfiliation("unijui");
            a1.setEmail("@isa");
            a1.setIsCorrespondingAuthor(true);
            b1.addAuthor(a1);
            
            Author a2 = new Author();
            a2.setName("Julia");
            a2.setAfiliation("unijui");
            a2.setEmail("@julia");
            a2.setIsCorrespondingAuthor(false);
            b1.addAuthor(a2);
            
            myBooks.add(b1);
            
            DBManager.store(myBooks);
               
    }
    
    private static void createTableSample() throws SQLException {
        final String URL = "jdbc:derby://localhost:1527/library_db";
        final String USR = "root";
        final String PWD = "root";
        Connection con = DriverManager.getConnection(URL, USR, PWD);
        
        if(con == null) {
            return;
        }
        
        Statement stmt = con.createStatement();
        
        String SQL = """
                     CREATE TABLE AUTHORS
                         (ID          		INT 		NOT NULL 	GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
                          NAME  			VARCHAR(25) 	NOT NULL,
                          EMAIL         		VARCHAR(50) 	NOT NULL,     
                          AFILIATION			VARCHAR(100) 	NOT NULL,
                          IS_CORRESPONDING 		BOOLEAN 	DEFAULT FALSE,     
                          PRIMARY KEY (ID)
                     )
                     """;
        
        stmt.execute(SQL);
        System.out.println("Table created");
        stmt.close();
    }
    
}
