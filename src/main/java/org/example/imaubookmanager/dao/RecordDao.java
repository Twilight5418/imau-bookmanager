package org.example.imaubookmanager.dao;

import org.apache.ibatis.annotations.Mapper;
import org.example.imaubookmanager.pojo.Record;
import java.util.List;
@Mapper
public interface RecordDao {

    // 根据 ID 查询借阅记录
    Record selectRecordById(int id);

    // 查询所有借阅记录
    List<Record> selectAllRecords();

    // 插入新的借阅记录
    int insertRecord(Record record);

    // 更新借阅记录
    int updateRecord(Record record);

    // 根据 ID 删除借阅记录
    int deleteRecordById(int id);
}
