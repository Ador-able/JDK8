package main.java.Lambda;

import java.util.function.Supplier;

public class SupplierTest {
    public static void main(String[] args) {
        //可用作工厂方法
        Supplier<String> supplier = () -> "不接受参数，返回一个结果";
        System.out.println(supplier.get());

        Supplier<Person> personSupplier = () -> new Person("AYM", "Girl");
        System.out.println(personSupplier.get());

        //此写法不能调用带参构造方法
        Supplier<Person> personSupplier1=Person::new;
        System.out.println(personSupplier1.get());
    }
}
