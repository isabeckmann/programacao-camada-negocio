package com.acme.db;

import com.acme.entity.Author;
import com.acme.entity.Book;
import java.sql.*;
import java.util.List;

public class DBManager {
    private static final String URL = "jdbc:derby://localhost:1527/library_db";
    private static final String USR = "root";
    private static final String PWD = "root";
    
    private static Connection connection;

    //abrir conexão
    public static boolean openConnection() {
        try {
            if(connection != null && !connection.isClosed()) {
                return true;
            }
            connection = DriverManager.getConnection(URL, USR, PWD);
            return true;
        } catch(SQLException ex) {
            System.out.println("failed");
            return false;
        }
    }

    //fechar 
    public static void closeConnection() {
        try {
            if(connection != null && connection.isClosed()) {
                return;
            }
            connection.close();
        } catch(SQLException ex) {
            System.out.println("error when closing connection");
        }
    }
    
    //save a list of books to the db
    public static void store(List<Book> books) {
        String SQL = """
                     INSERT INTO BOOKS (TITLE,
                                        YEAR_PUBLICATION,
                                        VOLUME,
                                        LANGUAGE,
                                        ISBN,
                                        PAGES)
                     VALUES(?,?,?,?,?,?)
                     """;
        try {
            DBManager.openConnection();
            connection.setAutoCommit(false); //iniciando transação
            PreparedStatement pstmt = connection.prepareStatement(SQL);
            
            for(Book b: books) {
                pstmt.setString(1, b.getTitle());
                pstmt.setInt(2, b.getYear());
                pstmt.setInt(3, b.getVolume());
                pstmt.setString(4, b.getLanguage());
                pstmt.setString(5, b.getIsbn());
                pstmt.setInt(6, b.getPages());
                pstmt.execute();
                
                for(Author a: b.getAuthors()) {
                    store(a, b);
                }
            }
            
            connection.commit(); //fechabdi transação
            DBManager.closeConnection();
            
        } catch(SQLException ex) {
            ex.printStackTrace();
            System.out.println("error when saving books");
        }
    }
    
    //save authors of a given book
    public static void store(Author a, Book b) throws SQLException {
        String SQL = """
                     INSERT INTO AUTHORS(NAME,
                                         EMAIL,
                                         AFILIATION,
                                         IS_CORRESPONDING)
                     VALUES(?,?,?,?)
                     """;
        PreparedStatement pstmt = connection.prepareStatement(SQL);
        pstmt.setString(1, a.getName());
        pstmt.setString(2, a.getEmail());
        pstmt.setString(3, a.getAfiliation());
        pstmt.setBoolean(4, a.isIsCorrespondingAuthor());
        
        pstmt.execute();
        
        SQL = """
              INSERT INTO BOOK_AUTHORS(BOOK_ID, AUTHOR_ID)
              VALUES (
                (SELECT ID FROM BOOKS WHERE TITLE=?),
                (SELECT ID FROM AUTHORS WHERE NAME=?)
              )
              """;
        
        pstmt = connection.prepareStatement(SQL);
        pstmt.setString(1, b.getTitle());
        pstmt.setString(2, a.getName());
        pstmt.execute();
    }
}
