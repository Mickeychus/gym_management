# Hệ Thống Quản Lý GYM

## Giới Thiệu
Hệ thống quản lý GYM là một ứng dụng Java được phát triển để quản lý các thành phần của một hệ thống GYM .

## Chức Năng

### Đăng Nhập
- Tài khoản đăng nhập 1: chuvanlong
- Mật khẩu: 123456
- Tài khoản đăng nhập 2: vuviettuan
- Mật khẩu: 123456
- Tài khoản đăng nhập 3: duongtrungkien
- Mật khẩu: 123456

### Chức Năng Chính

1. **Quản lý Học Viên:**
    - **Xem danh sách học viên:** 
        - Mở ứng dụng và xem danh sách tất cả các học viên hiện có.
    - **Tìm kiếm học viên:**
        - Nhập từ khóa tìm kiếm và nhấn Tìm kiếm.
    - **Thêm mới học viên:**
        - Nhấn nút để thêm học viên mới, nhập thông tin cần thiết và lưu lại.
    - **Sửa thông tin học viên:**
        - Chọn học viên cần sửa từ danh sách, cập nhật thông tin và lưu lại.
    - **Xóa học viên:**
        - Chọn học viên cần xóa từ danh sách và xác nhận xóa.

2. **Quản lý Huấn Luyện Viên:**
    - Tương tự như quản lý học viên, nhưng áp dụng cho danh sách huấn luyện viên.

3. **Quản lý Phòng Tập:**
    - **Xem danh sách phòng tập:**
        - Hiển thị danh sách tất cả các phòng tập có sẵn.
    - **Tìm kiếm phòng tập:**
        - Nhập từ khóa tìm kiếm và nhấn Tìm kiếm.
    - **Thêm mới phòng tập:**
        - Thêm phòng tập mới vào hệ thống.
    - **Sửa thông tin phòng tập:**
        - Chỉnh sửa thông tin của một phòng tập cụ thể.
    - **Xóa phòng tập:**
        - Loại bỏ một phòng tập khỏi danh sách.

4. **Quản lý Loại Hình:**
    - **Xem danh sách loại hình:**
        - Hiển thị danh sách các loại hình hiện có.
    - **Tìm kiếm loại hình:**
        - Nhập từ khóa tìm kiếm và nhấn Tìm kiếm.
    - **Thêm mới loại hình:**
        - Thêm loại hình mới vào hệ thống.
    - **Sửa thông tin loại hình:**
        - Chỉnh sửa thông tin của một loại hình cụ thể.
    - **Xóa loại hình:**
        - Loại bỏ một loại hình khỏi danh sách.

5. **Lưu Trữ Dữ Liệu:**
    - Dữ liệu về học viên, huấn luyện viên, phòng tập và loại hình được lưu trữ trong các tệp XML tương ứng.

## Cách Sử Dụng

### Đăng Nhập
1. Mở ứng dụng và nhập tên đăng nhập và mật khẩu vào cửa sổ đăng nhập.
2. Nhấn nút "Đăng Nhập" để truy cập hệ thống.

### Quản Lý Học Viên
1. **Xem Danh Sách Học Viên:**
    - Trong giao diện chính, chọn mục "Xem Danh Sách Học Viên" để xem thông tin chi tiết về các học viên.

2. **Tìm kiếm Học viên theo từ khóa:**
    - Chọn mục "Tìm Kiếm Học Viên".
    - Nhập tên hoặc một phần của tên học viên cần tìm kiếm vào ô tìm kiếm.
    - Nhấn "Tìm kiếm" để thực hiện tìm kiếm.
    - Kết quả sẽ hiển thị danh sách học viên phù hợp với tên đã nhập.

3. **Thêm Mới Học Viên:**
    - Chọn mục "Thêm Mới Học Viên".
    - Nhập thông tin học viên mới.
    - Nhấn nút "Thêm" để lưu thông tin.

4. **Sửa Thông Tin Học Viên:**
    - Chọn mục "Sửa Thông Tin Học Viên".
    - Chọn học viên cần sửa.
    - Nhập thông tin cập nhật.
    - Nhấn nút "Lưu" để cập nhật thông tin.

5. **Xóa Học Viên:**
    - Chọn mục "Xóa Học Viên".
    - Chọn học viên cần xóa.
    - Xác nhận xóa.

## Cấu Trúc Dự Án
- **src:**
    - **controller:** Chứa các lớp điều khiển.
    - **dao:** Chứa lớp truy cập dữ liệu.
    - **entities:** Chứa các đối tượng thực thể.
    - **utils:** Chứa các tiện ích và công cụ.
    - **view:** Chứa các lớp giao diện người dùng.
	- **xml:** Chứa các tệp XML lưu trữ dữ liệu học viên.

## Yêu Cầu
- Java 8 hoặc phiên bản cao hơn.
- IDE hỗ trợ Java.

## Hướng Dẫn Cài Đặt
1.Lấy/tải mã nguồn về máy
2. Mở dự án trong IDE Java của bạn.
3. Chạy ứng dụng từ lớp chính `main`.

## Tài Liệu Tham Khảo
- [Java Documentation](https://docs.oracle.com/en/java/)
- [Java Swing Documentation](https://docs.oracle.com/javase/tutorial/uiswing/)

## Liên Hệ
- Tác giả: Chu Việt Long