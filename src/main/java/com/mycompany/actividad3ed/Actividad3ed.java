/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.actividad3ed;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author jacky
 */
public class Actividad3ed {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 0) {
            mostrarMenu();
            opcion = leerOpcion(teclado);

            switch (opcion) {
                case 1 -> ejecutarFibonacci(teclado);
                case 2 -> ejecutarSubsetSum();
                case 3 -> ejecutarSudoku(teclado);
                case 0 -> System.out.println("Saliendo");
                default -> System.out.println("Opcion invalida, intenta de nuevo.\n");
            }
        }

        teclado.close();
    }

    private static void mostrarMenu() {
        System.out.println("========= Menu ==========");
        System.out.println("1. Fibonacci");
        System.out.println("2. Subset Sum");
        System.out.println("3. Sudoku");
        System.out.println("0. Salir");
        System.out.print("Elige una opcion: ");
    }

    private static int leerOpcion(Scanner teclado) {
        try {
            return Integer.parseInt(teclado.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }



    private static void ejecutarFibonacci(Scanner teclado) {
        System.out.print("Ingresa n: ");
        int n;
        try {
            n = Integer.parseInt(teclado.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Valor invalido.\n");
            return;
        }

        if (n < 0) {
            System.out.println("n debe ser mayor o igual a 0.\n");
            return;
        }

        Fibonacci.mostrarSerie(n);
        System.out.println("Fibonacci(" + n + ") = " + Fibonacci.calculate(n) + "\n");
    }



    private static void ejecutarSubsetSum() {
        int[] conjunto = {3, 34, 4, 12, 5, 2};
        int objetivo = 9;

        SubsetSumSolver solver = new SubsetSumSolver();
        boolean existe = solver.exists(conjunto, conjunto.length, objetivo);

        if (existe) {
            System.out.println("Existe un subconjunto que suma " + objetivo + "\n");
        } else {
            System.out.println("No existe un subconjunto que sume " + objetivo + "\n");
        }
    }



    private static void ejecutarSudoku(Scanner teclado) {
        System.out.print("Inserte sudoku: ");
        String ruta = teclado.nextLine().trim();

        SudokuFileHandler fileHandler = new SudokuFileHandler();
        SudokuSolver solver = new SudokuSolver();
        SudokuPrinter printer = new SudokuPrinter();

        int[][] tablero;
        try {
            tablero = fileHandler.leerSudokuDeArchivo(ruta);
        } catch (FileNotFoundException e) {
            System.out.println("No se encontro el archivo: " + ruta + "\n");
            return;
        } catch (IllegalArgumentException e) {
            System.out.println("El archivo no es valido: " + e.getMessage() + "\n");
            return;
        }

        System.out.println("\nLeyendo sudoku...");
        printer.print(tablero);
        System.out.println();

        if (solver.solve(tablero)) {
            System.out.println("Solucion encontrada:");
            printer.print(tablero);
            
        } else {
            System.out.println("Este Sudoku no tiene solucion.");
        }

        System.out.println();
    }
}
