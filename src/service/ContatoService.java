package service;

import model.Contato;

import java.util.ArrayList;
import java.util.List;

public class ContatoService {
    private List<Contato> listaContatos = new ArrayList<>();

    public void adicionarContato(Contato contatos) {
        listaContatos.add(contatos);
    }

    public void exibirContatos() {
        int numeracao = 1;
        System.out.printf("Lista de contatos:\n");
        for (Contato contato : listaContatos) {
            System.out.printf(numeracao + ". %s - %s\n", contato.getNome(), contato.getTelefone());
            numeracao++;
        }
    }
}
