package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainFinalResultTest extends BaseMainTest {

    @Test
    void testFinalResult_Valid_Kha() {
        // Happy case: điểm hợp lệ, xếp loại Khá
        assertEquals("Khá", main.finalResult(7, 7, 6));
    }

    @Test
    void testFinalResult_Valid_Gioi() {
        // Happy case: điểm hợp lệ, xếp loại Giỏi
        assertEquals("Giỏi", main.finalResult(9, 9, 8));
    }

    @Test
    void testFinalResult_Valid_TrungBinh() {
        // Happy case: điểm hợp lệ, xếp loại Trung bình
        assertEquals("Trung bình", main.finalResult(6, 5, 4));
    }

    @Test
    void testFinalResult_Valid_Yeu() {
        // Happy case: điểm hợp lệ, xếp loại Yếu
        assertEquals("Yếu", main.finalResult(3, 4, 5));
    }

    @Test
    void testFinalResult_InvalidScores() {
        // Lỗi / Invalid: điểm > 10
        assertEquals("Không hợp lệ", main.finalResult(11, 5, 6));
        assertEquals("Không hợp lệ", main.finalResult(5, 5, 11));
        assertEquals("Không hợp lệ", main.finalResult(5, 11, 5));

        // Lỗi / Invalid: điểm âm
        assertEquals("Không hợp lệ", main.finalResult(-1, 5, 6));
        assertEquals("Không hợp lệ", main.finalResult(5, -1, 5));
    }
}
