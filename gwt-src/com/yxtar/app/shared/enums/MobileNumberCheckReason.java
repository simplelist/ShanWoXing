package com.yxtar.app.shared.enums;

public enum MobileNumberCheckReason {
//	0001 - mobile number already exist
//	0002 - invalid mobile number 
//	0003 - SMS code requested too frequently
		MobileNumberExist("0001"),
		InvalidMobileNumber("0002"),
		SMSCodeRequestedTooFrequently("0002")
		;
		
		private String type;

		public String getType() {
			return type;
		}

		private MobileNumberCheckReason(String type) {
			this.type = type;
		}
}
