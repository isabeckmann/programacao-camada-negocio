import java.util.Random;

public class Document {
    private final String nome;
    private final int numPaginas;

    public Document(String nome) {
        this.nome = nome;
        // Define um número de páginas aleatório entre 1 e 30 (influencia no tempo)
        this.numPaginas = new Random().nextInt(30) + 1; [cite: 12, 14]
    }

    public String getNome() {
        return nome;
    }

    public void print() {
        System.out.println("[IMPRESSORA] Imprimindo: " + nome + " (" + numPaginas + " páginas)...");
        try {
            // Simula o tempo de impressão: a Thread dorme 1 segundo por página
            Thread.sleep(numPaginas * 1000L); [cite: 13]
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("A impressão foi interrompida.");
        }
        System.out.println("[IMPRESSORA] Concluído: " + nome);
    }
}