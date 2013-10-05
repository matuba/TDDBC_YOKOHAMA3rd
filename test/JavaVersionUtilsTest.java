import static org.junit.Assert.*;
import javaversion.JavaVersion;
import javaversion.JavaVersionUtils;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

import org.junit.Test;

public class JavaVersionUtilsTest {
	@Test
	public void JDK7u40と入力したらTRUEを返す() {
		assertThat(JavaVersionUtils.isValid("JDK7u40"), is(true));
	}
	@Test
	public void hogeと入力したらFALSEを返す() {
		assertThat(JavaVersionUtils.isValid("hoge"), is(false));
	}
	@Test
	public void JDK7u9xと入力したらFALSEを返す() {
		assertThat(JavaVersionUtils.isValid("JDK7u9x"), is(false));
	}
	@Test
	public void JDK740と入力したらFALSEを返す() {
		assertThat(JavaVersionUtils.isValid("JDK740"), is(false));
	}
	@Test
	public void JDK10u100と入力したらTRUEを返す() {
		assertThat(JavaVersionUtils.isValid("JDK10u100"), is(true));
	}
	

	@Test(expected=IllegalArgumentException.class)
	public void parseに正しくないバージョン番号を渡したら例外となる() {
		JavaVersionUtils.parse("hoge");
	}
	@Test
	public void parseに正しいバージョン番号を渡したらNULL以外が返る() {
		assertThat(JavaVersionUtils.parse("JDK7u40"), notNullValue());
	}
	@Test
	public void parseにJDK7u40を渡したら返されるにJavaVersionオブジェクトのfamilyNumberに7が設定される() {
		JavaVersion javaVersion = JavaVersionUtils.parse("JDK7u40");
		assertThat(javaVersion.getFamilyNumber(), is(7));
	}

	@Test
	public void parseにJDK7u40を渡したら返されるにJavaVersionオブジェクトのupdateNumberに40が設定される() {
		JavaVersion javaVersion = JavaVersionUtils.parse("JDK7u40");
		assertThat(javaVersion.getUpdateNumber(), is(40));
	}
	
	@Test
	public void parseにJDK10u100を渡したら返されるにJavaVersionオブジェクトのfamilyNumberに10が設定される() {
		JavaVersion javaVersion = JavaVersionUtils.parse("JDK10u100");
		assertThat(javaVersion.getFamilyNumber(), is(10));
	}
	
	@Test
	public void parseにJDK10u100を渡したら返されるにJavaVersionオブジェクトのupdateNumberに100が設定される() {
		JavaVersion javaVersion = JavaVersionUtils.parse("JDK10u100");
		assertThat(javaVersion.getUpdateNumber(), is(100));
	}
	
}
