
public class StepTracker {



    static MonthData[] monthToData; //объявили массив
    static int needSteps = 10000; // переменная цельшагов,которая по умолчанию равна 10000


    public StepTracker() {    //создаем конструктор
        monthToData = new MonthData[12]; //создали массив для месяцев
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество пройденных шагов:");
        System.out.println("2 - Получить статистику за месяц:");
        System.out.println("3 - Ввести цель по количеству шагов в день:");
        System.out.println("0 - Выход");

    }


    public static class MonthData {  //создали вложенный класс
        static int[] daySteps = new int[30]; //объявили и инициализоравли новый массив для дней

        void setSteps(int day, int steps) { // создали 1  метод,который сохранет шаги в опредленный день
            daySteps[day - 1] = steps;
        }

        public static int getSteps(int day) { // создали 2 метод, который выдает шаги за определнный день
            return daySteps[day];
        }

        private int getStepsForDay(MonthData monthToDatum, int day) {  //метод возращает кол-шагов в опр.день

            int steps = daySteps[day];
            return steps;
        }

        private static int getSum() { //всего шагов за месяц
            int sum = 0;
            int steps;
            for (int i = 0; i < 30; i++) {
                steps = getSteps(i);
                sum += steps;
            }
            return sum;
        }

        int findMaxSteps() { // максимальное количество шагов за месяц
            int sum = 0;
            int maxSteps = 0;
            for (int i = 0; i < 30; i++) {


                if (daySteps[i] > maxSteps) {
                    maxSteps = daySteps[i];
                }
            }
            return maxSteps;
        }
    }

    static int saveSteps(int month, int day, int steps) {   //сохраняем кол-во шагов в опр.день. в опр.месяц
        MonthData monthToDatum = monthToData[month-1];
        monthToDatum.setSteps(day, steps);
        return month;
    }

    void showStats(int month) { // метод показывает статистику шагов в день
        MonthData monthToDatum = monthToData[month-1];
        System.out.println("Вывод количества пройденных шагов по дням:");

        for (int i = 0; i < 30; i++) {
            System.out.println(" " + (i+1) + "день:" + monthToDatum.getStepsForDay(monthToDatum, i) + " шагов;");
        }




            int sum = MonthData.getSum();

            System.out.println("Общее количество шагов за месяц: " + sum + ";");
            System.out.println("Среднее количство шагов: " + getMean(monthToDatum) + ";");
            System.out.println("Максимальное значение пройденных шагов: " + monthToDatum.findMaxSteps() + ";");
            System.out.println("Пройденная дистанция в километрах: " + Converter.calcDistanceKm() + ";");
            System.out.println("Вы потратили каллорий: " + Converter.calcBurnedKiloCalories() + ";");
            System.out.println("Количество дней в серии, когда вы прошли больше,чем " + needSteps + " шагов " + getSeriesLenght(monthToDatum));
        }

        public void changeNeedSteps(int needSteps) {
           int needSteps1 = needSteps;

            if (needSteps < 0) {
                System.out.println("Вы ввели не правильное значение");
            } else {
                System.out.println("Цель сохранена");
            }
        }


        int getSeriesLenght(MonthData month) {
            int maxLenght = 0;
            int curLenght = 0;
            for (int i = 0; i < month.daySteps.length; i++) {
                int steps = month.getSteps(i);
                if (steps > needSteps) {
                    curLenght++;
                } else {
                    if (curLenght > maxLenght) {
                        maxLenght = curLenght;
                    }
                    curLenght = 0;
                }
            }
            return maxLenght;
        }

        private int getMean(MonthData monthToDatum) { //ср.количество шагов за месяц
            int mean = MonthData.getSum() / 30;
            return mean;
        }

    }


//Вопрос по методам почему среда разработки мне какой-то метод исправляла на приватный, какой-то на публичный?
// я нажимал конечно исправить, но не понимал почему так
// Почему , когда писал код название, например, массива подчеркивалось волнистой линией, я кликакл исправить, шрифт менялся на курсив и ошибка проходила. это что?
// По названиям методов понял, в выходные исправлю на другие названия! А остальное всё поменял вроде)