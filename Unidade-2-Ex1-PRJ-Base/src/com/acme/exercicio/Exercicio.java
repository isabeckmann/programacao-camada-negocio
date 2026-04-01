package com.acme.exercicio;

import java.sql.*;

public class Exercicio {

    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample", "app", "app");
        Statement stmt = con.createStatement();
        
        /* Completar com a expressão SQL */
        // "ID", "Fabricante", "Tipo", "Custo", "Quantidade em Estoque", "Disponibilidade", "Descrição"
        String SQL = """ 
                     select 
                        p.PRODUCT_ID, 
                        m.NAME,
                        pc.DESCRIPTION as PRODUCT_CODE_DESCRIPTION,
                        p.PURCHASE_COST,
                        p.QUANTITY_ON_HAND,
                        p.AVAILABLE,
                        p.DESCRIPTION
                     from 
                        PRODUCT p 
                     left join MANUFACTURER m on m.MANUFACTURER_ID = p.MANUFACTURER_ID
                     left join PRODUCT_CODE pc on pc.PROD_CODE = p.PRODUCT_CODE
                     """;
        
        ResultSet rs = stmt.executeQuery(SQL);
        
        /* Chamar a janela para exibição */
        JanelaExercicio janela = new JanelaExercicio( rs );
        janela.setVisible(true);

    }
}
