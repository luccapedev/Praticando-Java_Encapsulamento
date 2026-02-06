package model;

import java.util.ArrayList;
import java.util.List;

public class Nota {
    private String materia;
    private double media;
    private double somaNota;
    private int notasValidas;
    private List<Double> notas = new ArrayList<>();

    public Nota(String materia) {
        this.materia = materia;
    }

    public void adicionarNota(double nota) {
        if (nota >= 0 && nota <= 10) {
            notas.add(nota);
            somaNota += nota;
        } else {
            System.out.println("Nota inválida ignorada: " + nota);
        }
    }

    public void calculaMedia(){
        notasValidas = notas.size();
        if (notasValidas == 0) {
            System.out.println("Nenhuma nota válida para calcular média.");
            return;
        }
        media = somaNota / notasValidas;
        System.out.printf("Total de notas válidas: %d\n Média em %s: %.2f\n", notasValidas, materia ,media);
    }
}
