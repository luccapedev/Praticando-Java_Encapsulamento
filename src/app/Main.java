package app;

import model.*;
import service.*;

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
                    scanner.nextLine();
                    System.out.print("Digite o modelo do carro: ");
                    String modelo = scanner.nextLine();

                    System.out.print("Digite a placa do carro: ");
                    String placa = scanner.nextLine();

                    System.out.print("Digite o ano do carro: ");
                    int ano = scanner.nextInt();

                    Carro carro = new Carro(modelo, placa, ano);

                    CarroService service = new CarroService();
                    service.exibirInformacoes(carro);
                    break;
                case 2:
                    String confirma;
                    ContatoService contatoService = new ContatoService();

                    do {
                        scanner.nextLine();
                        System.out.println("Digite o nome do contato: ");
                        String nome = scanner.nextLine();

                        System.out.println("Digite o número de telefone do contato: ");
                        String telefone = scanner.nextLine();

                        Contato contato = new Contato(nome, telefone);
                        contatoService.adicionarContato(contato);
                        contatoService.exibirContatos();

                        System.out.println("Deseja adicionar um novo contato? (Sim/Não)");
                        confirma = scanner.nextLine();
                    } while (confirma.equalsIgnoreCase("Sim"));

                    System.out.println("Fechando agenda...");
                    break;
                case 3:
                    ProdutoService produtoService = new ProdutoService();
                    scanner.nextLine();

                    System.out.println("Digite o nome do produto: ");
                    String nome = scanner.nextLine();

                    System.out.println("Digite o preço do produto: ");
                    double preco = scanner.nextDouble();

                    Produto produto = new Produto(nome, preco);

                    produtoService.validaProduto(produto);
                    break;
                case 4:
                    UsuarioService usuarioService = new UsuarioService();
                    Usuario usuario = new Usuario();

                    scanner.nextLine();

                    System.out.println("Registre uma senha: ");
                    usuario.setSenha(scanner.nextLine());

                    System.out.println("Deseja alterar a senha? (Sim/Não)");
                    confirma = scanner.nextLine();
                    if (confirma.equalsIgnoreCase("Sim")) {
                        System.out.println("Digite a sua senha atual para gerar uma nova: ");
                        String senha = scanner.nextLine();

                        System.out.println("Digite a nova senha: ");
                        String novaSenha = scanner.nextLine();

                        usuarioService.redefinirSenha(usuario,senha, novaSenha);
                    }
                    break;
                case 5:
                    BateriaService bateriaService = new BateriaService();
                    Bateria bateria = new Bateria();
                    scanner.nextLine();

                    System.out.println("Digite o nível da bateria:");
                    bateria.setNivel(scanner.nextInt());

                    bateriaService.verificaStatus(bateria);
                    break;
                case 6:
                    SaldoService saldoService = new SaldoService();
                    scanner.nextLine();

                    System.out.println("Digite o nome do titular da conta: ");
                    String titular = scanner.nextLine();
                    Saldo saldo = new Saldo(titular);

                    int confirmaInt = 1;
                    while (confirmaInt != 0) {
                        System.out.println("""
                                1 - Realizar depósito
                                2 - Realizar saque
                                3 - Exibir saldo
                                0 - Sair
                                """);
                        confirmaInt = scanner.nextInt();

                        if(confirmaInt == 1) {
                            System.out.println("Digite o valor que deseja depositar: ");
                            double valorDeposito = scanner.nextDouble();
                            saldoService.depositar(saldo, valorDeposito);
                        } else if (confirmaInt == 2) {
                            System.out.println("Digite o valor que deseja sacar: ");
                            double valorSaque = scanner.nextDouble();
                            saldoService.sacar(saldo, valorSaque);
                        } else if (confirmaInt == 3) {
                            saldoService.exibirSaldo(saldo);
                        }
                    }
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