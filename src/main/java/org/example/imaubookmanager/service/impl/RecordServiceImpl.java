package org.example.imaubookmanager.service.impl;

import org.example.imaubookmanager.dao.RecordDao;
import org.example.imaubookmanager.pojo.Record;
import org.example.imaubookmanager.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordDao recordDao;

    @Override
    public Record getRecordById(int id) {
        return recordDao.selectRecordById(id);
    }

    @Override
    public List<Record> getAllRecords() {
        return recordDao.selectAllRecords();
    }

    @Override
    public int createRecord(Record record) {
        return recordDao.insertRecord(record);
    }

    @Override
    public int updateRecord(Record record) {
        return recordDao.updateRecord(record);
    }

    @Override
    public int deleteRecordById(int id) {
        return recordDao.deleteRecordById(id);
    }
}
