package main.java.Collector;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;


//并行流与串行流对比
//accumulator:ForkJoinPool.commonPool-worker-1
//accumulator:ForkJoinPool.commonPool-worker-4
//accumulator:main
//accumulator:ForkJoinPool.commonPool-worker-2
//accumulator:ForkJoinPool.commonPool-worker-3
public class Collectortest<T> implements Collector<T, Set<T>, Map<T, T>> {
    @Override
    public Supplier<Set<T>> supplier() {
        System.out.println("supplier执行");
        return HashSet::new;
    }

    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        System.out.println("accumulator执行");
        //return Set::add;
        return (ts, t) -> {
            System.out.println("accumulator:"+Thread.currentThread().getName()+"|set:"+ts);
            ts.add(t);
        };
    }

    @Override
    public BinaryOperator<Set<T>> combiner() {
        System.out.println("combiner执行");
        return (ts, ts2) -> {
            ts.addAll(ts2);
            return ts;
        };
    }

    @Override
    public Function<Set<T>, Map<T, T>> finisher() {
        System.out.println("finisher执行");
        return ts -> {
            Map<T, T> map = new TreeMap<>();
            ts.forEach(t -> map.put(t, t));
            return map;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("characteristics执行");
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.UNORDERED,Characteristics.CONCURRENT));
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hi", "aym", "why", "ignore", "me","know","mean");
        //Map<String, String> collect = list.stream().collect(new Collectortest<>());
        Map<String, String> collect2 = list.parallelStream().collect(new Collectortest<>());
        collect2.forEach((s, s2) -> System.out.println(s+" "+s2));
    }
}
