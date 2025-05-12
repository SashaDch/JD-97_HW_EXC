import ru.netology.passwords.PasswordChecker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PasswordChecker passwordChecker = new PasswordChecker();
        String userInput;

        while (true) {
            System.out.print("\nВведите мин. длину пароля: ");
            userInput = scanner.nextLine();
            if (userInput.equals("end")) {
                System.out.println("\nПрограмма завершена");
                return;
            }
            try {
                passwordChecker.setMinLength(Integer.parseInt(userInput));
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат числа: " + e);
                continue;
            } catch (IllegalArgumentException e) {
                System.out.println("Неверный аргумент: " + e);
                continue;
            }
            break;
        }

        while (true) {
            System.out.print("\nВведите макс. допустимое количество повторений символа подряд: ");
            userInput = scanner.nextLine();
            if (userInput.equals("end")) {
                System.out.println("\nПрограмма завершена");
                return;
            }
            try {
                passwordChecker.setMaxRepeats(Integer.parseInt(userInput));
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат числа: " + e);
                continue;
            } catch (IllegalArgumentException e) {
                System.out.println("Неверный аргумент: " + e);
                continue;
            }
            break;
        }

        while (true) {
            System.out.print("\nВведите пароль или end: ");
            userInput = scanner.nextLine();
            if (userInput.equals("end")) {
                System.out.println("\nПрограмма завершена");
                return;
            }
            try {
                if (passwordChecker.verify(userInput)) {
                    System.out.println("Подходит!");
                } else {
                    System.out.println("Не подходит!");
                }
            } catch (IllegalStateException e) {
                System.out.println("Ошибка состояния: " + e);
                return;
            }
        }
    }
}
