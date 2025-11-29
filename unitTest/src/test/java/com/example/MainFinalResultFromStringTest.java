package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainFinalResultFromStringTest extends BaseMainTest {

    @Test
    void testFinalResultFromString_InvalidInput() {
        // Lỗi / Invalid: từng loại input sai định dạng
        assertEquals("Không hợp lệ", main.finalResultFromString("A", "5", "6"));
        assertEquals("Không hợp lệ", main.finalResultFromString("7", "B", "6"));
        assertEquals("Không hợp lệ", main.finalResultFromString("7", "6", "xyz"));
        assertEquals("Không hợp lệ", main.finalResultFromString("", "6", "7"));
        assertEquals("Không hợp lệ", main.finalResultFromString(" ", "6", "7"));
        assertEquals("Không hợp lệ", main.finalResultFromString("5", "6", "abc"));
    }

    @Test
    void testFinalResultFromString_ValidInput() {
        // Happy case: 3 chuỗi số hợp lệ → xử lý bình thường
        assertEquals("Khá", main.finalResultFromString("7", "7", "6"));
    }
}
