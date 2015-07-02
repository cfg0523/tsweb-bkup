package com.techsen.tsweb.sys.util;

import java.util.HashMap;
import java.util.Map;

import com.techsen.tsweb.core.domain.BaseObject;

public class JsonResult extends BaseObject<Object> {
    private static final long serialVersionUID = -444753657973216182L;
    
    private boolean success = true;
	private Object entity;
	private Map<String, String> messages;

	public JsonResult(){
	}
	
	public JsonResult(Object entity){
		this.entity = entity;
	}
	
	public JsonResult appendMessage(String key, String message){
		if(this.messages == null){
			this.messages = new HashMap<String, String>();
		}
		this.messages.put(key, message);
		return this;
	}
	
	public boolean isSuccess() {
		return success;
	}

	public JsonResult setSuccess(boolean success) {
		this.success = success;
		return this;
	}

	public Object getEntity() {
		return entity;
	}

	public JsonResult setEntity(Object entity) {
		this.entity = entity;
		return this;
	}

	public Map<String, String> getMessages() {
		return messages;
	}

	public JsonResult setMessages(Map<String, String> messages) {
		this.messages = messages;
		return this;
	}

}
