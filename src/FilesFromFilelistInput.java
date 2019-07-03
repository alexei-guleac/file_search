import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class FilesFromFilelistInput {

    static int countFiles;

    //Метод выводит кол-во файлов в папке
    public static void showNumFilesinDir(String directoryName) {
        countFilesinDir(directoryName);
        System.out.println("\nВ папке " + directoryName + " " + countFiles + " файла(ов)\n");
        countFiles = 0;
    }

    //Метод считает количество файлов в папке (учитывая папки)
    public static void countFilesinDir(String directoryName) {
        File directory = new File(directoryName);
        countFiles += directory.listFiles().length;

        // get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList) {
            if (file.isDirectory()) {
                countFilesinDir(file.getAbsolutePath());
            }
        }
    }

    //метод проходит поиском по содержимому всех *.java файлов в указаноой папке и сохраняет
    //результаты поиска в Map<Имя_файла, строки_с_совпадениями>
    public static void checkJavaFilesinDir(String directoryName, Map<String, ArrayList<String>> map) {
        File directory = new File(directoryName);
        String content;
        String extension;

        // get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList) {
            String fileName = file.getName();
            String filepath = file.getAbsolutePath();

            if (file.isFile()) {
                extension = FilenameUtils.getExtension(fileName);
                if (extension.equals("java")) {
                    content = FileInput.readFile(filepath, StandardCharsets.UTF_8);
                    System.out.println("Файл: " + fileName);
                    //ColorConsole.colorSystemOut(content + "\n\n", Color.CYAN, false, false);
                    //String found = SearchInFile.searchInFile(content);
                    ArrayList<String> strarr = SearchInFile.searchInFile(content);
                    if (!strarr.isEmpty()) {
                        String fileID = "Файл: " + fileName + " -- " + filepath;
                        map.put(fileID, strarr);
                    }
                }
            } else if (file.isDirectory()) {
                checkJavaFilesinDir(filepath, map);
            }
        }
    }
}