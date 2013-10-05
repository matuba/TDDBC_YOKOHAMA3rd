package javaversion;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import org.specs2.internal.scalaz.std.util.parsing.combinator.parser;
public class JavaVersionUtils {

	public static boolean isValid(String version) {
		Pattern p = Pattern.compile("^JDK[0-9]+u[0-9]+$");
		Matcher m = p.matcher(version);
		return m.find();
	}
	
	public static JavaVersion parse(String version) {
		if(!isValid(version)) {
			throw new IllegalArgumentException();
		}
		String familyAndUpdate = version.substring(3);
		String[] numbers = familyAndUpdate.split("u");

		int familyNumber = Integer.parseInt(numbers[0]);
		int updateNumber = Integer.parseInt(numbers[1]);
		
		return new JavaVersion( familyNumber, updateNumber);
	}

}
