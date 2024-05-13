package com.contractreport.input;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class InputFile {
    private static final String PATH = "input/input.txt";

    public static List<String> getContractData() {
        List<String> contractDetails = new ArrayList<>();
        try {
            File file = new File(PATH);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                contractDetails.add(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error While reading the file ." + e.getLocalizedMessage());
        }
        return contractDetails;
    }
}
