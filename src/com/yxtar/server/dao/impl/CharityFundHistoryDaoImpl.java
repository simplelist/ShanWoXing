package com.yxtar.server.dao.impl;

import org.springframework.stereotype.Service;

import com.yxtar.server.dao.CharityFundHistoryDao;
import com.yxtar.server.dto.CharityFundHistory;

@Service("charityFundHistoryDao")
public class CharityFundHistoryDaoImpl extends BaseDaoImpl<CharityFundHistory, Integer> implements CharityFundHistoryDao {
}
