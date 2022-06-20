// Написать программу вычисления n-ого треугольного числа.
    // Tn = (n*(n+1))/2
        // 1, 2, 3, 4,  5,  6,   7,  8,  9, 10, 11, 12, 13, 14, 15... ЧИСЛО
        // 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, 66, 78, 91, 105,120 ...ТРЕУГОЛЬТНОЕ ЧИСЛО
import java.util.Random;

public class HW01Task01 { 
    // генерация случайного числа в заданном диапазоне
    public static int getRandomNumber(int min, int max) {
        Random random = new Random();
        int number = random.nextInt(max - min) + min;
        return number;
    }

    // вычисление треугольного числа
    public static int triangularNumber(int number) {
        int result = (number * (number+1)) / 2;
        return result;
    }

    public static void main(String[] args) {
        int number = getRandomNumber(2, 10);
        System.out.println("Число - " + number);
        System.out.println("Треугольное число - " + triangularNumber(number));
    }
    
}
