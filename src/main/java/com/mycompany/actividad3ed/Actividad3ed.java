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
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 0) {
            mostrarMenu();
            opcion = leerOpcion(scanner);

            switch (opcion) {
                case 1 -> ejecutarFibonacci(scanner);
                case 2 -> ejecutarSubsetSum();
                case 3 -> ejecutarSudoku(scanner);
                case 0 -> System.out.println("Saliendo");
                default -> System.out.println("Opcion invalida, intenta de nuevo.\n");
            }
        }

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("========= Menu ==========");
        System.out.println("1. Fibonacci");
        System.out.println("2. Subset Sum");
        System.out.println("3. Sudoku");
        System.out.println("0. Salir");
        System.out.print("Elige una opcion: ");
    }

    private static int leerOpcion(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }



    private static void ejecutarFibonacci(Scanner scanner) {
        System.out.print("Ingresa n: ");
        int n;
        try {
            n = Integer.parseInt(scanner.nextLine().trim());
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
       StringBuilder subconjunto = new StringBuilder();
       boolean existe = solver.existsConSubconjunto(conjunto, conjunto.length, objetivo, subconjunto);

       if (existe) {
           System.out.println("Existe un subconjunto que suma " + objetivo + ": [" + subconjunto + "]\n");
       } else {
           System.out.println("No existe " + objetivo + "\n");
       }
   }

    private static void ejecutarSudoku(Scanner scanner) {
        System.out.print("Inserte sudoku: ");
        String ruta = scanner.nextLine().trim();

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
