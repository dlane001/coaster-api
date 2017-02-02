package com.example.services;

import java.util.LinkedHashMap;
import java.util.Map;

public class UserService {
	static Map<String, Map<String, String>> userMap;
	public static Map<String, String> getUserByID(String id){
		if (userMap.containsKey(id)){
			return userMap.get(id);
		}else{
			Map<String, String> empty = new LinkedHashMap();
			empty.put("NoUser", "");
			return empty;
		}
	}
	
	public static void populateMockUsers(){
		
	}
}
