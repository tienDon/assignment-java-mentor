
# Week 4: Java Collections

1. Sự khác biệt giữa HashSet, LinkedHashSet và TreeSet? Trong trường hợp nào thì nên dùng cái nào?

- Answer:
  - HashSet: Dùng bảng băm (HashTable) để lưu trữ phần tử, không đảm bảo thứ tự. 
  - LinkedHashSet: Kế thừa HashSet nhưng duy trì thứ tự chèn bằng cách sử dụng danh sách liên kết kép. 
  - TreeSet: Dùng cấu trúc cây nhị phân tìm kiếm (Red-black Tree), sắp xếp các phần tử theo thứ tự tự nhiên. 
  - Khi nào dùng? 
    - Dùng HashSet khi chỉ cần kiểm tra tính duy nhất của phần tử mà không quan tâm thứ tự. 
    - Dùng LinkedHashSet khi cần duy trì thứ tự chèn. 
    - Dùng TreeSet khi cần sắp xếp phần tử theo thứ tự tự nhiên hoặc theo Comparator tùy chỉnh.

2. Làm thế nào để HashSet đảm bảo các phần tử không trùng lặp?

- Answer:
  - HashSet sử dụng bảng băm (hash table) và hàm băm của phần tử để xác định vị trí lưu trữ. 
  - Khi thêm phần tử, HashSet kiểm tra:
    - Nếu hashCode() giống nhau, nó tiếp tục dùng equals() để kiểm tra nội dung có trùng không. 
    - Nếu equals() trả về true, phần tử bị coi là trùng lặp và không được thêm vào.

3. Sự khác biệt giữa HashMap, LinkedHashMap và TreeMap? Trong trường hợp nào thì nên dùng cái nào?

- Answer:
  - HashMap: Dùng bảng băm để lưu trữ key-value, không đảm bảo thứ tự. 
  - LinkedHashMap: Kế thừa HashMap nhưng duy trì thứ tự chèn. 
  - TreeMap: Dùng cấu trúc Red-black Tree, lưu key theo thứ tự tự nhiên hoặc Comparator tùy chỉnh. 
  - Khi nào dùng? 
    - Dùng HashMap khi cần truy xuất nhanh mà không quan tâm thứ tự.
    - Dùng LinkedHashMap khi cần duy trì thứ tự chèn. 
    - Dùng TreeMap khi cần sắp xếp key theo thứ tự tự nhiên hoặc tùy chỉnh.

4. Từ sau Java 8, HashMap xử lý collisions như thế nào?

- Answer:
  - Trước Java 8, HashMap xử lý collision bằng danh sách liên kết (Linked List), dẫn đến hiệu suất O(n) trong trường hợp xấu nhất. 
  - Từ Java 8, khi số phần tử trong bucket vượt ngưỡng (thường là 8), danh sách liên kết chuyển thành cây đỏ đen (Red-black Tree) giúp tăng hiệu suất từ O(n) lên O(log n).

5. Tại sao String và Integer thường được dùng làm key trong HashMap?
- Answer:
  - Bất biến (Immutable): Giá trị của String và Integer không thay đổi sau khi được tạo, đảm bảo hashCode() không thay đổi. 
  - Có hashCode() và equals() được tối ưu hóa: Cả String và Integer đều có hashCode() hiệu quả, giúp giảm xung đột và tăng tốc độ truy xuất. 
  - Sử dụng rộng rãi: String thường làm key cho dữ liệu dạng text, còn Integer dùng cho dữ liệu số.

6. Cách hoạt động của Red-black Tree khi thêm, xoá phần tử?
- Answer:
  - Khi thêm phần tử:
    - Thêm vào vị trí phù hợp theo quy tắc của BST. 
    - Kiểm tra quy tắc của Red-black Tree:
    - Nếu vi phạm (ví dụ: hai node đỏ liên tiếp), thực hiện xoay cây hoặc đổi màu để cân bằng lại. 
  - Khi xoá phần tử:
    - Nếu là node lá → xoá trực tiếp. 
    - Nếu có một con → thay thế bằng con đó. 
    - Nếu có hai con → tìm node thay thế (node lớn nhất bên trái hoặc nhỏ nhất bên phải), hoán đổi rồi xoá. 
    - Nếu xóa gây mất cân bằng, thực hiện xoay và đổi màu để duy trì thuộc tính Red-black Tree.

7. AVL Tree là gì? Có ưu điểm và nhược điểm gì?
- Answer:
  - AVL Tree là cây nhị phân tìm kiếm tự cân bằng, đảm bảo độ cao của hai nhánh con không chênh lệch quá 1. 
  - Ưu điểm:
    - Tìm kiếm nhanh hơn Red-black Tree trong một số trường hợp vì độ cao thấp hơn. 
    - Phù hợp với dữ liệu tĩnh, ít thay đổi. 
  - Nhược điểm:
    - Cần nhiều phép quay hơn Red-black Tree khi thêm/xoá phần tử nên chậm hơn với dữ liệu thay đổi nhiều.

8. B-Tree là gì? Được sử dụng như thế nào?
- Answer:
  - B-Tree là một cấu trúc cây cân bằng tổng quát, cho phép mỗi node có nhiều hơn 2 con, thường dùng trong cơ sở dữ liệu và hệ thống tệp. 
  - Đặc điểm:
    - Giữ dữ liệu cân bằng khi chèn/xoá phần tử. 
    - Giảm số lần truy cập đĩa trong cơ sở dữ liệu. 
  - Ứng dụng:
    - Dùng trong hệ thống quản lý cơ sở dữ liệu (DBMS) như MySQL, Oracle. 
    - Dùng trong hệ thống file (NTFS, HFS+). 
    - Tăng hiệu suất tìm kiếm và lưu trữ dữ liệu lớn.
