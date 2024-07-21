package com.practice.mypractice.programs;

import java.io.*;
import java.nio.file.*;

public class SplitIntoMultipleFiles {
    private static final int MAX_LINES = 50000;

    public static void main(String[] args) {
        String inputFilePath = "/Users/ssaluja/Documents/Projects/tenant_ids.txt";
        try {
            splitFile(inputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void splitFile(String inputFilePath) throws IOException {
        Path inputPath = Paths.get(inputFilePath);
        String inputFileName = inputPath.getFileName().toString();
        String inputFileDirectory = inputPath.getParent().toString();

        BufferedReader reader = Files.newBufferedReader(inputPath);
        int partNumber = 1;
        int lineCount = 0;
        String line;

        BufferedWriter writer = null;
        try {
            while ((line = reader.readLine()) != null) {
                if (lineCount % MAX_LINES == 0) {
                    if (writer != null) {
                        writer.close();
                    }
                    String outputFileName = inputFileName.replaceFirst("[.][^.]+$", "") + "_part" + partNumber + ".txt";
                    Path outputPath = Paths.get(inputFileDirectory, outputFileName);
                    writer = Files.newBufferedWriter(outputPath);
                    partNumber++;
                }
                writer.write(line);
                // writer.newLine();
                lineCount++;
            }
        } finally {
            if (writer != null) {
                writer.close();
            }
            reader.close();
        }
    }
}
