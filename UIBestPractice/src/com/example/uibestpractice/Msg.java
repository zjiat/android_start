package com.example.uibestpractice;

import android.R.integer;
import android.support.annotation.IntRange;

public class Msg {

	public static final int TYPE_RECEIVED = 0;
	public static final int TYPE_SEND = 1;
	
	private String content;
	private int type;
	
	public Msg(String content, int type) {
		super();
		this.content = content;
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public int getType() {
		return type;
	}
}
