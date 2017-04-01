package org.cleverframework.common;

import java.util.UUID;

public class ObjectId {

	
	public static String getNextId(){
		return UUID.randomUUID().toString().replaceAll("-","");
	}
}
