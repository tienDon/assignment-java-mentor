
# Week 1: Git

1. Git thực sự lưu trữ dữ liệu như thế nào? Các đối tượng (objects) như blob, tree, commit, và tag có quan hệ gì với nhau trong hệ thống lưu trữ phân tán của Git?

- Answer:
  - Git lưu dưới dạng snapshots, ở thời điểm đó repo đang ở trang thái như nào thế được lưu như thế.
  - Git lưu trữ data sử dụng SHA-1 hashes để bảo toàn tính toàn vẹn.
  - Blob chứa nội dung file. 
  - Tree chứa danh sách blob và các tree con (thư mục). 
  - Commit trỏ đến tree, đại diện cho trạng thái của repository. 
  - Tag trỏ đến commit để đánh dấu phiên bản.

2. Khi ta di chuyển giữa các commit, Git làm gì dưới lớp vỏ bọc của nó? HEAD thực chất là gì và nó tác động thế nào đến trạng thái hiện tại của repository?

- Answer: 
  - khi checkout git sẽ tham chiếu head đến phần dc commit hoặc 1 branch.
  - HEAD là một con trỏ đặc biệt trong Git, trỏ đến commit hoặc branch mà bạn đang làm việc tại thời điểm hiện tại. Nó đóng vai trò quan trọng trong việc xác định trạng thái hiện tại của repository.

3. Git có thể tạo hàng nghìn nhánh (branches) gần như tức thì mà không tốn tài nguyên. Điều này hoạt động ra sao về mặt kỹ thuật, và tại sao việc hợp nhất (merge) đôi khi lại dẫn đến xung đột?

- Answer:
  - Git hoạt động dựa trên cấu trúc dữ liệu DAG (Directed Acyclic Graph – Đồ thị có hướng không chu trình).
  - Khi tạo 1 nhánh mới git ko tạo 1 bản sao cho 1 dữ liệu mà chỉ tạo 1 ref mới. Git chỉ thực sự lưu trữ khi có commit thay đổi mới hoặc checkout 1 nhánh khác để phản ánh trạng thái mới nhất trên commit đó.
  - Khi merge xảy ra xung đột bởi vì cùng 1 file có 2 cách sửa ở 2 nhánh khác nhau.

4. Khi ta thêm file vào staging area, thực chất Git làm gì? Điều gì thực sự thay đổi khi ta chạy lệnh git commit?

- Answer:
  - Khi chạy lệnh git add . thì git sẽ lưu lại trạng thái hiện tại của file vào staging area(index). Chỉ lưu lại file đã thay đổi gì chứ chưa được lưu vào lịch sử Git.
  - Khi chạy lệnh git commit -m "" thì Git sẽ lưu commit này lại và cập nhật HEAD

5. Git phân biệt working directory, staging area và repository như thế nào? Tại sao có những thay đổi được theo dõi nhưng chưa được commit?

- Answer:
  - Working Directory (Thư mục làm việc)
    - nơi chứa tất cả các file của dự án
    - Khi chỉnh sửa, thêm, xóa file, các thay đổi sẽ xảy ra trong thư mục này.
  - Staging Area (Khu vực tạm / Index)
    - nơi Git lưu trữ các thay đổi mà bạn đã chọn để commit.
    - Khi chạy git add <file>, Git sẽ đưa file đó vào Staging Area.
    - Staging giúp nhóm các thay đổi trước khi commit, tránh commit những thay đổi chưa hoàn chỉnh.
  - Repository (Kho lưu trữ / Local Repo)
    - Khi chạy git commit, tất cả các thay đổi trong Staging Area sẽ được ghi vào repository.
    - Repository lưu trữ lịch sử commit cùng với mã SHA-1 duy nhất cho từng commit.
    - Sau khi commit, trạng thái của các file được đánh dấu là committed.
  - có những thay đổi được theo dõi nhưng chưa được commit:
    - File đã bị chỉnh sửa nhưng chưa được đưa vào Staging Area
      - Khi thay đổi một file, Git sẽ coi nó là modified nhưng chưa đưa vào Staging. Kiểm tra bằng cách sử dụng git status.
    - File đã được đưa vào Staging nhưng chưa commit
      - Sau khi dùng git add, file sẽ nằm trong Staging Area nhưng chưa được commit.

6. Git lưu trữ thay đổi của ta ở đâu? Làm thế nào Git có thể khôi phục những thay đổi đã bị "stash" một cách chính xác?

- Answer:
  - Git lưu trữ tất cả các thay đổi trong thư mục .git
    - .git/objects/ :  lưu trữ nội dung file
    - .git/index: Chứa danh sách các file đã được staged (git add).
    - .git/HEAD: Con trỏ theo dõi commit hiện tại của branch.
    - .git/refs/stash: git stash lưu lại thay đổi chưa commit bằng cách tạo một commit tạm thời.
  - Khi bạn chạy lệnh git stash, Git sẽ lưu lại tất cả các thay đổi trong working directory và index (staging area) vào một khu vực lưu trữ tạm thời gọi là stash stack. Working directory và index của bạn sẽ trở về trạng thái của commit cuối cùng.
  - Bạn có thể lưu nhiều mục stash khác nhau, mỗi mục được lưu trong một stack.
  - Khi bạn cần áp dụng lại các thay đổi đã lưu trữ, bạn có thể sử dụng các lệnh như git stash apply hoặc git stash pop.

7. Khi xảy ra xung đột hợp nhất (merge conflict), tại sao Git không thể tự động giải quyết? Git sử dụng cơ chế nào để xác định sự khác biệt và yêu cầu sự can thiệp của lập trình viên?

- Answer:
  - Git không thể tự động chọn vì cùng một dòng code bị thay đổi theo hai cách khác nhau trên hai branch. Nó không thể biết đâu là phiên bản đúng, nên cần lập trình viên chọn thủ công.
  - Git sử dụng thuật toán so sánh ba chiều (three-way merge)
    - Base version – phiên bản gốc trước khi tách branch.
    - Current version – phiên bản trên branch hiện tại (HEAD).
    - Incoming version – phiên bản từ branch đang merge vào.

8.  Git duy trì lịch sử commit như thế nào? Cấu trúc cây (tree structure) của Git giúp tối ưu hóa việc theo dõi và truy xuất lịch sử ra sao?

- Answer:
  - Git sử dụng cấu trúc dữ liệu DAG (Directed Acyclic Graph – Đồ thị có hướng không chu trình).
  - Cấu trúc cây (tree structure) của Git giúp tối ưu hóa việc theo dõi và truy xuất lịch sử bằng cách tổ chức dữ liệu thành một hệ thống địa chỉ nội dung dựa trên mã băm SHA-1.
  - Khi một cây (tree) được tạo trong bộ nhớ, Git tính toán mã SHA-1 của nó, sau đó nén bằng Zlib và lưu vào kho đối tượng (object store) dưới dạng một đối tượng rời (loose object).

9. Những lệnh này khác nhau như thế nào về bản chất? Tại sao git reset --hard có thể gây mất dữ liệu nhưng git revert thì không?

- Answer:
  - git reset --hard
    - Lệnh này đưa nhánh hiện tại trở về một commit trước đó, đồng thời xóa sạch các thay đổi trong cả Staging Area và Working Directory.
    - Các thay đổi không được commit sẽ bị mất vĩnh viễn, trừ khi có thể khôi phục từ git reflog.
  - git revert
    - Lệnh này tạo một commit mới để đảo ngược thay đổi của một commit cụ thể, thay vì xóa commit đó.
    - Lịch sử commit vẫn còn đầy đủ, giúp dễ dàng theo dõi những gì đã thay đổi

10. Khi dùng git commit --amend, Git thực sự làm gì? Nó có chỉnh sửa commit cũ không, hay tạo ra một commit hoàn toàn mới?

- Answer:
  - Git không chỉnh sửa commit cũ mà thực chất tạo ra một commit hoàn toàn mới với nội dung đã được sửa đổi.
  - Commit mới này thay thế commit trước đó, nhưng commit cũ vẫn tồn tại trong lịch sử (có thể truy vết qua git reflog)
  - 