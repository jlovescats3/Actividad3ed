package com.mycompany.actividad3ed;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class SudokuFileHandler {

    private static final int SIZE = SudokuSolver.SIZE;

 
    public int[][] leerSudokuDeArchivo(String ruta) throws FileNotFoundException {
        int[][] tablero = new int[SIZE][SIZE];
        File archivo = new File(ruta);
        Scanner lector = new Scanner(archivo);

        for (int fila = 0; fila < SIZE; fila++) {
            String linea = lector.nextLine().trim(); // quita sobrantes 

            if (linea.length() != SIZE) {
                lector.close();
                throw new IllegalArgumentException(
                    "La línea " + (fila + 1) + " no tiene 9 caracteres: \"" + linea + "\"");
            }

            for (int col = 0; col < SIZE; col++) {
                tablero[fila][col] = Character.getNumericValue(linea.charAt(col));
            }
        }

        lector.close();
        return tablero;
    }
}
