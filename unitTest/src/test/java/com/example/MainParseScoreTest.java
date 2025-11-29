package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainParseScoreTest extends BaseMainTest {

    @Test
    void testParseScore_Valid() {
        // Happy case: chuỗi số hợp lệ
        assertEquals(8.5, main.parseScore("8.5"));
    }

    @Test
    void testParseScore_Invalid_Letter() {
        // Lỗi / Invalid: ký tự chữ
        assertNull(main.parseScore("A"));
    }

    @Test
    void testParseScore_Invalid_Word() {
        // Lỗi / Invalid: từ tiếng Anh
        assertNull(main.parseScore("hello"));
    }

    @Test
    void testParseScore_Invalid_NumberMixedWithChar() {
        // Lỗi / Invalid: số lẫn chữ
        assertNull(main.parseScore("9x"));
    }

    @Test
    void testParseScore_Invalid_EmptyString() {
        // Lỗi / Invalid: chuỗi rỗng
        assertNull(main.parseScore(""));
    }

    @Test
    void testParseScore_Invalid_OnlySpaces() {
        // Lỗi / Invalid: toàn khoảng trắng
        assertNull(main.parseScore("   "));
    }
    @Test
    void testParseScore_NaNString() {
        assertNull(main.parseScore("NaN"));
    }

    @Test
    void testParseScore_InfinityString() {
        assertNull(main.parseScore("Infinity"));
    }

}
