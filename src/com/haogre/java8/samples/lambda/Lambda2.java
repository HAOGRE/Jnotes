package com.haogre.java8.samples.lambda;

import java.util.Optional;

/**
 * @author Benjamin Winterberg
 */
public class Lambda2 {

    @FunctionalInterface
    public static interface Converter<F, T> {
        T convert(F from);
    }

    interface PersonFactory<P extends Person> {
        P create(String firstName, String lastName);
    }

    static class Something {
        String startsWith(String s) {
            return String.valueOf(s.charAt(0));
        }
    }

//    public static void main(String[] args) {
//        Converter<String, Integer> integerConverter1 = (from) -> Integer.valueOf(from);
//        Integer converted1 = integerConverter1.convert("123");
//        System.out.println(converted1);   // result: 123
//
//
//        // method reference
//
//        Converter<String, Integer> integerConverter2 = Integer::valueOf;
//        Integer converted2 = integerConverter2.convert("123");
//        System.out.println(converted2);   // result: 123
//
//
//        Something something = new Something();
//
//        Converter<String, String> stringConverter = something::startsWith;
//        String converted3 = stringConverter.convert("Java");
//        System.out.println(converted3);    // result J
//
//        // constructor reference
//
//        PersonFactory<Person> personFactory = Person::new;
//        Person person = personFactory.create("Peter", "Parker");
//
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < 10; ++i) {
//            list.add(i);
//        }
//        list.forEach(System.out::println);
//        list.forEach(i -> System.out.println(i));
//        list.forEach(System.out::print);

}

class Test {
    public static void main(String[] args) {
        final String text = "Hallo world!";
        Optional.ofNullable(text)//显示创建一个Optional壳
                .map(Test::print)
                .map(Test::print)
                .ifPresent(System.out::println);

        Optional.ofNullable(text)
                .map(s -> {
                    System.out.println(s);
                    return s.substring(6);
                })
                .map(s -> null)//返回 null
                .ifPresent(System.out::println);
    }

    // 打印并截取str[5]之后的字符串
    private static String print(String str) {
        System.out.println(str);
        return str.substring(6);
    }
}
//}
