package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int n = 1000;
        BigDecimal un = calculateUn(n);
        System.out.println("un = " + un);
    }

    //использование BigDecimal необходимо для сохранения точности при работе с большими числами
    //по сути формула для задачи - дробь, где числитель сумма факториалов от 1 до n
    //знаменатель n!
    public static BigDecimal calculateUn(int n) {
        BigDecimal sum = BigDecimal.ZERO;//переменная для числителя
        //так как факториалы в знаменателе факториалы чисел подряд и их можно записать как
        //x! = x * (x-1)! а x-1 тоже самое и так до одного. Следовательно можно этот факториал не высчитывать каждый раз
        //а просто "наслаивать" с каждой итерацией
        BigDecimal factorial = BigDecimal.ONE;
        for (int i = 1; i <= n; i++) {
            factorial = factorial.multiply(BigDecimal.valueOf(i));
            sum = sum.add(factorial);
        }
        BigDecimal result = sum.divide(factorial, 6, RoundingMode.HALF_UP);
        return result;
    }
}
