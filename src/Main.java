import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor, introduzca los elementos de la lista, asegurándose de que cada uno esté separado por un espacio:");
        String input = scanner.nextLine();
        String[] strArray = input.split(" ");
        int[] lista = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            lista[i] = Integer.parseInt(strArray[i]);
        }
        System.out.println("Por favor, introduzca el elemento que desea buscar:");
        int elemento = scanner.nextInt();

        System.out.println("Por favor, introduzca el número correspondiente al algoritmo que desea utilizar: (1 para Búsqueda Binaria, 2 para Búsqueda Secuencial):");
        int algoritmo = scanner.nextInt();

        int resultado = buscar(lista, elemento, algoritmo);

        if (resultado != -1) {
            System.out.println("El elemento " + elemento + " se encuentra en la posición " + resultado + " de la lista.");
        } else {
            System.out.println("El elemento " + elemento + " no se encuentra en la lista.");
        }
        scanner.close();
    }
    public static int buscar(int[] datos, int elemento, int algoritmo2) {
        if (algoritmo2 == 1) {
            return busqBinaria(datos, elemento);
        } else if (algoritmo2 == 2) {
            return busqSecuencial(datos, elemento);
        } else {
            System.out.println("El algoritmo selecc0 ionado no es reconocido. Por favor, elija entre las opciones disponibles: 1 para Búsqueda Binaria o 2 para Búsqueda Secuencial:");
            return -1;
        }
    }
    public static int busqBinaria(int[] datos, int elemento) {
        int inicio = 0;
        int fin = datos.length - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;
            if (datos[medio] == elemento) {
                return medio;
            } else if (datos[medio] < elemento) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        return -1;
    }
    public static int busqSecuencial(int[] datos, int elemento) {
        for (int i = 0; i < datos.length; i++) {
            if (datos[i] == elemento) {
                return i;
            }
        }
        return -1;
    }
}
