package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EratosthenesSieveRealization {//"поиск простых чисел методом решета Эратосфена"
    public List<Integer> сountPrimes(int n){//n-верхняя граница диапозона поиска простых чисел
        var sieve = new boolean[n];//создаем массив sieve с типом boolean размером n
        Arrays.fill(sieve,true);//принимает на вход массив sieve и устанавливает все его элементы в true, тк полагаем что все элементы являются кандидатами в простые числа
        sieve[0] = false;//вычеркиваем 0 и 1 тк они не являются простыми числами по определению
        sieve[1] = false;
        for(var i = 2; i < sieve.length; i++){//начинаем цикл с двух до тех пор пока i не достигнет вехнего диапозона
            if (sieve[i]) {//если в решете число под индексом i помечено как простое
                for (var j = 2; i*j < sieve.length; j++){//то начиная с него запускаем вложенный цикл до тех пор, пока i*j не будет меньше размеров нашего решета
                    sieve[i*j] = false;//признак того, что это не простое число
                }
            }
        }
        var primes = new ArrayList<Integer>();//после прохождения внешнего цикла заводим новый список в котором будут храниться простые числа
        for (var i = 2;i<sieve.length;i++){//еще раз проходимся по решету
            if (sieve[i]) {//если он помечен как true(простое число)
                primes.add(i);//добавляем индекс элемента в массив
            }
        }
        return primes;//возвращаем массив с найденными простыми числами
    }
}
