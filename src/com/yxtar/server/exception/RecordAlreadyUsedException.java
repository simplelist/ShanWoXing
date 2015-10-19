package com.yxtar.server.exception;

import com.yxtar.app.shared.enums.DailyCampFailReason;
import com.yxtar.server.service.impl.CharityCampServiceImpl;

public class RecordAlreadyUsedException extends Throwable {
	/**
	 * 
	 */
	private final CharityCampServiceImpl RecordAlreadyUsedException;

	public RecordAlreadyUsedException(CharityCampServiceImpl charityCampServiceImpl) {
		super(DailyCampFailReason.LocationAlreadyUsed.getType());
		RecordAlreadyUsedException = charityCampServiceImpl;
	}
}