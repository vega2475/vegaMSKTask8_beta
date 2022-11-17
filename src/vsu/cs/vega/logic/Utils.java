package vsu.cs.vega.logic;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;




public class Utils {

    public static int[][] readIntMatrixFromFile(String fileName) throws IOException {
        int[][] a;
        List<int[]> rows = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            while (line != null) {
                rows.add(Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray());
                line = reader.readLine();
            }
            a = new int[rows.size()][];
            rows.toArray(a);
        }
        return a;
    }
    //вывод
    public static void writeIntMatrixToFile(String fileName, int[][] matrix) throws IOException{

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int[] row : matrix) {
                String[] strRow =  Arrays.stream(row)
                        .mapToObj(String::valueOf)
                        .toArray(String[]::new);
                writer.write(String.join(" ", strRow));
                writer.write('\n');
            }
        }


        //out.println(Arrays.toString(matrixForOutput).replaceAll("^\\[|]$", ""));

    }

}