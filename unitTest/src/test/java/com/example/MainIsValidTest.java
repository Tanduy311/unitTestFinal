package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainIsValidTest extends BaseMainTest {

    @Test
    void testIsValid_NormalAndOutOfRange() {
        // Happy case: điểm hợp lệ
        assertTrue(main.isValid(7.0));

        // Lỗi / Invalid: nhỏ hơn 0
        assertFalse(main.isValid(-1.0));

        // Lỗi / Invalid: lớn hơn 10
        assertFalse(main.isValid(11.0));
    }

    @Test
    void testIsValid_Boundary() {
        // Edge case: biên dưới 0
        assertTrue(main.isValid(0));

        // Edge case: biên trên 10
        assertTrue(main.isValid(10));
    }

    @Test
    void testIsValid_NearBoundary() {
        // Edge case + Lỗi: rất sát biên nhưng vẫn ngoài khoảng
        assertFalse(main.isValid(-0.0001));
        assertFalse(main.isValid(10.0001));
    }
}
