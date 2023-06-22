package lesson3;

import org.w3c.dom.ls.LSOutput;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class lesson3 {
    public static void main(String[] args) {
        String[] firstUser = userData();
        boolean check = dataCheck(firstUser);
        if (check) {
            Path path = Paths.get("output.txt");
            String contents = new String();
            for (String i: firstUser) {
                contents = contents + i + " ";
            }
            contents = contents + "\n";
            try {Files.writeString(path, contents, StandardCharsets.UTF_8);
            } catch (IOException ex) {
                System.out.println("Не удалось сохранить файл");
            }
        }
    }

    public static String[] userData () {
        String[] userData = new String[4];
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ФИО: ");
        userData[0] = scanner.nextLine();
        System.out.println();
        System.out.print("Введите дату рождения: ");
        userData[1] = scanner.nextLine();
        System.out.println();
        System.out.print("Введите телефон: ");
        userData[2] = scanner.nextLine();
        System.out.println();
        System.out.print("Введите пол: ");
        userData[3] = scanner.nextLine();
        System.out.println();
        return userData;
    }

    public static boolean dataCheck (String[] userData) {
        int checkCount = 0;
        int spaceCount = 0;
        for (char c : userData[0].toCharArray()) {
            if (c == ' ') {
                spaceCount++;
            }
        }
        if (spaceCount != 2) {
            checkCount++;
            throw new RuntimeException("Не корректно введены ФИО.");
        }
        int pointCount = 0;
        for (char c : userData[1].toCharArray()) {
            if (c == '.') {
                pointCount++;
            }
        }
        if (pointCount != 2) {
            checkCount++;
            throw new RuntimeException("Не корректно введена дата рождения.");
        }
        int numberCount = 0;
        try {
            String[] number = userData[2].split("");
            for (String i: number) {
                int n = Integer.parseInt(i);
            }
            if (number.length != 11) {
                checkCount++;
                throw new RuntimeException("Не корректно введен номер телефона, должно быть 11 цифр.");
            }
        }catch (Exception e) {
            System.out.println("В телефоне введены не только числа");
            checkCount++;
        }

        if (!userData[3].equalsIgnoreCase("f") && !userData[3].equalsIgnoreCase("m")) {
            checkCount++;
            throw new RuntimeException("Не корректно введен пол.");
        }
        if (checkCount == 0) {
            return true;
        } else {
            return false;
        }
    }

}
