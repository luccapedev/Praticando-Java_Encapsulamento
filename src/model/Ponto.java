package model;

public class Ponto {
    private String aluno;
    private int status;
    private int soma;

    public Ponto(String aluno) {
        this.aluno = aluno;
    }

    public void ganharPontos(int pontos) {
        soma += pontos;
    }

    public void exibirStatus(){
        status = (soma / 100) + 1;

        System.out.printf("Nome: %s\nPontos: %d\nNível: %d\n", aluno, soma, status);
    }
}
