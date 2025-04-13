// Aividade Prática feita em Grupo
// Alunos: Bernardo Antunes Heckler; Gilmar Biolch; Gustavo Francisco;
// RA's: 1137118; 1137267; 1137279.

// importei o Scanner e ArrayList( é uma lista dinâmica que permite armazenar vários valores
// e redimensionar automaticamente conforme adicionamos ou removemos itens.)
import java.util.Scanner;
import java.util.ArrayList;

public class main {
    public static final String CLEAR_CONSOLE = "\033[H\033[2J";

    // private previne que dentro dessa classe aja modificaçãoes externas.
    private static Scanner lerTeclado = new Scanner(System.in); // classe Scanner para ler entrada de dados
    private static java.util.ArrayList<Veiculo> veiculos = new java.util.ArrayList<>();
    private static final double litroDoPosto = 6.29; // AQUI O PREÇO FIXO DO LITRO DO POSTO
    // 'final' indica que este valor é uma CONSTANTE e não pode ser alterado

    // Limpar a tela
    public static void clearScreen() {
        System.out.print(CLEAR_CONSOLE);
        System.out.flush();
    }

    // deixei o texto do menu em uma String, para facilitar a visualização e na sua
    // chamada.
    public static void exibirMenu() {
        String menu = "----------------------------\n" +
                "1 - Cadastrar Veiculos\n" +
                "2 - Exibir todos os veiculos cadastrados e seus respectivos gastos\n" +
                "3 - Mostrar veiculo que mais gastou\n" +
                "4 - Mostrar gasto total gasto em combustíivel\n" +
                "5 - Calcular média de gastos por veículo\n" +
                "0 - Sair do programa\r\n" +
                "----------------------------\n";
        System.out.print(menu);
    }

    // Dados que ira armazenar os veiculos cadastrados.
    static class Veiculo {
        String nomeCarros;
        double dinheiroCliente;
        double valoresCombustivel;

        public Veiculo(String nomeCarros, double dinheiroCliente, double valoresCombustivel) {
            // criando o veiculo com nomes, dinheiro e tanque.
            this.nomeCarros = nomeCarros;
            this.dinheiroCliente = dinheiroCliente;
            this.valoresCombustivel = valoresCombustivel;
        }

        /////// opcao 1: cadastrar veiculos
        public static void cadastrarVeiculos() {
            // for i que percorre 5 vezes, para cadastrar até 5 veiculos.
            for (int i = 0; i < 5; i++) {
                clearScreen();
                System.out.println("Opção 1 - Cadastrando Veiculos:");
                System.out.println("----- CADASTRO DE VEICULOS (Máx: 5) -----");
                System.out.println("\nVeiculo #" + (i + 1));

                System.out.print("Modelo: ");
                String nomeCarros = lerTeclado.nextLine();

                // Verifica se o nome está vazio, contém apenas números, ou contém apenas
                // espaços
                if (nomeCarros.isEmpty() || nomeCarros.matches("\\d+") || nomeCarros.trim().isEmpty()) {
                    nomeCarros = "modelo-unknown";
                }

                // VALIDAÇÃO DO VALOR POSITIVO previnindo valor negativo
                double dinheiroCliente = 0;
                boolean entradaValida = false;

                // do-while esperando por valor válido
                do {
                    System.out.print("Dinheiro disponível (valor positivo): R$ ");
                    if (lerTeclado.hasNextDouble()) {
                        dinheiroCliente = lerTeclado.nextDouble();
                        if (dinheiroCliente <= 0) {
                            System.out.println("Valor inválido! Digite um valor positivo.");
                        } else {
                            entradaValida = true;
                        }
                    } else {
                        System.out.println("Entrada inválida! Digite um número válido.");
                        lerTeclado.next(); // Limpa a entrada inválida
                    }
                } while (!entradaValida);

                lerTeclado.nextLine(); // Consome a quebra de linha

                // Adiciona um novo objeto Veiculo à ArrayList 'veiculos'
                veiculos.add(new Veiculo(nomeCarros, dinheiroCliente, litroDoPosto));

                // Pergunta se quer continuar após os 4 primeiros veiculos (0 a 3)
                if (i < 4) {
                    System.out.print("\nCadastrar outro Veiculo? (S/N): ");
                    String continuar = lerTeclado.nextLine();
                    if (!continuar.equalsIgnoreCase("S")) {
                        break;
                    }
                }
            }
            clearScreen();
            System.out.println("Cadastro concluído!");
        }

        /////// opção 2: exibir veiculos cadastrados
        public static void exibirVeiculos() {
            clearScreen();
            System.out.println("Opção 2 - Exibir veiculos cadastrados:");
            if (veiculos.isEmpty()) { // veiculos.isEmpty() verifica se a ArrayList 'veiculos' está vazia
                System.out.println("\nNenhum veiculo cadastrado.");
            } else {
                System.out.println("----- VEICULOS CADASTRADOS -----");
                System.out.println("Modelo\t\t\tDinheiro\t\tLitros");
                for (Veiculo veiculo : veiculos) {
                    double litros = veiculo.dinheiroCliente / veiculo.valoresCombustivel;
                    System.out.printf("%-15s\t\tR$ %-10.2f\t\t%.2f L%n",
                            veiculo.nomeCarros,
                            veiculo.dinheiroCliente,
                            litros);
                }
                System.out.println("---------------------------------");
            }
        }

        /////// opção 3: mostrar veiculo que mais gastou
        public static void mostrarVeiculoMaisGastou() {
            clearScreen();
            System.out.println("Opção 3 - Mostrar veiculo que mais gastou:");
            if (veiculos.isEmpty()) { // // veiculos.isEmpty() verifica se a ArrayList 'veiculos' está vazia
                System.out.println("\nNenhum veiculo foi cadastrado ainda!");
            } else {
                Veiculo veiculoMaisGastou = veiculos.get(0);
                for (Veiculo veiculo : veiculos) {
                    if (veiculo.dinheiroCliente > veiculoMaisGastou.dinheiroCliente) {
                        veiculoMaisGastou = veiculo;
                    }
                }

                System.out.printf("\nVeiculo que mais gastou: %s - R$ %.2f (%.2f litros)%n",
                        veiculoMaisGastou.nomeCarros,
                        veiculoMaisGastou.dinheiroCliente,
                        veiculoMaisGastou.dinheiroCliente / litroDoPosto);
            }
        }

        /////// opção 4: mostrar total gasto em combustível
        public static void totalGastoCombustivel() {
            clearScreen();
            System.out.println("Opção 4 - Mostrar gasto total em combustível:\n");
            if (veiculos.isEmpty()) { // // veiculos.isEmpty() verifica se a ArrayList 'veiculos' está vazia
                System.out.println("Nenhum veiculo foi cadastrado ainda!");
            } else {
                double litrosTotais = 0;
                double dinheiroTotal = 0;
                for (Veiculo veiculo : veiculos) { // Para cada veículo na lista calcular abaixo.
                    litrosTotais += veiculo.dinheiroCliente / veiculo.valoresCombustivel;
                    dinheiroTotal += veiculo.dinheiroCliente;
                }
                System.out.printf("Total de litros abastecidos: %.2f L%n", litrosTotais);
                System.out.printf("Dinheiro total gasto: R$ %.2f%n", dinheiroTotal);
            }
        }

        /////// opção 5: calcular media de litros gastos por veiculo
        public static void calcularMediaGastos() {
            clearScreen();
            System.out.println("Opção 5 - Calcular media de litros gastos por veiculo:\n");
            if (veiculos.isEmpty()) { // veiculos.isEmpty() verifica se a ArrayList 'veiculos' está vazia
                System.out.println("Nenhum veiculo foi cadastrado ainda!");
            } else {
                double dinheiroTotal = 0;
                int quantidadeVeiculos = veiculos.size();

                for (Veiculo veiculo : veiculos) { // Para cada veículo na lista somar o dinheiro gasto por cada veículo
                    dinheiroTotal += veiculo.dinheiroCliente;
                }

                double mediaGastos = dinheiroTotal / quantidadeVeiculos;
                double mediaLitros = (dinheiroTotal / litroDoPosto) / quantidadeVeiculos;

                System.out.println("----- MÉDIA DE GASTOS -----");
                System.out.printf("Quantidade de veículos: %d%n", quantidadeVeiculos);
                System.out.printf("Média de gastos em dinheiro: R$ %.2f por veículo%n", mediaGastos);
                System.out.printf("Média de litros abastecidos: %.2f L por veículo%n", mediaLitros);
                System.out.println("----------------------------");
            }
        }

        // main = menu principal
        public static void main(String[] args) {
            int opcao = -1;

            // Loop do-while para manter o programa rodando até o usuário escolher sair
            do {
                clearScreen();
                exibirMenu(); // Mostra o menu de opções
                System.out.print("Escolha uma opção: ");
                if (lerTeclado.hasNextInt()) {
                    opcao = lerTeclado.nextInt(); // Lê a opção do usuário
                } else {
                    System.out.println("Opção inválida. Tente novamente.");
                    lerTeclado.nextLine(); // Consome a entrada inválida
                    continue;
                }
                lerTeclado.nextLine(); // Consome a quebra de linha deixada pelo nextInt()

                // Estrutura switch para executar a ação correspondente à opção escolhida
                switch (opcao) {
                    case 1:
                        cadastrarVeiculos(); // Chama o método para cadastrar veículos
                        break;
                    case 2:
                        exibirVeiculos(); // Chama o método para listar veículos cadastrados
                        break;
                    case 3:
                        mostrarVeiculoMaisGastou(); // Chama o método para mostrar veículo com maior gasto
                        break;
                    case 4:
                        totalGastoCombustivel(); // Chama o método para calcular gasto total
                        break;
                    case 5:
                        calcularMediaGastos(); // Chama o método para calcular a média de gastos
                        break;
                    case 0:
                        clearScreen();
                        System.out.println("Saindo..."); // Mensagem de saída do programa
                        break;
                    default:
                        clearScreen();
                        System.out.println("Opção Inválida! Digite um número entre 0 e 5."); // Atualizado para incluir
                                                                                             // opção 5
                        break;
                }

                // Se a opção não for 0 (sair), pausa antes de mostrar o menu novamente
                if (opcao != 0) {
                    System.out.println("\nPressione Enter para continuar...");
                    lerTeclado.nextLine();
                }
            } while (opcao != 0); // Condição de saída: quando opcao for 0
        }

    }
}
