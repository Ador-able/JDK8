package main.java.Collector;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class MySetCollector<T> implements Collector<T,Set<T>,Set<T>> {
    @Override
    public Supplier<Set<T>> supplier() {
        System.out.println("执行supplier");
        return HashSet::new;
    }

    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        System.out.println("执行accumulator");
        //return (ts, t) -> ts.add(t);
        return Set::add;
    }

    @Override
    public BinaryOperator<Set<T>> combiner() {
        System.out.println("执行combiner");
        return (ts, ts2) -> {ts.addAll(ts2); return ts;};
    }

    @Override
    public Function<Set<T>, Set<T>> finisher() {
        System.out.println("执行finisher");
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("执行characteristics");
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH,Characteristics.UNORDERED));
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hi", "aym","aym", "why", "ignore", "me");

        Set<String> collect = list.stream().collect(new MySetCollector<>());

        System.out.println(collect);
    }
}
