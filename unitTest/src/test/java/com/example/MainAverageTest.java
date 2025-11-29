package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainAverageTest extends BaseMainTest {

    @Test
    void testAverage_Normal() {
        // Happy case: tổng bình thường → trung bình đúng
        assertEquals(6.0, main.average(18));
    }

    @Test
    void testAverage_WithZero() {
        // Happy case: tổng = 0
        assertEquals(0.0, main.average(0));
    }

    @Test
    void testAverage_FloatingPoint() {
        // Edge case: tổng là số thực, cần delta cho sai số
        assertEquals(5.5, main.average(16.5), 0.0001);
    }

    @Test
    void testAverage_Large() {
        // Happy case: tổng lớn vẫn xử lý đúng
        assertEquals(9.0, main.average(27));
    }
}
