package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainSumTest extends BaseMainTest {

    @Test
    void testSum_Normal() {
        // Happy case: 3 số nguyên bình thường
        assertEquals(18.0, main.sum(5, 6, 7));
    }

    @Test
    void testSum_WithZeros() {
        // Happy case: có số 0
        assertEquals(0.0, main.sum(0, 0, 0));
    }

    @Test
    void testSum_WithDecimals() {
        // Happy case: số thực (double)
        assertEquals(16.5, main.sum(5.5, 6.0, 5.0));
    }

    @Test
    void testSum_WithLargeNumbers() {
        // Happy case: số lớn nhưng vẫn hợp lệ
        assertEquals(27.0, main.sum(9, 9, 9));
    }
}
