package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainPassOrFailTest extends BaseMainTest {

    @Test
    void testPassOrFail_Pass() {
        // Happy case: tổng > 15 → Đậu
        assertEquals("Đậu", main.passOrFail(6, 5, 5)); // 16
    }

    @Test
    void testPassOrFail_Fail_Exactly15() {
        // Edge case: tổng = 15 (biên) → Rớt
        assertEquals("Rớt", main.passOrFail(5, 5, 5)); // 15
    }

    @Test
    void testPassOrFail_Fail_Below15() {
        // Happy case + Edge logic: tổng < 15 → Rớt
        assertEquals("Rớt", main.passOrFail(5, 5, 4.9));
    }

    @Test
    void testPassOrFail_Invalid_A() {
        // Lỗi / Invalid: điểm A âm
        assertEquals("Không hợp lệ", main.passOrFail(-1, 5, 5));
    }

    @Test
    void testPassOrFail_Invalid_B() {
        // Lỗi / Invalid: điểm B > 10
        assertEquals("Không hợp lệ", main.passOrFail(5, 11, 5));
    }

    @Test
    void testPassOrFail_Invalid_C() {
        // Lỗi / Invalid: điểm C > 10
        assertEquals("Không hợp lệ", main.passOrFail(5, 5, 11));
    }
}
