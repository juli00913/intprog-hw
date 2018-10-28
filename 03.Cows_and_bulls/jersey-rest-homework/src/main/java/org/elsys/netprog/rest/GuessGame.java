package org.elsys.netprog.rest;

public class GuessGame {

	private int cowsNumbers;
	
	private int bullsNumbers;
	
	private String guessNum;
	
	public GuessGame(String guessNum) {
		this.cowsNumbers = 0;
		this.bullsNumbers = 0;
		this.guessNum = guessNum;
	}

	public int getCowsNumbers() {
		return cowsNumbers;
	}

	public void setCowsNumbers(int cowsNumbers) {
		this.cowsNumbers = cowsNumbers;
	}

	public int getBullsNumbers() {
		return bullsNumbers;
	}

	public void setBullsNumbers(int bullsNumbers) {
		this.bullsNumbers = bullsNumbers;
	}

	public String getGuessNum() {
		return guessNum;
	}

	public void setGuessNum(String guessNum) {
		this.guessNum = guessNum;
	}
	

}
