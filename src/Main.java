import service.CurrencyService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CurrencyService service = new CurrencyService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== CONVERSOR DE MONEDAS ====");
            System.out.println("1. Mostrar todas las monedas");
            System.out.println("2. Convertir moneda");
            System.out.println("3. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar entrada

            switch (opcion) {
                case 1:
                    service.showAvailableCurrencies();
                    break;
                case 2:
                    System.out.print("Para saber las monedas disponibles eliga la opcion 1\n");
                    System.out.print("Moneda origen (ej: USD): ");
                    String from = scanner.nextLine().toUpperCase();
                    System.out.print("Moneda destino (ej: EUR): ");
                    String to = scanner.nextLine().toUpperCase();
                    System.out.print("Cantidad: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); // limpiar entrada
                    service.convertCurrency(from, to, amount);
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

}