import java.util.Arrays;

// Написать метод, который будет эмулировать работу динамического массива 
// (Без исопользования коллекций), протестировать можно при выводе последовательности 
// треугольного числа до n
// Пример
// 1
// 1 3
// 1 3 6
// Tn = (n*(n+1))/2
// 1, 2, 3, 4,  5,  6,   7,  8,  9, 10, 11, 12, 13, 14, 15... ЧИСЛО
// 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, 66, 78, 91, 105,120 ...ТРЕУГОЛЬНОЕ ЧИСЛО

public class HW02Task02 {
    // добавление элемента в массив
    public static int[] addElementToArray(int[] arrayStart, int elementToAdd) {
        int[] arrayEnd = new int[arrayStart.length + 1];

        for (int i = 0; i < arrayStart.length; i++) {
            arrayEnd[i] = arrayStart[i];
        }
        arrayEnd[arrayEnd.length - 1] = elementToAdd;
        return arrayEnd;
    }

    // вывод последовательности треугольного числа n c заданной точкой старта
    public static int[] triangularNumber(int min, int max) {
 
        int size = (max - min) + 1;
        int [] array = new int [0];
        int number = min;
        for (int index = 0; index < size; index++) {
            while (number <= max) {
                int result = (number * (number + 1)) / 2;
                array = addElementToArray(array, result);
                number++;
            }
        }
        return array;
    }
    
    
    public static void main(String[] args) {
        int min = 3;
        int max = 9;
        System.out.println("Последовательность треугольного числа для чисел от " + min + " до " + max);
        System.out.println(Arrays.toString(triangularNumber(min, max)));

    }
}
