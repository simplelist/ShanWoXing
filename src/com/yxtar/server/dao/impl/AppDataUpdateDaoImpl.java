package com.yxtar.server.dao.impl;

import org.springframework.stereotype.Service;

import com.yxtar.server.dao.AppDataUpdateDao;
import com.yxtar.server.dto.AppDataUpdate;

@Service("appDataUpdateDao")
public class AppDataUpdateDaoImpl extends BaseDaoImpl<AppDataUpdate, Integer> implements AppDataUpdateDao {
}
