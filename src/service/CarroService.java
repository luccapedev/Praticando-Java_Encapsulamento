package service;

import model.Carro;

public class CarroService {

    public void exibirInformacoes(Carro carro) {
        System.out.printf(
                "Veículo cadastrado:\nModelo: %s\nPlaca: %s\nAno: %d\n",
                carro.getModelo(),
                carro.getPlaca(),
                carro.getAno()
        );
    }
}
