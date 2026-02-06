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
                    String titulo;
                    int avaliacao;
                    scanner.nextLine();

                    System.out.println("Digite o nome do filme: ");
                    titulo = scanner.nextLine();
                    Filme filme = new Filme(titulo);

                    System.out.println("Digite uma nota para o filme: ");
                    avaliacao = scanner.nextInt();
                    filme.adicionarAvaliacao(avaliacao);

                    scanner.nextLine();
                    System.out.println("Deseja adicionar mais uma avaliação? (Sim/Não)");
                    confirma = scanner.nextLine();
                    while (confirma.equalsIgnoreCase("Sim")) {
                        System.out.println("Digite uma nota para o filme: ");
                        avaliacao = scanner.nextInt();
                        filme.adicionarAvaliacao(avaliacao);

                        scanner.nextLine();
                        System.out.println("Deseja adicionar mais uma avaliação? (Sim/Não)");
                        confirma = scanner.nextLine();
                    }
                    System.out.printf("Média de avaliações para %s: %.2f\n", filme.getTitulo(), filme.calcularMedia());
                    break;
                case 8:
                    String tentativaUsuario;
                    String tentativaSenha;
                    String resultadoMensagem;
                    Login login = new Login();
                    scanner.nextLine();

                    System.out.println("Registre o nome do usuário: ");
                    login.setUsuario(scanner.nextLine());

                    System.out.println("Registre a senha do usuário: ");
                    login.setSenha(scanner.nextLine());

                    System.out.println("Digite o nome do usuário: ");
                    tentativaUsuario = scanner.nextLine();

                    System.out.println("Digite a senha do usuário: ");
                    tentativaSenha = scanner.nextLine();

                    resultadoMensagem = login.validarLogin(tentativaUsuario, tentativaSenha);
                    System.out.println(resultadoMensagem);

                    System.out.println("Tentar novamente? (Sim/Não)");
                    confirma = scanner.nextLine();
                    while (confirma.equalsIgnoreCase("Sim")) {
                        System.out.println("Digite o nome do usuário: ");
                        tentativaUsuario = scanner.nextLine();

                        System.out.println("Digite a senha do usuário: ");
                        tentativaSenha = scanner.nextLine();

                        resultadoMensagem = login.validarLogin(tentativaUsuario, tentativaSenha);
                        System.out.println(resultadoMensagem);

                        if (resultadoMensagem.equalsIgnoreCase("Login bem-sucedido") ||
                                resultadoMensagem.equalsIgnoreCase("Quantidade de tentativas excedida. Acesso bloqueado")) {
                            break;
                        }
                        System.out.println("Tentar novamente? (Sim/Não)");
                        confirma = scanner.nextLine();
                    }
                    break;
                case 9:
                    String aluno;
                    int quantidade;
                    scanner.nextLine();

                    System.out.println("Digite o nome do aluno:");
                    aluno = scanner.nextLine();
                    Ponto pontos = new Ponto(aluno);

                    System.out.println("Quantos pontos deseja adicionar?");
                    quantidade = scanner.nextInt();
                    pontos.ganharPontos(quantidade);

                    scanner.nextLine();
                    System.out.println("Deseja adicionar mais pontos? (Sim/Não)");
                    confirma = scanner.nextLine();
                    while (confirma.equalsIgnoreCase("Sim")){
                        System.out.println("Quantos pontos deseja adicionar?");
                        quantidade = scanner.nextInt();
                        pontos.ganharPontos(quantidade);

                        scanner.nextLine();
                        System.out.println("Deseja adicionar mais pontos? (Sim/Não)");
                        confirma = scanner.nextLine();
                    }

                    pontos.exibirStatus();
                    break;
                case 10:
                    scanner.nextLine();

                    System.out.println("Digite o nome da matéria: ");
                    Nota materia = new Nota(scanner.nextLine());

                    System.out.println("Digite a nota do aluno: ");
                    materia.adicionarNota(scanner.nextDouble());

                    scanner.nextLine();
                    System.out.println("Deseja registrar mais notas? (Sim/Não)");
                    confirma = scanner.nextLine();

                    while (confirma.equalsIgnoreCase("Sim")){
                        System.out.println("Digite a nota do aluno: ");
                        materia.adicionarNota(scanner.nextDouble());

                        scanner.nextLine();
                        System.out.println("Deseja registrar mais notas? (Sim/Não)");
                        confirma = scanner.nextLine();
                    }

                    materia.calculaMedia();
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