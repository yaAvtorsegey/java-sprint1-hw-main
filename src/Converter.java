public class Converter {

    private static StepTracker.MonthData monthToDatum;

    public static double calcDistanceKm(){ //расчитываем шаги в км
        double distanceKm =0;
        for (int i = 0; i <30 ; i++) {
            
            int steps = monthToDatum.getSteps(i);
            distanceKm = (steps * 0.75) / 100;
        }
        return distanceKm;
    }

    public static double calcBurnedKiloCalories(){ // переводим шаги в килокалории
        double burnedKiloCalories = 0;
        for (int i = 0; i <30; i++) {
            int steps = monthToDatum.getSteps(i);
            burnedKiloCalories += (steps * 50) / 1000;
        }
        return  burnedKiloCalories;
    }



}
