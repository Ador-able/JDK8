package main.java.Lambda;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class BinaryOperatorTest {
    public static void main(String[] args) {

        //表示对同一类型的两个操作数的操作，产生与操作数相同类型的结果。
        System.out.println(compute(1,2,(integer, integer2) -> integer+integer2));

        Comparator<Integer> comparator=(o1, o2) -> o1-o2;
        System.out.println(BinaryOperator.minBy(comparator).apply(1,2));
    }

    public static int compute(int a, int b, BinaryOperator<Integer> binaryOperator) {
        return binaryOperator.apply(a,b);
    }
}
