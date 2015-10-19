package com.yxtar.app.shared.enums;

public enum MobileNumberCheckReason {
//	0001 - mobile number already exist
//	0002 - invalid mobile number 
//	0003 - SMS code requested too frequently
//	0004 - Forget password usage - mobile not exists
		MobileNumberExist("0001"),
		InvalidMobileNumber("0002"),
		SMSCodeRequestedTooFrequently("0003"),
		MobileNotExists("0004"),
		
		;
		
		private String type;

		public String getType() {
			return type;
		}

		private MobileNumberCheckReason(String type) {
			this.type = type;
		}
}
