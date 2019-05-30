package main.java.Stream;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

//并行流
public class ParallelStream {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>(5000000);
        for (int i = 0; i < 5000000; i++) {
            list.add(UUID.randomUUID().toString());
        }
        long startTime=System.nanoTime();   //获取开始时间

        list.stream().sorted().count();

        long endTime=System.nanoTime(); //获取结束时间

        System.out.println("程序运行时间： "+ TimeUnit.NANOSECONDS.toMillis(endTime-startTime)+"ms");

        startTime=System.nanoTime();   //获取开始时间

        list.parallelStream().sorted().count();

        endTime=System.nanoTime(); //获取结束时间

        System.out.println("程序运行时间： "+ TimeUnit.NANOSECONDS.toMillis(endTime-startTime)+"ms");

        //程序运行时间： 7412ms
        //程序运行时间： 2088ms
    }


}
