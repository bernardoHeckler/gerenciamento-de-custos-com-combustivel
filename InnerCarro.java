
public class InnerCarro {
    String nome;
    String modelo;
    String placa;
    int ano;
    double km;
    double litros;
    double precoCombustivel;
    double gastoPosto;

    public InnerCarro(String nome, String modelo, String placa, int ano, double km, double litros, double precoCombustivel, double gastoPosto) {
        this.nome = nome;
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
        this.km = km;
        this.litros = litros;
        this.precoCombustivel = precoCombustivel;
        this.gastoPosto = gastoPosto;
    }

    public double calcularKmPorLitro() {
        if (litros == 0) return 0;
        return km / litros;
    }

    public double calcularLitrosAbastecidos() {
        return gastoPosto / precoCombustivel;
    }

    public void mostrarDados() {
        System.out.println("===================================");
        System.out.println("Nome: " + nome);
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano: " + ano);
        System.out.println("Placa: " + placa);
        System.out.println("Quilometragem: " + km + " km");
        System.out.println("Litros consumidos: " + String.format("%.2f", litros) + " L");
        System.out.printf("Consumo: %.2f km/L\n", calcularKmPorLitro());
        System.out.printf("Gasto no posto: R$ %.2f\n", gastoPosto);
        System.out.printf("Litros abastecidos: %.2f L\n", calcularLitrosAbastecidos());
        System.out.println("===================================");
    }

    public static double calcularTotalGastoPosto(InnerCarro[] lista) {
        double total = 0;
        for (InnerCarro InnerCarro : lista) {
            total += InnerCarro.gastoPosto;
        }
        return total;
    }

    public static void main(String[] args) {
        double precoCombustivel = 5.79;

        InnerCarro[] lista = new InnerCarro[5];

        lista[0] = new InnerCarro("Honda", "Civic LXS", "ABC-1001", 2008, 400.0, 42.10, precoCombustivel, 100.00);
        lista[1] = new InnerCarro("Volkswagen", "Golf GTI", "DEF-2002", 2018, 400.0, 47.05, precoCombustivel, 100.00);
        lista[2] = new InnerCarro("Ford", "Ranger 3.2 LTZ", "GHI-3003", 2014, 400.0, 57.14, precoCombustivel, 200.00);
        lista[3] = new InnerCarro("Volkswagen", "Amarok V6", "JKL-4004", 2018, 400.0, 50.00, precoCombustivel, 80.00);
        lista[4] = new InnerCarro("Toyota", "Corolla Altis", "MNO-5005", 2023, 400.0, 33.33, precoCombustivel, 60.00);

        System.out.println("=== lista Cadastrados ===");
        for (InnerCarro InnerCarro : lista) {
            InnerCarro.mostrarDados();
        }

        // F.O.I – InnerCarro menos econômico (menor km/L)
        InnerCarro menosEconomico = lista[0];
        for (int i = 1; i < lista.length; i++) {
            if (lista[i].calcularKmPorLitro() < menosEconomico.calcularKmPorLitro()) {
                menosEconomico = lista[i];
            }
        }

        // Mostrar total gasto no posto
        double totalGasto = calcularTotalGastoPosto(lista);
        System.out.printf("\n=== TOTAL GASTO NO POSTO POR TODOS OS lista: R$ %.2f ===\n", totalGasto);
    }
}
