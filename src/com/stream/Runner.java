package com.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Runner {
	public static void main(String[] args) {
	List<String> names = Arrays.asList("Michael", "Dean", "James", "Chris");
	for(int i = 0; i< names.size();i++) {
		System.out.println("Hello :"+names.get(i));
	}
	names.forEach(name->{
		System.out.println("Hello :"+name);
	});
	
    names.stream()
    .forEach(new Consumer<String>()
    {
        @Override
        public void accept(String t) 
        {
          System.out.println("Hello :"+t);
        }
    });
    names.stream().forEach(x -> System.out.println("Hello :"+x));
    
    List<Integer> numbers = Arrays.asList(3,4,7,8,12);
    int result = numbers.stream().reduce((a,b) -> a*b).get();
    System.out.println("result is :"+result);
    int max = numbers.stream().max((a,b) -> a - b).get();
    System.out.println("max number is :"+max);
    int min = numbers.stream().max((a,b) -> a + b).get();
    System.out.println("min number is :"+min);
    List<Integer> evenNumbers = numbers.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
    System.out.println("Even numbers : ");
    int[] index = {0};
    evenNumbers.forEach(x-> {
    	if(index[0] != 0)
    		System.out.print(",");
    	System.out.print(x);
    	index[0]++;
    });
    List<Integer> oddNumbers = numbers.stream().filter(x -> x % 2 == 1).collect(Collectors.toList());
    System.out.println("");
    System.out.println("Odd numbers : ");
    oddNumbers.forEach(x-> System.out.print(","+x));
    int sumResult = numbers.stream().reduce((a,b) -> a+b).get();
    System.out.println("");
    System.out.println("sum result is :"+sumResult);
    int multipleOps = numbers.stream().map(x -> x*x).filter(x -> x % 2 == 1).max((a,b) -> a + b).get();
    System.out.println("multipleOps result :"+multipleOps);
}
}
