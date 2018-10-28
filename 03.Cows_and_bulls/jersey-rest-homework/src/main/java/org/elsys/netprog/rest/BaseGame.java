package org.elsys.netprog.rest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class BaseGame {

	private String uniqueID;
	
	private int turnsCount;
	
	private boolean success;
	
	private String secretNum;
	
	public BaseGame() {
		uniqueID = UUID.randomUUID().toString();
		turnsCount = 0;
		success = false;
		
		secretNum = generateSecretNum();
	}

	public int getTurnsCount() {
		return turnsCount;
	}

	public void setTurnsCount(int turnsCount) {
		this.turnsCount = turnsCount;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getUniqueID() {
		return uniqueID;
	}
	
	public String generateSecretNum() {
		List<Integer> numbers = new ArrayList<Integer>();
	    for(int i = 0; i < 10; i++){
	        numbers.add(i);
	    }

	    Collections.shuffle(numbers);
	    
	    String result = "";
	    for(int i = 0; i < 4; i++){
	        result += numbers.get(i).toString();
	    }
		
		return result;
	}
}
