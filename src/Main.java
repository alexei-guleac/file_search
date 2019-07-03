import colorconsole.ColorConsole;

import java.awt.*;
import java.util.*;

import static runtimer.RunTimer.*;

public class Main {
    public static void main(String[] args) {

        final String DIR = "E:\\#Program\\APK Studio\\Google_Play_apps.apk.src\\Other\\Fishing Clash Catching Fish Game Bass Hunting 3D_v1.0.62_apkpure.com.apk-decompiled";           //каталог для проверки

        ColorConsole.colorSystemOut("Каталог программы: " + System.getProperty("user.dir") + "\n", Color.YELLOW, true, false);

        //вывести кол-во файлов в папке
        initTimeStart();
        FilesFromFilelistInput.showNumFilesinDir(DIR);
        initTimeEnd();
        showRunTime();

        //поиск ключевого слова в файлах *.java
        //поиск ключевого слова в содержимом файлов
        ColorConsole.colorSystemOut("\nТекущее ключевое слово для поиска: " + SearchInFile.getSearchWord() + "\n", Color.MAGENTA, true, false);
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ключевое слово для поиска:");
        String searchWord = sc.nextLine();
        ColorConsole.colorSystemOut("\nТекущее ключевое слово для поиска: " + SearchInFile.getSearchWord() + "\n", Color.MAGENTA, true, false);
        SearchInFile.setSearchWord(searchWord);

        initTimeStart();
        Map<String, ArrayList<String>> map = new HashMap<>();
        FilesFromFilelistInput.checkJavaFilesinDir(DIR, map);
        ColorConsole.colorSystemOut("\nРезультаты по ключевому слову " + SearchInFile.getSearchWord() + "\n", Color.MAGENTA, true, false);
        System.out.println("Найдены совпадения в " + map.size() + " файлах");
        int total = 0;
        for (ArrayList<String> l : map.values()) {
            total += l.size();
        }
        System.out.println("Всего " + total + " совпадения(ий)\n");

        printMapValues(map);

        initTimeEnd();
        showRunTime();
    }

    public static void printMapValues(Map<String, ArrayList<String>> map) {
        for (Map.Entry<String, ArrayList<String>> pair : map.entrySet()) {
            String fileID = pair.getKey();
            ArrayList<String> results = pair.getValue();
            ColorConsole.colorSystemOut( fileID + "\n", Color.GREEN, true, false);
            for (int i = 0; i < results.size(); i++)
                System.out.println("\t" + results.get(i));
        }
    }
}
