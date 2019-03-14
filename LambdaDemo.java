package utils.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.common.collect.Lists;

public class LambdaDemo {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                System.out.println("hello");
            }
        });
        thread.start();

        Thread lambdaThread = new Thread(() -> System.out.println("Hello, lambda."));
        lambdaThread.start();

        List<String> list = Arrays.asList(new String[] { "b", "c", "a" });
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println(list);
        Collections.sort(list, (o1, o2) -> o1.compareTo(o2));
        System.out.println(list);

        List<String> proNames = Arrays.asList(new String[] { "NI", "HAO", "Lambda" });
        List<String> lowercaseNames = new ArrayList<>();
        for (String string : proNames) {
            lowercaseNames.add(string.toLowerCase());
        }
        System.out.println(lowercaseNames);
        List<String> uppercaseNames = lowercaseNames.stream().map(a -> {
            return a.toUpperCase();
        }).collect(Collectors.toList());
        System.out.println(uppercaseNames);
        lowercaseNames = uppercaseNames.stream().map(String::toLowerCase).collect(Collectors.toList());
        System.out.println(lowercaseNames);

        List<Integer> integers = Arrays.asList(new Integer[] { 1, 2, 3 });
        List<Integer> collect = integers.stream().map(a -> {
            return a;
        }).collect(Collectors.toList());
        System.out.println(collect);

        String waibu = "lambda :";
        List<String> proStrs = Arrays.asList(new String[] { "Ni", "Hao", "Lambda" });
        List<String> execStrs = proStrs.stream().map(chuandi -> {
            Long zidingyi = System.currentTimeMillis();
            return waibu + chuandi + " -----:" + zidingyi;
        }).collect(Collectors.toList());
        execStrs.forEach(System.out::println);
        
        List<Integer> nums = Lists.newArrayList(1,null,3,4,null,6);
        long count = nums.stream().filter(num -> num != null).count();
        System.out.println(count);
        
        Stream<Double> generate = Stream.generate(new Supplier<Double>() {
            @Override
            public Double get() {
                 return Math.random();
            }
        });
        System.out.println(generate);
        Stream<Double> generate2 = Stream.generate(() -> Math.random());
        System.out.println(generate2);
        Stream<Double> generate3 = Stream.generate(Math::random);
        System.out.println(generate3);
        
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 5);
        System.out.println(integerStream.collect(Collectors.toList()));
        Stream<String> stringStream = Stream.of("taobao");
        System.out.println(stringStream.collect(Collectors.toList()));
        System.out.println("==============================");

        List<Integer> inums = Lists.newArrayList(1,1,null,2,3,4,null,5,6,7,8,9,10);
        // 1 2 3 4 5 6 7 8 9 10
        System.out.println("sum is:"+inums.stream().filter(num -> num != null).distinct().mapToInt(num -> num * 2).peek(System.out::println).skip(4).limit(4).sum());
    }
}
