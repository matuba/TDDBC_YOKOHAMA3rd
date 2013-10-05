package javaversion;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class JavaVersion {

	public boolean isValid(String version) {
		Pattern p = Pattern.compile("^JDK[0-9]+u[0-9]+$");
		Matcher m = p.matcher(version);
		return m.find();
	}

}
