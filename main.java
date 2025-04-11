// Importações necessárias (ex: Scanner)

// Inicializa o scanner para entrada do usuário
// Lista para armazenar os carros (usando uma classe Carro ou arrays)
// Variável de controle do loop principal
// Loop principal (do-while ou while)
// Exibe o menu de opções
// Lê a opção do usuário
// Switch para tratar cada opção
// CADA CASE CORRESPONDE A UMA PARTE DO PROGRAMA

// 2. CADASTRAR CARROS
// Limpa o buffer do scanner (se necessário)
// Pede os dados do carro ao usuário
// Validações básicas (if-else)
// Calcula o gasto total (opcional: pode pedir o preço por litro)
// Cria o objeto Carro e adiciona à lista

// 3. EXIBIR TODOS OS CARROS
// Verifica se há carros cadastrados (if-else)
// Cabeçalho da tabela
// Percorre a lista com for-each

// 4. MOSTRAR CARRO QUE MAIS GASTOU
// Inicializa variáveis para comparação
// Percorre a lista com for-i
// Exibe o resultado

// 5. MOSTRAR TOTAL GASTO
// Soma os gastos com for-each

// 6. SAIR
// Exibe mensagem de saída

// LEMBRETES: 
// Evitar valores negativos ou zerados

// return para sair do método se houver erro

// 2. MÉTODOS
// - Cadastrar: valida dados, adiciona à lista
// - Exibir: verifica lista vazia, imprime tabela
// - Maior gasto: compara valores com for-i
// - Total: soma com for-each

// 3. CLASSE Carro
// Modelo, placa, km, litros, gastoTotal + getters

import java.util.Scanner;
import java.util.ArrayList;

public class main {
    public static final String CLEAR_CONSOLE = "\033[H\033[2J";
    private static Scanner lerTeclado = new Scanner(System.in);
    private static java.util.ArrayList<Carro> carros = new java.util.ArrayList<>();
    private static final double litroDoPosto = 6.29; // Updated price per liter

    public static void clearScreen() {
        System.out.print(CLEAR_CONSOLE);
        System.out.flush();
    }

    public static void exibirMenu() {
        String menu = "----------------------------\n" + "1 - Cadastrar Carros\n" + "2 - Exibir carros cadastrados\n" + //
                "3 - Mostrar carro que mais gastou\n" + "4 - Mostrar gasto total\n" + "0 - Sair\r\n" + //
                "----------------------------\n";
        System.out.print(menu);
    }

    /////// dados que ira armazenar os carros cadastrados.
    static class Carro {
        String modeloCarro;
        double dinheiroCliente;
        double valorLitro;

        public Carro(String modeloCarro, double dinheiroCliente, double valorLitro) {
            this.modeloCarro = modeloCarro;
            this.dinheiroCliente = dinheiroCliente;
            this.valorLitro = valorLitro;
        }

        /////// opcao 1: cadastrar carros
        public static void cadastrarCarros() {
            clearScreen();
            System.out.println("Opção 1 - Cadastrando Carros:");
            System.out.println("----- CADASTRO DE CARROS (Máx: 5) -----");
            for (int i = 0; i < 5; i++) {
                System.out.println("\nCarro #" + (i + 1));

                System.out.print("Modelo: ");
                String modeloCarro = lerTeclado.nextLine();

                System.out.print("Dinheiro disponível: R$ ");
                double dinheiroCliente = lerTeclado.nextDouble();
                lerTeclado.nextLine();
                carros.add(new Carro(modeloCarro, dinheiroCliente, litroDoPosto)); // Using the constant litroDoPosto
                if (i < 4) {
                    System.out.print("\nCadastrar outro Carro? (S/N): ");
                    String continuar = lerTeclado.nextLine();
                    if (!continuar.equalsIgnoreCase("S")) {
                        break;
                    }
                }
            }
            System.out.println("\nCadastro concluído!");
        }

        /////// opção 2: exibir carros cadastrados

        public static void exibirCarros() {
            clearScreen();
            System.out.println("Opção 2 - Exibir carros cadastrados:");
            if (carros.isEmpty()) {
                System.out.println("\nNenhum carro cadastrado.");
            } else {
                System.out.println("----- CARROS CADASTRADOS -----");
                System.out.println("Modelo\t\t\tDinheiro\t\tLitros");
                for (Carro carro : carros) {
                    double litros = carro.dinheiroCliente / carro.valorLitro;
                    System.out.printf("%-15s\t\tR$ %-10.2f\t\t%.2f L%n",
                            carro.modeloCarro,
                            carro.dinheiroCliente,
                            litros);
                }
                System.out.println("---------------------------------");
            }
        }

        /////// opção 3: mostrar carro que mais gastou
        
        public static void mostrarCarroMaisGastou() {
            clearScreen();
            System.out.println("Opção 3 - Mostrar carro que mais gastou:");
            if (carros.isEmpty()) {
                System.out.println("\nNenhum carro foi cadastrado ainda!");
            } else {
                Carro carroMaisGastou = carros.get(0);
                for (Carro carro : carros) {
                    if (carro.dinheiroCliente > carroMaisGastou.dinheiroCliente) {
                        carroMaisGastou = carro;
                    }
                }

                System.out.printf("Carro que mais gastou: %s - R$ %.2f (%.2f litros)%n",
                        carroMaisGastou.modeloCarro,
                        carroMaisGastou.dinheiroCliente,
                        carroMaisGastou.dinheiroCliente / litroDoPosto);
            }
        }

        /////// aqui do-While fara o menu e opções serem carregadas através das funções
        /////// criadas acima.
        /// assim que o usuario selecionar via switch, qual case ele escolher.
        public static void main(String[] args) {
            int opcao;
            do {
                clearScreen();
                exibirMenu();
                System.out.print("Escolha uma opção: ");
                opcao = lerTeclado.nextInt();
                lerTeclado.nextLine();

                switch (opcao) {
                    case 1:
                        cadastrarCarros();
                        break;
                    case 2:
                        exibirCarros();
                        break;
                    case 3:
                        mostrarCarroMaisGastou();
                        break;
                    case 4:
                        clearScreen();
                        System.out.println("Opção 4 - Total gasto em combustível");
                        // Implementar cálculo do total gasto
                        break;
                    case 0:
                        clearScreen();
                        System.out.println("Saindo...");
                        break;
                    default:
                        clearScreen();
                        System.out.println("Opção Inválida!");
                        break;
                }

                if (opcao != 0) {
                    System.out.println("\nPressione Enter para continuar...");
                    lerTeclado.nextLine();
                }
            } while (opcao != 0);

            lerTeclado.close();
        }
    }
}