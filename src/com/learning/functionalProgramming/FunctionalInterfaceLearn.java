package com.learning.functionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class FunctionalInterfaceLearn {
    public static void main(String[] args) {
        //Using lambda to implement function interface
        //A variable of interface is able to hold a lambda expression
        OperateString Bprefic = (s)->"b"+s;
        String res = Bprefic.addPrefix("allon");
        System.out.println(res);

        //Conventional way of implementing interface
        OperateString os = new Aprefix();  //polymorphism
        res = os.addPrefix("darsh");
        System.out.println(res);

        //Different Types of Function Interfaces

        //1. Predicates -> Test method ,returns Boolean , accept 1 input
        Predicate<Integer> isSamllerThan54 = (i)-> i<54;
        System.out.println(isSamllerThan54.test(54));
        //2. Function -> Apply method ,Accept 1 input ,return 1 output
        Function<String,Integer> lengthOfString = (s)->s.length();
        System.out.println(lengthOfString.apply("Adarsh"));
       /* Function<Integer, Integer> identity = Function.identity();
        System.out.println(identity.apply(5));*/

        //3. Consumer -> Accept method, 1 input ,return void
        Consumer<List<Integer>> printInteger = (s)->{
            for ( int x : s){
                System.out.println(x);
            }
        };
        printInteger.accept(Arrays.asList(1,2,3,4,5));

        //4. Supplier -> Get method, 0 input ,1 output
        Supplier<String> stringProducer = ()->"String supplied";
        System.out.println(stringProducer.get());

        //5. Bipredicate -> Test method, 2 input , boolean output

        BiPredicate<String,Integer> stringLengthValidate = (x,y)-> x.length()==y;
        System.out.println(stringLengthValidate.test("Adarsh",6));

        //6 Bifunction -> Apply method,two input one output
        BiFunction<Integer,String,Character> randomFunction = (x,y)-> y.charAt(x);
        System.out.println(randomFunction.apply(2,"adarsh"));

        //7 BiConsumer -> get method , 2 input , void output
        BiConsumer<Integer,String> print = (x,y)-> System.out.println("String "+y+" Integer " + x);
        print.accept(89,"Eighty Nine");

        //8.Unary operator (extends Function interface)-> Apply method, 1 input type which will be same as output Type
        UnaryOperator<String> unaryOperatorExample = (x)-> x + x;
        System.out.println(unaryOperatorExample.apply("Adarsh "));

        //9.Binary operator -> Accept 2 paramter of same type and return the same type of output
        BinaryOperator<Integer> binaryOperatorExample = (a,b)-> a+b;
        System.out.println(binaryOperatorExample.apply(3,4));









    }
}


class Aprefix implements OperateString{

    @Override
    public String addPrefix(String s) {
        return "a"+s;
    }
}

@FunctionalInterface
interface OperateString {
    String addPrefix( String s);
}