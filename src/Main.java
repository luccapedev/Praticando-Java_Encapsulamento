
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String menu = "Digite o número da funcionalidade que deseja testar:\n" +
                "1 - Cadastrando veículos\n" +
                "2 - Agenda de contatos\n" +
                "3 - Cadastro de produtos com validação\n" +
                "4 - Controle de senha\n" +
                "5 - Controle do nível de bateria\n" +
                "6 - Controle de saldo bancário\n" +
                "7 - Avaliação de filmes\n" +
                "8 - Validação de login\n" +
                "9 - Sistema de pontos para alunos\n" +
                "10 - Registro de notas\n" +
                "0 - Sair";

        System.out.println(menu);

        int escolha = -1;

        while (escolha != 0) {

            System.out.println(menu);
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("Essa funcionalidade não existe no momento!");
                    break;
                case 2:
                    System.out.println("Essa funcionalidade não existe no momento!");
                    break;
                case 3:
                    System.out.println("Essa funcionalidade não existe no momento!");
                    break;
                case 4:
                    System.out.println("Essa funcionalidade não existe no momento!");
                    break;
                case 5:
                    System.out.println("Essa funcionalidade não existe no momento!");
                    break;
                case 6:
                    System.out.println("Essa funcionalidade não existe no momento!");
                    break;
                case 7:
                    System.out.println("Essa funcionalidade não existe no momento!");
                    break;
                case 8:
                    System.out.println("Essa funcionalidade não existe no momento!");
                    break;
                case 9:
                    System.out.println("Essa funcionalidade não existe no momento!");
                    break;
                case 10:
                    System.out.println("Essa funcionalidade não existe no momento!");
                    break;
                case 0:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Não existe nenhuma funcionalidade com esse número!");
            }
        }

        scanner.close();
    }
}