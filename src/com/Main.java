package com;

import javax.sound.midi.SysexMessage;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        int n = 123; // gets stored in stack area

        float f1 = 1.23f;
        double d1 = 1.23;
        char c1 = 'A';
        byte b1 = 123;
        // casting in java
        Integer I1 = 123; //equivalent to Integer.valueOf(123);
        int i2 = I1.intValue(); // equivalent to (int) I1;
        // STRING FORMATTING
        System.out.println(String.format("My name is %s, I weight %.2fkg","ARUN",70.2312123));
        // String are obj; they get stored in String constant pool (SCP)
        // when 2 string obj gets same value -> only 1 obj is created in SCP and both will have same reference.
        String s = "arun";
        System.out.println(s.contains("run"));
        System.out.println(s.substring(0,2));
        String[] s1 = s.split("");
        Arrays.stream(s1).forEach(System.out::print);
        System.out.println();
        String s2 = "arun123";
        String s3 = new String("arun123"); // since new operator is used, String will be created in heap mem area
        String s4 = new String("arun123"); // In heap mem area, even though there is an obj with same value still JVM will
                                                // create one more obj and reference to new reference. (sharing is not done here)
        System.out.println(s2 == s4);
        System.out.println(s2.compareTo(s3));

        StringTokenizer stringTokenizer = new StringTokenizer("hello, how are you doing today"," ");
        // takes a string as an input and a delimiter; works just like a split function does
        while(stringTokenizer.hasMoreTokens()){
            System.out.println(stringTokenizer.nextToken());
        }
        // String buffer and String builder are mutable in java and String buffer is synchronized(thread safe).
        StringBuffer sb = new StringBuffer(s2);
        sb.append("prasanth");
        System.out.println(sb);
        // when subclass has a private constructor
        // method -1 create a static method in class which returns the instance of class
        Company company1 = Company.getInstance("ARUNPRASANTH");
        System.out.println(company1.getCompanyName());
    // method -2
        Constructor<Company> companyConstructor = Company.class.getDeclaredConstructor();
        companyConstructor.setAccessible(true);
        Company company2 = companyConstructor.newInstance();
        System.out.println(company2.getCompanyName());
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

        // Class is a blueprint includes state and behavior of an object it represents.

        // java supports multi level inheritance means every class can extend from only one class because of diamond problem in java
        // Multiple inheritance can be achieved in java using default methods in Interface; Each Interface supports default method with
        // same name and signature.
        // Unlike Inheritance which is IS-A model; composition is HAS-A model for ex: every desktop will have a Mouse and Keyboard
        // Encapsulation - Data hiding and abstraction
        // Polymorphism  - With reference of Super class a child class can be instantiated and vice versa.
        //sortArray();


//        List<Integer> naturalNumbers = Arrays.asList(1,2,3,4,5,5);
//        List<Integer> evenNumbers = Arrays.asList(2,4,6,8,10);
//        List<Integer> oddNumbers = Arrays.asList(3,6,9,12,15);
//
//        var list = Stream.of(naturalNumbers,evenNumbers,oddNumbers);
//        List<Integer> flatList = list.flatMap(number -> number.stream()).collect(Collectors.toList());
//        flatList.stream().forEach(System.out::print);
        rotateArray();


    }

// sort an array
    public static void sortArray() {
        int[] intArray = {4, 3, 5, 6, 7, 1, 2};
        //Arrays.stream(intArray).sorted().forEach(System.out::print);
//        for(int i=0;i<intArray.length-1;i++) {
//            for(int j=i+1;j<=intArray.length-1;j++) {
//                if (intArray[i] > intArray[j]) {
//                    int temp = intArray[i];
//                    intArray[i] = intArray[j];
//                    intArray[j] = temp;
//            }
//            }
        intArray[0] = intArray[intArray.length-1];
        Arrays.stream(intArray).forEach(System.out::print);
        Arrays.stream(intArray).distinct();
//        List<Company> companyList = new ArrayList<>();
//
//        companyList.sort((o1, o2) -> {
//            if (o1.getCompanyName().equalsIgnoreCase(o2.getCompanyName())){
//                return 0;
//            }
//            return -1;
//        });
    }

    public static int[] rotateArray() {
        int[] intArray = {1,2,3,4,5,6,7};
        // {7,1,2,3,4,5,6}
        List<Integer> integerList = new ArrayList<>();
       for (int i =0; i<intArray.length;i++) {
           integerList.add(intArray[i]);
       }
       integerList.stream().forEach(System.out::print);
      int ele = integerList.remove(integerList.size()-1);
      integerList.add(0,ele);
        System.out.println();
        integerList.stream().forEach(System.out::print);
//       intList.stream().forEach(element -> element.forEach(System.out::print));
//       IntStream ele = intList.remove(intList.size()-1);
//       intList.add(0,ele);
//        System.out.println("After rotate");
//        System.out.println(intList.get(0));


        return intArray;
    }
    }




