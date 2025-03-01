
# Week 3: Java basic

1. Sự khác biệt giữa dữ liệu primitive và non-primitive trong Java là gì?

- Answer:
  - primitive:
    - lưu trữ giá trị trực tiếp trong stack
    - Java cung cấp sẵn.
    - nhanh 
  - non-primitive:
    - Được lưu trữ trong heap memory, còn biến tham chiếu nằm trong stack memory.
    - các kiểu dữ liệu do lập trình viên định nghĩa hoặc do Java cung cấp sẵn.
    - chậm hơn nhưng có nhiều phươn thức hỗ trợ

2. tại sao String là non-primitive type trong khi có vẻ nó chỉ chứa kí tự?

- Answer:
  - bởi vì string nó ko lưu trong stack mà tham chiếu đến heap và có nhiều phương thức hỗ tợ và giống như 1 object

3. Sự khác biệt giữa int và Integer là gì? khi nào nào dùng cái nào?

- Answer:
  - int là primitive còn Integer là Wrapper Class
  - Dùng int khi:
    - Cần hiệu suất cao, thực hiện các phép toán đơn giản. 
  - Dùng Integer khi:
    - Làm việc với Collections
    - Cần sử dụng các phương thức của class Integer.

4. Auto-boxing và unboxing là gì? Khi nào chúng xảy ra?

- Answer:
  - Auto-boxing: Là quá trình Java tự động chuyển đổi một giá trị kiểu primitive thành đối tượng wrapper class tương ứng.
  - Xảy ra khi:
    - Gán một giá trị primitive cho một biến wrapper class. 
    - Thêm giá trị primitive vào một Collection (List, Map, Set, ...) yêu cầu đối tượng.
      - int x = 10;
        Integer obj = x;  // Auto-boxing từ int -> Integer
        List<Integer> list = new ArrayList<>();
        list.add(20);  // Java tự động chuyển 20 (int) thành Integer
  - Unboxing: Là quá trình Java tự động chuyển đổi một đối tượng wrapper class về giá trị primitive tương ứng.
  - Xảy ra khi:
    - Gán một wrapper class vào một biến primitive. 
    - Sử dụng một wrapper class trong các phép toán toán học.
      - Integer obj = 30;
        int y = obj;  // Unboxing từ Integer -> int
        int sum = obj + 10; // Java tự động chuyển obj thành int trước khi cộng

5. Sự khác biệt giữa mảng tĩnh (Array) và danh sách động (ArrayList) trong Java?- Answer:
- Answer:
  - array:
    - kích thước: cố định nên ko thể thay đổi kích thước sau khi khai báo
  - arrayList: 
    - kích thước: co giãn khi cần

6. Sự khác biệt giữa String, StringBuffer, và StringBuilder?
- Answer:
  - bởi vì string là imutable nên sinh ra stringBuffer và stringBuilder để có thể thay đổi giá trị. 
  - StringBuilder nhanh nhất bởi vì ko có đồng bộ đó(no thread-safe). 
  - mặc dù stringBuffer chậm hơn stringBuilder nhưng nó có đồng bộ hóa nên an toàn hơn trong môi trường đa luồng

7. Giải thích về String Pool trong Java? Tại sao Java sử dụng String Pool?
- Answer:
  - String Pool là một vùng bộ nhớ đặc biệt trong Heap Memory, nơi Java lưu trữ các chuỗi kiểu String đã được tạo theo cách literal (trực tiếp).
  - bởi vì:
    - Tiết kiệm bộ nhớ
    - Tăng hiệu suất
    - Tối ưu hóa bộ nhớ Heap

8. String là immutable, điều này có nghĩa gì? Tại sao String được thiết kế theo cách này?
- Answer:
  - Immutable có nghĩa là một object String không thể thay đổi sau khi đã được tạo.
  - Mỗi khi một String bị thay đổi, Java tạo một object mới thay vì sửa đổi object cũ.
  - Vì String là immutable, nhiều thread có thể đọc cùng một giá trị String mà không cần đồng bộ hóa.
  - Nếu String có thể thay đổi, Pool sẽ không thể hoạt động hiệu quả.
  - String thường dùng để lưu mật khẩu, URL, username...Nếu String thay đổi được, hacker có thể thay đổi dữ liệu mà không cần tạo object mới.
  - 

9. intern() method trong String làm gì?
- Answer:

10. Chuyện gì xảy ra nếu thay đổi một giá trị của String được tạo bằng String literal?
- Answer:
  - intern() trong Java giúp tối ưu bộ nhớ bằng cách lưu chuỗi vào String Pool nếu nó chưa tồn tại.
  - String s1 = new String("Hello");
    String s2 = "Hello";
  - System.out.println(s1 == s2); // false (s1 là object mới trong Heap)
    String s3 = s1.intern(); // Đưa s1 vào String Pool (nếu chưa có)
    System.out.println(s3 == s2);// true (s3 trỏ đến "Hello" trong String Pool)
  - 
    
11. Toán tử == và .equals() khác nhau thế nào khi so sánh Object?
- Answer: 
  - == so sánh giá trị
  - equal so sánh giá trị

12. Tại sao 
double a = 0.1
double b = 0.2
boolean check = (a + b) == 0.3
tại sao check lại bằng false?
Nếu double có nhược điểm như vậy tại sao nó vẫn tồn tại
- Answer: 
  - bởi vì số thực được máy tính lưu dưới dạng nhị phân binary floating-point representation
  - có thể khắc phục bằng sử dụng BigDecimal
  - double vẫn tồn tại bởi vì:
    - double được tối ưu hóa bởi phần cứng giúp cho các phép toán nhanh hơn
    - lưu dc các biến rát nhỏ hoặc rất lớn
    - 
