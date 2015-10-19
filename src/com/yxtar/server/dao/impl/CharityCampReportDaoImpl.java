package com.yxtar.server.dao.impl;

import org.springframework.stereotype.Service;

import com.yxtar.server.dao.CharityCampReportDao;
import com.yxtar.server.dto.CharityCampReport;

@Service("charityCampReportDao")
public class CharityCampReportDaoImpl extends BaseDaoImpl<CharityCampReport, Integer> implements CharityCampReportDao {
}
