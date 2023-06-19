import java.util.Scanner;

public class lesson2 {
    public static void main(String[] args) {
        System.out.println(enterFloat());
    }

    public static float enterFloat () {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Введите дробное число: ");
                float digit = scanner.nextFloat();
                return digit;
            } catch (Exception e) {
                System.out.println("Нельзя вводить строку!");
                scanner.nextLine();
                e = null;
            }
        }
    }
}
