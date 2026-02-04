package service;

import model.Produto;

public class ProdutoService {
    public void validaProduto(Produto produto) {
        if (produto.getPreco() <= 0){
            System.out.printf("Preço inválido.\nProduto: %s\nPreço: R$0,00\n", produto.getNome());
        } else {
            System.out.printf("Preço válido.\nProduto: %s\nPreço: R$%.2f\n", produto.getNome(), produto.getPreco());
        }
    }
}
