package com.yxtar.app.client;

import com.yxtar.app.base.activity.BaseRPCEngine;

public class ClientRpcRequestor extends BaseRPCEngine implements ClientRpcs {

	public ClientRpcRequestor() {
		super();
		for (int i = 0; i < this.localRelativeURLLst.length; i++) {
			processEntryPoint(this.localAsynSvcLst[i], this.localRelativeURLLst[i]);
		}
	}
}