import colorconsole.ColorConsole;

import java.awt.*;
import java.util.ArrayList;

public class SearchInFile {
    private static String searchWord = "test";

    public static String getSearchWord() {
        return searchWord;
    }

    public static void setSearchWord(String searchWord) {
        SearchInFile.searchWord = searchWord;
    }

    //Метод проверяет, содержится ли подстрока в строке без учета регистра
    public static boolean containsIgnoreCase(String str, String subString) {
        return str.toLowerCase().contains(subString.toLowerCase());
    }

    //Метод осуществляет поиск в файле построчно, возвращает массив строк с совпадениями
    public static ArrayList<String> searchInFile(String content) {
        String[] lines = content.split("\\n+");
        ArrayList<String> arrstr = new ArrayList<>();

        for (int i = 0; i < lines.length; i++) {
            if (containsIgnoreCase(lines[i], searchWord)) {
                ColorConsole.colorSystemOut("Найдено слово ", Color.GREEN, false, false);
                ColorConsole.colorSystemOut(searchWord, Color.MAGENTA, false, false);
                ColorConsole.colorSystemOut(" в "+ (i+1) + "-ой строке ", Color.GREEN, false, false);
                ColorConsole.colorSystemOut(lines[i] + "\n", Color.CYAN, false, false);
                arrstr.add("Найдено слово " + searchWord + " в "+ (i+1) + "-ой строке " + lines[i]);
            }
        }
        return arrstr;
    }
}
