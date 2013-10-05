package javaversion;


public class JavaVersion {	
	int familyNumber = 0;
	int updateNumber = 0;

	public JavaVersion(int familyNumber, int updateNumber) {
		this.familyNumber =familyNumber;
		this.updateNumber = updateNumber;
	}

	public int getFamilyNumber() {
		return familyNumber;
	}

	public int getUpdateNumber() {
		return updateNumber;
	}
		

}
