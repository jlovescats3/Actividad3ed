package com.mycompany.actividad3ed;

public class Fibonacci {

    static long[] memoria;

    public static long calculate(int n) {

        if (memoria[n] != -1) {
            return memoria[n];
        }

        if (n == 0 || n == 1) {
            return n;
        }

        memoria[n] = calculate(n - 1) + calculate(n - 2);

        return memoria[n];
    }

    public static void mostrarSerie(int n) {

        memoria = new long[n + 1];

        for (int i = 0; i <= n; i++) {
            memoria[i] = -1;
        }

        System.out.println("\nSerie de Fibonacci:");

        for (int i = 0; i <= n; i++) {
            System.out.print(calculate(i) + " ");
        }

        System.out.println();
    }
}
