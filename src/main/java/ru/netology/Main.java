package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Logger
 */
public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        Random random = new Random();

        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");

        while (true) {
            try {
                System.out.println("Введите размер списка: ");
                int sizeList = Integer.parseInt(scanner.readLine());

                System.out.println("Введите верхнюю границу для значений: ");
                int maxValue = Integer.parseInt(scanner.readLine());

                logger.log("Создаём и наполняем список");
                List<Integer> integerList = getIntegerList(random, sizeList, maxValue);

                System.out.print("Вот случайный список: ");
                printList(integerList);

                logger.log("Просим пользователя ввести входные данные для фильтрации");
                System.out.println("Введите порог для фильтра:");
                int filterThreshold = Integer.parseInt(scanner.readLine());

                logger.log("Запускаем фильтрацию");
                Filter filter = new Filter(filterThreshold);
                List<Integer> filteredList = filter.filterOut(integerList);

                logger.log("Прошло фильтр " +
                        (integerList.size() - filteredList.size()) +
                        " элемента из " +
                        integerList.size());

                logger.log("Выводим результат на экран");
                System.out.print("Отфильтрованный список: ");
                printList(filteredList);

                logger.log("Завершаем программу");
                break;

            } catch (NumberFormatException | IOException e) {
                logger.log("Не верный ввод пользователя");
                System.out.println("Не верный ввод. Попробуйте снова");
//                e.printStackTrace();
            }
        }
    }

    private static List<Integer> getIntegerList(Random random, int sizeList, int maxValue) {
        List<Integer> integerList = new ArrayList<>(sizeList);
        for (int i = 0; i < sizeList; i++) {
            integerList.add(random.nextInt(maxValue));
        }
        return integerList;
    }

    private static void printList(List<Integer> integerList) {
        for (Integer integer : integerList) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }
}
