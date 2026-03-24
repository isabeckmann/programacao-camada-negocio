package com.contador;

import java.util.*;

public class AnalisadorTexto {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um texto:");
        String texto = scanner.nextLine();

        // minúsculas e remoção de pontuação
        texto = texto.toLowerCase().replaceAll("[^a-zà-ú0-9\\s]", "");

        String[] palavras = texto.split("\\s+");

        // contagem de frequência
        Map<String, Integer> frequencia = new HashMap<>();

        for (String palavra : palavras) {
            if (!palavra.isEmpty()) {
                frequencia.put(palavra, frequencia.getOrDefault(palavra, 0) + 1);
            }
        }
        
        // 1) Lista sem duplicatas
        System.out.println("\n--- Lista de palavras ---");
        for (String palavra : frequencia.keySet()) {
            System.out.println(palavra + " [" + frequencia.get(palavra) + "]");
        }

        // 2) Ordem alfabética
        System.out.println("\n--- Ordem alfabética ---");

        List<String> listaOrdenada = new ArrayList<>(frequencia.keySet());
        Collections.sort(listaOrdenada);

        for (String palavra : listaOrdenada) {
            System.out.println(palavra + " [" + frequencia.get(palavra) + "]");
        }

        // 3) Ordem por frequência (decrescente)
        System.out.println("\n--- Ordem por frequência (decrescente) ---");

        List<Map.Entry<String, Integer>> listaFrequencia = new ArrayList<>(frequencia.entrySet());

        listaFrequencia.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        for (Map.Entry<String, Integer> entry : listaFrequencia) {
            System.out.println(entry.getKey() + " [" + entry.getValue() + "]");
        }

        scanner.close();
    }
}