package com.sunchenglong.javalearn;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Chenglong Sun on 2016/10/10.
 */
public class LamdaPractice {


    public static void originFun() {
        List<BigDecimal> prices = Arrays.asList(
                new BigDecimal("10"), new BigDecimal("30"), new BigDecimal("17"),
                new BigDecimal("20"), new BigDecimal("15"), new BigDecimal("18"),
                new BigDecimal("45"), new BigDecimal("12"));
        BigDecimal totalOfDiscountedPrices = BigDecimal.ZERO;
        for (BigDecimal price : prices) {
            if (price.compareTo(BigDecimal.valueOf(20)) > 0)
                totalOfDiscountedPrices = totalOfDiscountedPrices.add(price.multiply(BigDecimal.valueOf(0.9)));
        }
        System.out.println("Total of discounted prices: " + totalOfDiscountedPrices);
    }

    public static void lamdaFun() {
        List<BigDecimal> prices = Arrays.asList(
                new BigDecimal("10"), new BigDecimal("30"), new BigDecimal("17"),
                new BigDecimal("20"), new BigDecimal("15"), new BigDecimal("18"),
                new BigDecimal("45"), new BigDecimal("12"));
        BigDecimal totalOfDiscountedPrices = prices.stream()
                .filter(price -> price.compareTo(BigDecimal.valueOf(20)) > 0)
                .map(price -> price.multiply(BigDecimal.valueOf(0.9)))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Total of discounted prices: " + totalOfDiscountedPrices);
    }

    public static void test1() {
        List<String> list = Arrays.asList("first", "second", "third", "fourth", "fifth");
        list.forEach(System.out::println);
        list.forEach((str) -> System.out.println(str + " lamda"));
    }

    public static void main(String[] args) {
        originFun();
        lamdaFun();
        test1();
    }
}
