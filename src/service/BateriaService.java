package service;

import model.Bateria;

public class BateriaService {
    public void verificaStatus(Bateria bateria) {
        String status = "";

        if (bateria.getNivel() >= 0 && bateria.getNivel() <= 100) {
            if (bateria.getNivel() <= 20) {
                status = "Bateria fraca";
            } else  if (bateria.getNivel() > 20 && bateria.getNivel() < 80) {
                status = "Bateria ok";
            }else if (bateria.getNivel() >= 80) {
                status = "Bateria cheia";
            }

            System.out.println("Status: " + status);
        }  else {
            System.out.println("Nível de bateria inválido.");
        }
    }
}
