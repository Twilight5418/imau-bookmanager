package org.example.imaubookmanager.service;

import org.example.imaubookmanager.pojo.Record;
import java.util.List;

public interface RecordService {
    Record getRecordById(int id);
    List<Record> getAllRecords();
    int createRecord(Record record);
    int updateRecord(Record record);
    int deleteRecordById(int id);
}
