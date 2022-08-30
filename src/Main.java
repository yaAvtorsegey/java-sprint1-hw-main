import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        StepTracker stepTracker = new StepTracker();// объявляем класс


            Scanner scanner = new Scanner(System.in);
            StepTracker.printMenu(); //перенес метод в класс СтепТрекер
            int userInput = scanner.nextInt();

            while (userInput != 0){
            switch (userInput) {
                case 1:
                    System.out.println("Выберите месяц: 1 - ЯНВ, 2 - ФЕВ, 3 - МАР, 4 - АПР, 5 - МАЙ, 6 - ИИЮ, 7 - ИЮЛ, 8 - АВГ, 9 - СЕН, 10 - ОКТ, 11 - НОЯ, 12 - ДЕК");
                    int month = scanner.nextInt(); // сохранили в переменную month месяц,который выбрал пользователь
                    System.out.println("Введите номер дня от 1 до 30:");
                    int day = scanner.nextInt(); // сохранили в переменную day день,который выбрал пользователь

                    System.out.println("Введите количество пройденных шагов в день:");
                    int steps = scanner.nextInt(); //// сохранили в переменную steps колличество шагов,которые ввел пользователь

                    int daySteps = StepTracker.saveSteps(month, day, steps);

                    System.out.println("Значение сохранено");

                    break;

                case 2:
                    System.out.println("Введите номер месяца, чтобы получить статистику");
                    //Сюда будем выводить статистику за месяц из метода
                    month = scanner.nextInt();
                    stepTracker.showStats(month);      //Вызов этих методов и отправка им значения тоже ошибкой считается?

                    break;

                case 3:

                    System.out.println("Введите цель по количеству шагов в день:");
                    StepTracker.needSteps = scanner.nextInt();
                    stepTracker.changeNeedSteps(StepTracker.needSteps);
                    break;

                case 0:
                    System.out.println("Программа завершена");
                    break;


                default:
                    System.out.println("Извините, такой команды пока нет.");
            } StepTracker.printMenu();
                userInput = scanner.nextInt();
            }


        }
    }

// по поводу swich надеюсь сделал правильно. погуглил, как понял, так и сделал. вроде не сложно, по крайней мере код работает))
// и не понимаю почему у меня case 0 просто заканчивает программу, а не выводит sout?