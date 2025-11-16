### 🌟 Tiêu chuẩn Vàng: Conventional Commits

Cấu trúc chung của một commit chuyên nghiệp sẽ trông như thế này:

```
<type>[scope]: <subject>

[optional body]

[optional footer]
```

Hãy chia nhỏ từng phần:

---

### 1. 🎯 Tiêu đề (Subject Line) - Phần quan trọng nhất

Đây là dòng đầu tiên, và nó phải cô đọng nhất.

* **`<type>` (Loại):** Bắt buộc. Nó nói lên *loại* thay đổi bạn đã làm. Các `type` phổ biến nhất:
    * **`feat`**: (Feature) Thêm một tính năng mới.
    * **`fix`**: Sửa một cái bug.
    * **`refactor`**: Sắp xếp lại code (không thêm/sửa tính năng, không sửa bug).
    * **`docs`**: Chỉ thay đổi tài liệu (README, comment code...).
    * **`style`**: Chỉ thay đổi về định dạng code (lùi đầu dòng, thiếu dấu chấm phẩy...).
    * **`test`**: Thêm/sửa test cases.
    * **`chore`**: (Việc vặt) Các thay đổi không liên quan đến code (cập nhật file build, config, dependencies...).
    * **`perf`**: (Performance) Cải thiện hiệu năng.

* **`[scope]` (Phạm vi):** Không bắt buộc. Nó chỉ rõ phần nào của code bị ảnh hưởng.
    * *Ví dụ:* `(auth)`, `(api)`, `(payment)`, `(db)`.

* **`<subject>` (Chủ đề):** Mô tả ngắn gọn thay đổi của bạn.
    * **QUY TẮC VÀNG:** Viết ở **thì mệnh lệnh** (Imperative mood).
        * **Nên:** `Add login feature` (Thêm tính năng đăng nhập).
        * **Không nên:** `Added login feature` (Đã thêm...), `Adding login feature` (Đang thêm...).
    * Bắt đầu bằng động từ.
    * Không viết hoa chữ cái đầu (trừ khi là tên riêng).
    * Không kết thúc bằng dấu chấm.
    * Giữ ngắn gọn (dưới 72 ký tự).

---

### 2. 📖 Phần thân (Body) - Giải thích "Tại sao"

* Không bắt buộc. Chỉ dùng khi Tiêu đề không đủ rõ.
* **Tách biệt với Tiêu đề bằng 1 dòng trống.**
* Giải thích **VẤN ĐỀ** là gì và **GIẢI PHÁP** của bạn là gì.
* Trả lời câu hỏi: "Tại sao lại thay đổi như vậy?"
    * *Ví dụ:* "Thuật toán cũ chạy chậm khi có 1000 users", "API bên thứ 3 đã thay đổi...".

---

### 3. 👣 Phần chân (Footer) - Metadata

* Không bắt buộc.
* Dùng để ghi các thông tin meta.
* **BREAKING CHANGE:** (Rất quan trọng) Nếu commit này làm "hỏng" (thay đổi) API hoặc tính năng cũ, bạn phải ghi rõ ở đây.
    * *Ví dụ:* `BREAKING CHANGE: Trường 'userId' trong response /api/users đã được đổi tên thành 'id'`
* **Issue Tracker:** Dùng để tự động đóng các issue.
    * *Ví dụ:* `Closes #123`, `Fixes #456`.

---

### 📝 Ví dụ thực tế

#### Ví dụ 1: Một `fix` đơn giản (Không cần body)

```
fix(auth): Sửa lỗi crash app khi đăng nhập sai mật khẩu
```

#### Ví dụ 2: Một `feat` (Có body giải thích)

```
feat(payment): Thêm tính năng thanh toán qua ZaloPay

Thêm ZaloPay làm cổng thanh toán mới.
Việc này yêu cầu tích hợp ZaloPay SDK v2 và
thêm một bảng 'ZaloTransaction' để lưu log giao dịch.
```

#### Ví dụ 3: Một `refactor` có "Breaking Change"

```
refactor(api): Thay đổi cấu trúc response của /users

Thay đổi response từ object phẳng sang cấu trúc lồng nhau
để dễ dàng mở rộng trong tương lai.

BREAKING CHANGE:
Response của `GET /api/users` đã thay đổi.
- `username` và `email` giờ nằm trong object `profile`.
- `user_id` đã được đổi tên thành `id`.
```

#### Ví dụ 4: Một `chore` (Việc vặt)

```
chore: Nâng cấp phiên bản Spring Boot lên 3.2.1
```

#### Ví dụ 5: Một `docs` (Sửa tài liệu)

```
docs(readme): Cập nhật hướng dẫn cài đặt cho Windows
```