import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// У вас есть отсортированный массив (Можете сами сгенерировать и использовать 
// любой удобный вам алгоритм сортировки (кроме пузырька)), нужно используя 
// минимальное колличество попыток найти загаданное число (Алгоритм бинарного поиска )


    // ВЫВОД
        // Стартовый массив   [928, 209, 787, 800, 618, 517, 856, 520, 141, 766]
        // Отсортированный массив   [141, 209, 520, 517, 618, 766, 787, 800, 856, 928]
        // Введите число для поиска: 
        // 787
        // Искомый элемент 787 имеет индекс 6

public class HW02Task01 {
    // генерация случайного числа в заданном диапазоне
    public static int getRandomNumber(int min, int max) {
        Random random = new Random();
        int number = random.nextInt(max - min) + min;
        return number;
    }

    // заполнение массива случайными числами в заданном диапозоне
    public static int [] fillingArrayRandomNumbers(int length, int min, int max){
        int[] array = new int [length]; 
        for (int index = 0; index < array.length; index++) {
            array[index] = getRandomNumber(min, max);
        }
        return array;
    }

    // быстрая сортировка
    public static void quickSort(int[] array, int start, int end) {
        if (array.length == 0 || start >= end) return;
        
        int middle = start + (end - start) / 2;
        int supportElement = array[middle];

        int i = start;
        int j = end;

        while (i <= j) {
            while (array[i] < supportElement) i++;
            while (array[j] > supportElement) j--;
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if (start < i) quickSort(array, start, j);
        if (j > start) quickSort(array, i, end);
    }

    // считывания числовых данных из терминала
    public static int ScannerNumber() {
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите число для поиска: ");
        int number = iScanner.nextInt();
        iScanner.close();
        return number;
    }

    // бинарный поиск
    public static int binarySearch(int arr[], int elementToSearch) {
        int firstIndex = 0;
        int lastIndex = arr.length - 1;
        while (firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            if (arr[middleIndex] == elementToSearch) return middleIndex;
            else if (arr[middleIndex] < elementToSearch) firstIndex = middleIndex + 1;
            else if (arr[middleIndex] > elementToSearch) lastIndex = middleIndex - 1;
        }
        return lastIndex;
    }

    public static void main(String[] args) {
        int[] arrayStart = fillingArrayRandomNumbers(10, 2, 999);
        System.out.println("Стартовый массив   " + Arrays.toString(arrayStart)); 
        
        int start = 0;
        int end = arrayStart.length - 1; 
        quickSort(arrayStart, start, end);
        System.out.println("Отсортированный массив   " + Arrays.toString(arrayStart)); 
        
        int elementToSearch = ScannerNumber();
        int result = binarySearch(arrayStart, elementToSearch);
        if (result >= 0) System.out.println("Искомый элемент " +  elementToSearch + " имеет индекс " + result);
        else System.out.println("Искомый элемент не найден"); 
    }
}
