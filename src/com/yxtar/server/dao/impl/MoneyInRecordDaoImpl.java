package com.yxtar.server.dao.impl;

import org.springframework.stereotype.Service;

import com.yxtar.server.dao.MoneyInRecordDao;
import com.yxtar.server.dto.MoneyInRecord;

@Service("moneyInRecordDao")
public class MoneyInRecordDaoImpl extends BaseDaoImpl<MoneyInRecord, Integer> implements MoneyInRecordDao {
}
