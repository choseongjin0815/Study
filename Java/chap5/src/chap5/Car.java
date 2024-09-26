package chap5;

public class Car {
	String carName;
	int carCC;
	int maxPerson;
	int wheelCnt;
	
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public int getCarCC() {
		return carCC;
	}
	public void setCarCC(int carCC) {
		this.carCC = carCC;
	}
	public int getMaxPerson() {
		return maxPerson;
	}
	public void setMaxPerson(int maxPerson) {
		this.maxPerson = maxPerson;
	}
	
	public int getWheelCnt() {
		return this.wheelCnt;
	}
	public void setWheelCnt(int wheelCnt) {
		this.wheelCnt = wheelCnt;
	}
}
