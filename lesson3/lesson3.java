package lesson3;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class lesson3 {
    public static void main(String[] args) {
        String[] firstUser = userData();
        dataCheck(firstUser);
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

    public static void dataCheck (String[] userData) {
        int spaceCount = 0;
        for (char c : userData[0].toCharArray()) {
            if (c == ' ') {
                spaceCount++;
            }
        }
        if (spaceCount != 2) {
            throw new RuntimeException("Не корректно введены ФИО.");
        }
        int pointCount = 0;
        for (char c : userData[1].toCharArray()) {
            if (c == '.') {
                pointCount++;
            }
        }
        if (pointCount != 2) {
            throw new RuntimeException("Не корректно введена дата рождения.");
        }
        int numberCount = 0;
        try {
            Integer number = Integer.parseInt(userData[2]);
            while (number > 0) {
                numberCount++;
                number = number/10;
            }
            if (numberCount != 11) {
                throw new RuntimeException("Не корректно введен номер телефона, должно быть 11 цифр.");
            }
        }catch (Exception e) {
            System.out.println("В телефоне введены не только числа");
        }

        if (!userData[3].equalsIgnoreCase("f") || !userData[3].equalsIgnoreCase("m")) {
            throw new RuntimeException("Не корректно введен пол.");
        }
    }

}
