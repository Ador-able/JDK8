package main.java.Lambda;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionTest {
    public static void main(String[] args) {
        FunctionTest test=new FunctionTest();
        System.out.println(test.compute(1,integer -> 2* integer));
        System.out.println(test.compute(1,integer -> 2+ integer));

        System.out.println(test.computeOne(2,integer -> integer*3,integer -> integer*integer));
        System.out.println(test.computeTwo(2,integer -> integer*3,integer -> integer*integer));

        System.out.println(test.computeThree(2,3,(integer, integer2) -> integer+integer2));
        System.out.println(test.computeFour(2,3,(integer, integer2) -> integer+integer2,integer -> integer*integer));
    }

    public int compute(int a, Function<Integer, Integer> function) {
        int result = function.apply(a);
        return result;
    }
    public int computeOne(int a, Function<Integer, Integer> function1,Function<Integer, Integer> function2) {
       return function1.compose(function2).apply(a);
    }
    public int computeTwo(int a, Function<Integer, Integer> function1,Function<Integer, Integer> function2) {
        return function1.andThen(function2).apply(a);
    }
    public int computeThree(int a, int b, BiFunction<Integer,Integer,Integer> biFunction) {
        return biFunction.apply(a, b);
    }

    public int computeFour(int a, int b, BiFunction<Integer,Integer,Integer> biFunctionOne,Function<Integer,Integer> function) {
        return biFunctionOne.andThen(function).apply(a, b);
    }
}
