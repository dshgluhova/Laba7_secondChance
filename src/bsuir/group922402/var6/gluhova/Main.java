package bsuir.group922402.var6.gluhova;

import java.io.FileWriter;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*
Общая постановка. Создать программу с абстрактным базовым классом (Printable) и множественным наследованием,
(либо с иерархией классов) реализовать в нем:
- конструктор,
- деструктор,
- виртуальную функцию просмотра текущего состояния объекта print(),
- friend – функцию Run().
Производные классы (Member, Command) должны содержать переопределенную функцию просмотра состояния объектов,
а также при вводе – выводе данных использовать функции обработки исключительных ситуаций.
Используя стандартные файловые потоки, информацию об объектах вывести в файл.
Для корректной работы с файлом и корректного ввода данных использовать обработку исключительных ситуаций.

6. Информация об участниках спортивных соревнований содержит: наименование страны, название команды,
Ф.И.О. игрока, игровой номер, возраст, рост, вес. Вывести информацию о самой молодой, рослой и легкой команде.
 */
public class Main {

    public static void main(String[] args) {
        List<Command> commandList = new LinkedList<>();
        // ввод данных
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ввод команд!");
            while (true) {
                System.out.println("Введите название команды и страны через запятую или [Enter] для перехода к вводу участников:");
                String sc = scanner.nextLine();
                if (sc==null || sc.isEmpty()) {
                    break;
                }
                String[] ss = sc.split(",");
                if (ss.length<2) {
                    throw new RuntimeException("Нужно вводить название команды и страну, дубина!");
                }
                commandList.add(new Command(ss[0].trim(), ss[1].trim()));
            }
            System.out.println("Ввод участников команд!");
            for (Command command : commandList) {
                while (true) {
                    System.out.println("Введите игрока команды " + command + " в виде \"имя,номер,возраст,рост,вес\" или [Enter] для перехода к следующей команде");
                    String sc = scanner.nextLine();
                    if (sc==null || sc.isEmpty()) {
                        break;
                    }
                    String[] ss = sc.split(",");
                    if (ss.length<5) {
                        throw new RuntimeException("Нужно вводить участника, дубина!");
                    }
                    command.add(new Member(ss[0].trim(), ss[1].trim(), ss[2].trim(), ss[3].trim(), ss[4].trim()));
                }
            }
        } catch (Exception e) {
            System.out.println("!!! Ошибка ввода данных !!!");
            e.printStackTrace();
            return;
        }

        // вывод результатов
        try {
            if (commandList.size()==0) {
                throw new RuntimeException("Нужно было вводить, дубина!");
            }

            // самая молода команда
            commandList.sort(Comparator.comparing(Command::getAverageAge));
            System.out.println("самая молодая команда - " + commandList.get(0));
            commandList.sort(Comparator.comparing(Command::getAverageHeight).reversed());
            System.out.println("самая высокая команда - " + commandList.get(0));
            commandList.sort(Comparator.comparing(Command::getAverageWeight));
            System.out.println("самая легкая команда - " + commandList.get(0));

            // альтернативный способ поиска самой например молодой команды через цикл
            Command theYoungestCommand = commandList.get(0);
            for (Command command : commandList) {
                if (command.getAverageAge() < theYoungestCommand.getAverageAge()) {
                    theYoungestCommand = command;
                }
            }
            System.out.println("самая молодая команда (способ 2) - " + theYoungestCommand);
        } catch (Exception e) {
            System.out.println("!!! Ошибка обработки данных !!!");
            e.printStackTrace();
            return;
        }

        // вывод в файл
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите полное имя файла (путь/имя.txt) для сохранения информации о командах");
            String fileName = scanner.nextLine();
            if (fileName==null || fileName.isEmpty()) {
                throw new RuntimeException("Нужно было вводить файл, дубина!");
            }
            FileWriter nFile = new FileWriter(fileName);
            for (Command command : commandList) {
                nFile.write(command.print());
            }
            nFile.close();
        } catch (Exception e) {
            System.out.println("!!! Ошибка вывода данных в файл !!!");
            e.printStackTrace();
            return;
        }
    }
}
