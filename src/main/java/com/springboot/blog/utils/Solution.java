package com.springboot.blog.utils;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    //Dates that you are going to receive: yyyy-MM-dd'T'HH:mm:ssZ
    //Eg 2023-01-01T00:00:00Z
    //All Strings are valid
    public static List<Instant> convert(List<String> dates) {
        return dates.stream()
                    .map(Instant::parse)
                    .filter(date -> date.isAfter(Instant.parse("2022-12-31T23:59:59Z")))
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.toList());
    }
    public static String fizzbuzz(int num){
        int looper = 0;
        StringBuilder s = new StringBuilder();
        while (looper < num){
            boolean isWord = false;
            if (looper == 0){
                s.append(looper);
                s.append(" ");
                looper += 1;
                //s.append(looper);
                continue;
            }
            if (looper%3 == 0){
                //System.out.print("Fizz ");
                isWord = true;
                s.append("Fizz");
            }
            if (looper%5 == 0){
                isWord = true;
                //System.out.print("Buzz.");
                s.append("Buzz");
            }
            if (!isWord){
                //System.out.print(looper);
                s.append(looper);
            }
            s.append(" ");
            looper += 1;
        }

        return s.toString();
    }

}