import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void removerFuncionario(int matricula) {
        funcionarios.removeIf(funcionario -> funcionario.getMatricula() == matricula);
    }

    public void exibirFuncionarios() {
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.getNome() + " - Matrícula: " + funcionario.getMatricula());
        }
    }

    public Funcionario buscarFuncionarioPorMatricula(int matricula) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getMatricula() == matricula) {
                return funcionario;
            }
        }
        return null;
    }

    public Funcionario buscarFuncionarioPorNome(String nome) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equals(nome)) {
                return funcionario;
            }
        }
        return null;
    }

    private void adicionarFuncionario() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----- Adicionar Funcionário -----");
        System.out.print("Nome do funcionário: ");
        String nome = scanner.nextLine();
        System.out.print("Matrícula do funcionário: ");
        int matricula = scanner.nextInt();

        System.out.println("Selecione o tipo de funcionário:");
        System.out.println("1. Gerente");
        System.out.println("2. Desenvolvedor");
        System.out.println("3. Estagiário");
        int tipo = scanner.nextInt();

        switch (tipo) {
            case 1:
                System.out.print("Bônus Anual: ");
                double bonusAnual = scanner.nextDouble();
                System.out.print("Equipe: ");
                int equipe = scanner.nextInt();
                adicionarGerente(nome, matricula, bonusAnual, equipe);
                break;
            case 2:
            System.out.print("Quantas tecnologias o desenvolvedor domina? ");
            int numTecnologias = scanner.nextInt();
            ArrayList<String> tecnologias = new ArrayList<>();
            scanner.nextLine();
            for (int i = 0; i < numTecnologias; i++) {
                System.out.print("Tecnologia " + (i + 1) + ": ");
                tecnologias.add(scanner.nextLine());
            }
            adicionarDesenvolvedor(nome, matricula, tecnologias);
                break;
            case 3:
            System.out.print("Horas de trabalho extras: ");
            int horasExtras = scanner.nextInt();
            System.out.print("Supervisor: ");
            scanner.nextLine();
            String supervisor = scanner.nextLine();
            adicionarEstagiario(nome, matricula, horasExtras, supervisor);
                break;
            default:
                System.out.println("Tipo de funcionário inválido.");
                break;
        }
    }

    private void adicionarGerente(String nome, int matricula, double bonusAnual, int equipe) {
        Gerente gerente = new Gerente(nome, matricula, bonusAnual, equipe);
        adicionarFuncionario(gerente);
    }
    private void removerFuncionario() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----- Remover Funcionário -----");
        System.out.print("Matrícula do funcionário a ser removido: ");
        int matricula = scanner.nextInt();
        removerFuncionario(matricula);
    }

    private void buscarFuncionarioPorMatricula() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----- Buscar Funcionário por Matrícula -----");
        System.out.print("Digite a matrícula do funcionário: ");
        int matricula = scanner.nextInt();
        Funcionario funcionario = buscarFuncionarioPorMatricula(matricula);
        if (funcionario != null) {
            System.out.println("Funcionário encontrado:");
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Matrícula: " + funcionario.getMatricula());
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    private void buscarFuncionarioPorNome() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----- Buscar Funcionário por Nome -----");
        System.out.print("Digite o nome do funcionário: ");
        String nome = scanner.nextLine();
        Funcionario funcionario = buscarFuncionarioPorNome(nome);
        if (funcionario != null) {
            System.out.println("Funcionário encontrado:");
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Matrícula: " + funcionario.getMatricula());
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    public void menu() {
        int opcao;
        do {
            System.out.println("----- Menu -----");
            System.out.println("1. Adicionar Funcionário");
            System.out.println("2. Remover Funcionário");
            System.out.println("3. Exibir Funcionários");
            System.out.println("4. Buscar Funcionário por Matrícula");
            System.out.println("5. Buscar Funcionário por Nome");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarFuncionario();
                    break;
                case 2:
                    removerFuncionario();
                    break;
                case 3:
                    exibirFuncionarios();
                    break;
                case 4:
                    buscarFuncionarioPorMatricula();
                    break;
                case 5:
                    buscarFuncionarioPorNome();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    }

    public static void main(String[] args) {
        SistemaEmpresa sistema = new SistemaEmpresa();
        sistema.menu();
    }
}