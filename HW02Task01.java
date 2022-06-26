// У вас есть отсортированный массив (Можете сами сгенерировать и использовать 
// любой удобный вам алгоритм сортировки (кроме пузырька)), нужно используя 
// минимальное колличество попыток найти загаданное число (Алгоритм бинарного поиска )

import java.util.Arrays;

public class HW02Task01 {
    // быстрая сортировка
    public static void quickSort(int[] array, int start, int end) {
        if (array.length == 0 || start >= end)
            return;
        
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
        int[] arrayStart = {344, 67, 90, 4, 78, 2, 0, 56, 789, 123}; 
        int elementToSearch = 123;
        System.out.println("Стартовый массив   " + Arrays.toString(arrayStart)); 
        
        int start = 0;
        int end = arrayStart.length - 1; 
        quickSort(arrayStart, start, end);
        System.out.println("Итоговый массив   " + Arrays.toString(arrayStart)); 

        System.out.println("Искомый элемент " +  elementToSearch + " имеет индекс " + binarySearch(arrayStart, elementToSearch));
    }
}
