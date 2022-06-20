// Написать программу возрващающее число, которе без остатка делится 
// на сумма цифр этого числа.

import java.util.Scanner;

public class HW01Task02 {
    // считывания данных из терминала
    public static int ScannerNumber(){
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите число: ");
        // // нужно доработать проверку на дурака при вводе - пока не работает
        // boolean flag = iScanner.hasNextInt();
        // if (flag == false) System.out.println("Число введено некорректно, повторите ввод ");
        // else int number = iScanner.nextInt();
        int number = iScanner.nextInt();
        iScanner.close(); 
        return number;
    } 
  
    // сумма цифр числа
    public static int sumOfDigits(int number){
        int sum = 0;
        while(number != 0){
            sum += (number % 10);
            number = number /10;
        } 
        System.out.println("Сумма цифр числа - " + sum); 
        return sum;
    }
    
    // проверка на деление без остатка
    public static void divisionTest(){
        int number = ScannerNumber();
        int sum = sumOfDigits(number);
        if (number  % sum == 0) System.out.println("Число "  + number + " делится без остатка на сумму своих чиел " + sum);
        else System.out.println("Число " + number + " НЕ делится без остатка на сумму своих чиел " + sum);
    
    }
   
    public static void main(String[] args) {
        divisionTest();
    }
}
