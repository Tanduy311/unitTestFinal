package com.example;


public class Main {

    // Xử lý những input không hợp lệ
    public Double parseScore(String input) {
        try {
            Double value = Double.parseDouble(input);
            if (value.isNaN() || value.isInfinite()) {
                return null; // coi là input lỗi
            }
            return value;
        } catch (Exception e) {
            return null;
        }
    }


    // Tính tổng
    public double sum(double a, double b, double c) {
        return a + b + c;
    }

    // Tính điểm trung bình
    public double average(double total) {
        return total / 3;
    }

    // Kiểm tra điểm hợp lệ (0–10)
    public boolean isValid(double score) {
        return score >= 0 && score <= 10;
    }

    // Xếp loại dựa trên điểm
    public String classify(double avg) {
        if (avg >= 8) return "Giỏi";
        if (avg >= 6.5) return "Khá";
        if (avg >= 5) return "Trung bình";
        return "Yếu";
    }

    public String finalResultFromString(String s1, String s2, String s3) {
        Double a = parseScore(s1);
        Double b = parseScore(s2);
        Double c = parseScore(s3);

        if (a == null || b == null || c == null) {
            return "Không hợp lệ";
        }
        return finalResult(a, b, c);
    }

    public String passOrFail(double a, double b, double c) {
        // Nếu có điểm không hợp lệ (âm hoặc >10)
        if (!isValid(a) || !isValid(b) || !isValid(c)) {
            return "Không hợp lệ";
        }

        double total = sum(a,b,c);

        if (total > 15) {
            return "Đậu";
        } else {
            return "Rớt";
        }
    }

    // Hàm tổng hợp: nhận 3 điểm → trả về xếp loại
    public String finalResult(double a, double b, double c) {

        // Nếu có điểm không hợp lệ → trả về "Không hợp lệ"
        if (!isValid(a) || !isValid(b) || !isValid(c)) {
            return "Không hợp lệ";
        }

        double total = sum(a, b, c);
        double avg = average(total);

        return classify(avg);  // phụ thuộc các hàm trên
    }
}
