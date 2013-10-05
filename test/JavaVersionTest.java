import static org.junit.Assert.*;
import javaversion.JavaVersion;
import javaversion.JavaVersionUtils;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class JavaVersionTest {

	@Test
	public void JDK7u40とJDK7u51をltで比較した場合trueが返る() {
		JavaVersion src = new JavaVersion(7, 40);
		JavaVersion des = new JavaVersion(7, 51);
		assertThat( src.lt(des), is(true));
	}

	@Test
	public void JDK7u51とJDK7u40をltで比較した場合falseが返る() {
		JavaVersion src = new JavaVersion(7, 51);
		JavaVersion des = new JavaVersion(7, 40);
		assertThat( src.lt(des), is(false));
	}
	
	@Test
	public void JDK7u40とJDK8u40をltで比較した場合trueが返る() {
		JavaVersion src = new JavaVersion(7, 40);
		JavaVersion des = new JavaVersion(8, 40);
		assertThat( src.lt(des), is(true));
	}
	@Test
	public void JDK8u40とJDK7u40をltで比較した場合falseが返る() {
		JavaVersion src = new JavaVersion(8, 40);
		JavaVersion des = new JavaVersion(7, 40);
		assertThat( src.lt(des), is(false));
	}
	
	@Test
	public void JDK7u40とJDK7u40をltで比較した場合falseが返る() {
		JavaVersion src = new JavaVersion(7, 40);
		JavaVersion des = new JavaVersion(7, 40);
		assertThat( src.lt(des), is(false));
	}

	@Test
	public void JDK8u40とJDK7u40をgtで比較した場合trueが返る() {
		JavaVersion src = new JavaVersion(8, 40);
		JavaVersion des = new JavaVersion(7, 40);
		assertThat( src.gt(des), is(true));
	}
	@Test
	public void JDK7u40とJDK7u40をgtで比較した場合falseが返る() {
		JavaVersion src = new JavaVersion(7, 40);
		JavaVersion des = new JavaVersion(7, 40);
		assertThat( src.gt(des), is(false));
	}

	@Test
	public void nextSecurityUpdateを実行するとupdateNumberが1加算したJavaVersionオブジェクトを返す() {
		JavaVersion src = new JavaVersion(7, 40);
		JavaVersion des = src.nextSecurityUpdate();
		assertThat( des.getUpdateNumber(), is(41));
	}
	@Test
	public void JDK7u40の場合nextLimitedUpdateを実行するとupdateNumberが60のJavaVersionオブジェクトを返す() {
		JavaVersion src = new JavaVersion(7, 40);
		JavaVersion des = src.nextLimitedUpdate();
		assertThat( des.getUpdateNumber(), is(60));
	}
	
	@Test
	public void JDK7u61の場合nextLimitedUpdateを実行するとupdateNumberが80のJavaVersionオブジェクトを返す() {
		JavaVersion src = new JavaVersion(7, 61);
		JavaVersion des = src.nextLimitedUpdate();
		assertThat( des.getUpdateNumber(), is(80));
	}

	@Test
	public void JDK8u1の場合nextLimitedUpdateを実行するとupdateNumberが20のJavaVersionオブジェクトを返す() {
		JavaVersion src = new JavaVersion(8, 1);
		JavaVersion des = src.nextLimitedUpdate();
		assertThat( des.getUpdateNumber(), is(20));
	}
	
	@Test
	public void JDK7u40の場合nextCriticalPatchUpdateを実行するとupdateNumberが45のJavaVersionオブジェクトを返す() {
		JavaVersion src = new JavaVersion(7, 40);
		JavaVersion des = src.nextCriticalPatchUpdate();
		assertThat( des.getUpdateNumber(), is(45));
	}
	@Test
	public void JDK7u11の場合nextCriticalPatchUpdateを実行するとupdateNumberが15のJavaVersionオブジェクトを返す() {
		JavaVersion src = new JavaVersion(7, 11);
		JavaVersion des = src.nextCriticalPatchUpdate();
		assertThat( des.getUpdateNumber(), is(15));
	}

	@Test
	public void JDK7u16の場合nextCriticalPatchUpdateを実行するとupdateNumberが21のJavaVersionオブジェクトを返す() {
		JavaVersion src = new JavaVersion(7, 16);
		JavaVersion des = src.nextCriticalPatchUpdate();
		assertThat( des.getUpdateNumber(), is(21));
	}
}
