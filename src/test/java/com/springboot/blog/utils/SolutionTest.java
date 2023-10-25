package com.springboot.blog.utils;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void fizzbuzz() {
        String res = Solution.fizzbuzz(6);
        assertEquals("0 1 2 Fizz 4 Buzz ", res);
    }

    @Test
    void covert(){
        List<Instant> res = Solution.convert(List.of("2023-01-01T00:00:00Z"));
        assertEquals(Instant.parse("2023-01-01T00:00:00Z"), res.get(0));
    }
    @Test
    void covertSorted(){
        List<Instant> res = Solution.convert(List.of("2022-01-01T00:00:00Z", "2023-01-01T00:00:00Z", "2023-01-02T00:00:00Z"));
        assertEquals(Instant.parse("2023-01-02T00:00:00Z"), res.get(0));
        assertEquals(2,res.size());
    }
}