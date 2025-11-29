package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainClassifyTest extends BaseMainTest {

    @Test
    void testClassify_BasicLevels() {
        // Happy case: Giỏi
        assertEquals("Giỏi", main.classify(8.5));

        // Happy case: Khá
        assertEquals("Khá", main.classify(7.0));

        // Happy case: Trung bình
        assertEquals("Trung bình", main.classify(5.5));

        // Happy case: Yếu
        assertEquals("Yếu", main.classify(4.0));
    }

    @Test
    void testClassify_Boundaries() {
        // Edge case: đúng biên Giỏi
        assertEquals("Giỏi", main.classify(8.0));

        // Edge case: đúng biên Khá
        assertEquals("Khá", main.classify(6.5));

        // Edge case: đúng biên Trung bình
        assertEquals("Trung bình", main.classify(5.0));
    }

    @Test
    void testClassify_JustBelowBoundaries() {
        // Edge case: sát dưới Giỏi → vẫn là Khá
        assertEquals("Khá", main.classify(7.99));

        // Edge case: sát dưới Khá → vẫn là Trung bình
        assertEquals("Trung bình", main.classify(6.49));

        // Edge case: sát dưới Trung bình → Yếu
        assertEquals("Yếu", main.classify(4.99));
    }

    @Test
    void testClassify_LowAndNegative() {
        // Edge case: điểm rất thấp nhưng vẫn trong khoảng [0,10]
        assertEquals("Yếu", main.classify(0));

        // Edge case “xấu”: điểm âm, nhưng hàm classify vẫn xử lý về "Yếu"
        assertEquals("Yếu", main.classify(-1));
    }
}
