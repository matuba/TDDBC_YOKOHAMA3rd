package javaversion;

import play.api.libs.iteratee.internal;
import scala.remote;


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

	public Boolean lt(JavaVersion javaVersion) {
		
		if(familyNumber < javaVersion.getFamilyNumber()) {
			return true;
		} else if(familyNumber > javaVersion.getFamilyNumber()){
			return false;
		}
		if(updateNumber < javaVersion.getUpdateNumber()){
			return true;
		}
		return false;
	}

	public Boolean gt(JavaVersion des) {
		if(familyNumber == des.getFamilyNumber() && updateNumber == des.getUpdateNumber()) {
			return false;
		}
		return !lt(des);
	}

	public JavaVersion nextSecurityUpdate() {
		return new JavaVersion(familyNumber, updateNumber + 1);
	}

	public JavaVersion nextLimitedUpdate() {
		int rem = updateNumber % 20;	
		return new JavaVersion(familyNumber, updateNumber + (20 - rem));
	}

	public JavaVersion nextCriticalPatchUpdate() {
		int rem = this.updateNumber % 5;	
		int updateNumber = this.updateNumber + (5 - rem);
		if((updateNumber % 2) == 0){
			updateNumber++;
		}
		return new JavaVersion(familyNumber, updateNumber);
	}
		

}
