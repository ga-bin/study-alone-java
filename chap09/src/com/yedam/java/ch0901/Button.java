package com.yedam.java.ch0901;

public class Button {
	
	OnClickListener listner;
	void setOnClickListener(OnClickListener listner) {
		this.listner = listner;
	}
	
	void touch() {
		listner.onClick();
	}
	
	//
	static interface OnClickListener {
		void onClick();
	}
	

}
