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
public class main {
    public static final String CLEAR_CONSOLE = "\033[H\033[2J";
    private static Scanner lerTeclado = new Scanner(System.in);

    // Método para limpar o console
    public static void clearScreen() {
        System.out.print(CLEAR_CONSOLE);
        System.out.flush();
    }

    public static void exibirMenu() {
        String menu = """
                \n
                        Gerenciamento de Custos com Combustível
                \n
                        1 - Cadastrar Carros
                        2 - Exibir todos os carros Cadastrados e seus respectivos gastos
                        3 - Mostrar o Carro que mais Gastou
                        4 - Mostrar total gasto em Combustível
                        0 - Sair
                        """;
        System.out.println(menu);
    }

    public static void main(String[] args) {
        int opcao;
        
        do {
            clearScreen();
            exibirMenu();
            System.out.print("Escolha uma opção: ");
            opcao = lerTeclado.nextInt();
            lerTeclado.nextLine(); // Limpar o buffer
            
            switch (opcao) {
                case 1:
                    clearScreen();
                    System.out.println("Opção 1 - Cadastrar Carros");
                    // Implementar cadastro de carros
                    break;
                case 2:
                    clearScreen();
                    System.out.println("Opção 2 - Exibir carros cadastrados");
                    // Implementar exibição de carros
                    break;
                case 3:
                    clearScreen();
                    System.out.println("Opção 3 - Carro que mais gastou");
                    // Implementar lógica para encontrar carro que mais gastou
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