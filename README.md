# Student Score Processing – Unit Testing Core Project (Full Documentation)

![Java](https://img.shields.io/badge/Java-25-orange?style=flat-square)
![Testing](https://img.shields.io/badge/Testing-JUnit%205-blue?style=flat-square)
![Coverage](https://img.shields.io/badge/Line%20Coverage-100%25-brightgreen?style=flat-square)
![Quality](https://img.shields.io/badge/Clean%20Code-Yes-success?style=flat-square)

---

# 1. Giới thiệu chung

Project **Student Score Processing Core** được xây dựng nhằm mô phỏng hệ thống xử lý điểm số học sinh dựa trên 3 môn học.  
Đây là bài tập thực hành Unit Testing theo yêu cầu của giảng viên, đảm bảo:

- Có **≥ 5 hàm** và có **mối quan hệ phụ thuộc**
- Có **Unit Tests** cho từng hàm riêng biệt
- Test được phân loại thành:
    - **Happy Case**
    - **Edge Case**
    - **Error Case**
- Có báo cáo đầy đủ trong README.md
- Đạt **100% Test Coverage** khi chạy bằng IntelliJ

Toàn bộ logic đều là **pure functions**, không cần sử dụng Mock, Stub hoặc Fake.

---

# 2. Mô tả chức năng (Function Documentation)

| Hàm | Mô tả | Trả về | Ghi chú |
|-----|------|--------|--------|
| `parseScore(String)` | Chuyển chuỗi thành số thực | `Double` hoặc `null` | Xử lý input lỗi |
| `isValid(double)` | Kiểm tra điểm hợp lệ (0–10) | `boolean` | Pure function |
| `sum(a,b,c)` | Tính tổng 3 môn | `double` | Không kiểm tra hợp lệ |
| `average(total)` | Tính điểm trung bình | `double` | total / 3 |
| `classify(avg)` | Xếp loại học lực | `String` | Giỏi / Khá / Trung bình / Yếu |
| `passOrFail(a,b,c)` | Kiểm tra đậu/rớt | `"Đậu"` / `"Rớt"` | Tổng ≥ 15 |
| `finalResult(a,b,c)` | Tổng hợp kết quả từ 3 điểm | `String` | Gọi nhiều hàm con |
| `finalResultFromString(s1,s2,s3)` | Input chuỗi → kết quả cuối | `String` | Hàm cấp cao nhất |

---

# 3. Mối quan hệ giữa các hàm (Function Dependency Graph)

```
[ Input chuỗi ]
        │
        ▼
parseScore(s1,s2,s3)
        │ (trả về số hoặc null)
        ▼
validate → if invalid → "Dữ liệu không hợp lệ"
        │
        ▼
sum(a,b,c)
        │
        ▼
average(total)
        │
        ▼
classify(avg)
        │
        ▼
passOrFail(a,b,c)
        │
        ▼
[ Kết quả cuối: Xếp loại + Đậu/Rớt ]

```

Sơ đồ cho thấy toàn bộ chương trình được xây từ các hàm thuần nhỏ → đúng triết lý Unit Testing.

---

# 4. Chiến lược kiểm thử (Testing Strategy)

Dự án áp dụng mô hình kiểm thử **3 phân lớp**, gồm:

---

## 🟩 Happy Case (Hợp lệ)

Các trường hợp chạy đúng logic:

- `parseScore("8.5") → 8.5`
- `sum(5,6,7) → 18`
- `average(18) → 6.0`
- `classify(8) → Giỏi`
- `finalResult(5,6,7)` đúng định dạng

---

## 🟧 Edge Case (Giá trị biên)

Các giá trị “nhạy cảm” có khả năng gây lỗi:

- Điểm = 0
- Điểm = 10
- Tổng = **15** (vừa đủ đậu)
- Chuỗi `" 8 "` có khoảng trắng
- Trung bình = 4.99999 → kiểm tra delta
- Ngưỡng phân loại: 5.0, 6.5, 8.0

---

## 🟥 Error Case (Lỗi)

Những input không hợp lệ:

- `"abc"`
- `""` và `"   "`
- `"-3"`
- `"12"`
- `"NaN"`
- `"Infinity"`

Kiểm thử nhóm này đảm bảo chương trình ổn định và an toàn.

---

# 5. 100% Test Coverage

Dự án đạt:

### ✔ 100% Line Coverage
### ✔ Kiểm thử tất cả nhánh logic
### ✔ Không có dòng code nào không được kiểm tra

Điều này chứng minh chất lượng test cao và bao phủ toàn bộ hành vi của chương trình.

---

# 6. Kiến trúc test (Test Architecture)

```
test/
 ├── BaseMainTest.java
 ├── MainParseScoreTest.java
 ├── MainIsValidTest.java
 ├── MainSumTest.java
 ├── MainAverageTest.java
 ├── MainClassifyTest.java
 ├── MainPassOrFailTest.java
 ├── MainFinalResultTest.java
 └── MainFinalResultFromStringTest.java
```

### 🎯 Vai trò của `BaseMainTest`
- Khởi tạo object `Main` dùng chung cho tất cả test
- Không lặp lại code
- Giúp test ngắn gọn, sạch, đúng chuẩn **DRY – Don’t Repeat Yourself**

---

# 7. Hướng dẫn chạy test

### ▶️ Trong IntelliJ IDEA:

```
Right click → test folder → Run 'All Tests'
```

hoặc dùng phím:

```
Ctrl + Shift + F10
```

---

# 8. Điều tôi học được từ Unit Testing

- Cách chia nhỏ bài toán thành các hàm thuần (pure functions)
- Tư duy kiểm thử phân loại Happy/Edge/Error
- Tạo test tách file theo từng chức năng
- Hiểu sâu về coverage và cách đạt 100%
- Khi nào cần/không cần Mock, Stub, Fake
- Cách viết README.md như một báo cáo kỹ thuật

---



# 👤 Maintainer
**Nguyễn Duy Tân**
