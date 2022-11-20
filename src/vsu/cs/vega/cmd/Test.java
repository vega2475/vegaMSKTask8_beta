package vsu.cs.vega.cmd;

import vsu.cs.vega.logic.Solution;
import vsu.cs.vega.logic.Utils;

import java.io.IOException;

public class Test {
    public static InputArgs parseCmdArgs(String[] args) throws CmdParseArgsError {
        if (args.length != 2) {
            throw new CmdParseArgsError();
        }
        return new InputArgs(args[0], args[1]);
    }


    public static void main(String[] args) {
//        String inTest = "tests/inputTest.txt";
//        String outTest = "tests/outputTest.txt";

        InputArgs inputArgs = null;
        try {
            inputArgs = parseCmdArgs(args);
        } catch (CmdParseArgsError e) {
            System.err.println("Ошибка разбора аргументов коммандной строки");
            System.exit(1);
        }


        int[][] sourceMatrixTests1 = new int[0][0];

        try {
            sourceMatrixTests1 = Utils.readIntMatrixFromFile(inputArgs.inputFile);
        } catch (IOException e) {
            System.err.printf("Ошибка при чтении исходного файла %s", e.toString());
            System.exit(2);
        }

        int[][] a1 = Solution.calc(sourceMatrixTests1);

        try {
            Utils.writeIntMatrixToFile(inputArgs.outputFile, a1);

        } catch (IOException e) {
            System.err.printf("Ошибка при записи массива в файл %s", e.toString());
            System.exit(3);
        }


    }
}
