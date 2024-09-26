package org.example.imaubookmanager.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Record {
    private int id;          // 自增主键
    private int bookId;   // 书籍ID
    private String username;   // 用户ID
    private Date time;       // 借书时间
}
