package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var primes = new EratosthenesSieveRealization().сountPrimes(1000);//выводим 1000 простых чисел через решето Эратосфена
        System.out.println(primes);

//        System.out.println(getPrimes(100));//выводим 100 перввых простых чисел
    }

    //поиск простых чисел методом перебора делителей
    public static List<Integer> getPrimes(int count){//принимает на вход кол-во простых чисел которые мы хотим сгенерировать
        List<Integer> primes =new ArrayList<>();//результирующая коллекция
        if (count > 0) {
            primes.add(2);//если простых чисел >0,то сразу добавляе число 2
            for (int i =3;primes.size()< count; i= i+2) {//начинаем с 3 и берем каждое нечетное число и его проверяем
                if (Main.isPrime(i,primes)) {//вызываем метод и передаем в него текущее число и числа которые мы уже нашли
                    primes.add(i);//и если метод возвращает true, то добавляем его в коллекцию primes
                }
            }
        }
        return primes;
    }
    private static boolean isPrime(int number,List<Integer> primes) {// передаем и числа которые мы уже нашли
        double sqrt = Math.sqrt(number);//вычисляем квадратный корень из number
        for (int n : primes) {//проходимся по всем простым числам котторые мы уже нашли
            if (n > sqrt){//если число оказалось больше корня
                return  true;//то число оказалось простым
            }
            if (number % n == 0){//если разделилось без остатка, то число не является простым и число n является делителем
                return false;
            }
        }
        return true;
    }
}