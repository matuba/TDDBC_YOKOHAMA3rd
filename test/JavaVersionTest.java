import static org.junit.Assert.*;
import javaversion.JavaVersion;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class JavaVersionTest {
	@Test
	public void JDK7u40と入力したらTRUEを返す() {
		JavaVersion javaVersion = new JavaVersion();
		assertThat(javaVersion.isValid("JDK7u40"), is(true));
	}
	@Test
	public void hogeと入力したらFALSEを返す() {
		JavaVersion javaVersion = new JavaVersion();
		assertThat(javaVersion.isValid("hoge"), is(false));
	}
	@Test
	public void JDK7u9xと入力したらFALSEを返す() {
		JavaVersion javaVersion = new JavaVersion();
		assertThat(javaVersion.isValid("JDK7u9x"), is(false));
	}
	@Test
	public void JDK740と入力したらFALSEを返す() {
		JavaVersion javaVersion = new JavaVersion();
		assertThat(javaVersion.isValid("JDK740"), is(false));
	}
	@Test
	public void JDK10u100と入力したらTRUEを返す() {
		JavaVersion javaVersion = new JavaVersion();
		assertThat(javaVersion.isValid("JDK10u100"), is(true));
	}

}
