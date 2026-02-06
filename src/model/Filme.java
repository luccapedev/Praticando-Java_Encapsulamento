package model;

import java.util.ArrayList;
import java.util.List;

public class Filme {
    String titulo;
    List<Integer> avaliacoes = new ArrayList<Integer>();

    public String getTitulo() {
        return titulo;
    }

    public Filme(String titulo) {
        this.titulo = titulo;
    }

    public void adicionarAvaliacao(int avaliacao) {
        if (avaliacao < 1 || avaliacao > 5) {
            System.out.println("Nota inválida (1 a 5).");
            return;
        }
        avaliacoes.add(avaliacao);
    }

    public double calcularMedia() {
        int soma = 0;
        for (int nota : avaliacoes) {
            soma += nota;
        }

        return (double) soma / avaliacoes.size();
    }
}
