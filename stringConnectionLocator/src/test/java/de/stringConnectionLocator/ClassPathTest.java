package de.stringConnectionLocator;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;

import org.junit.Test;

public class ClassPathTest {

	@Test
	public void toClassPath() throws Exception {
		ClassPath classPath = ClassPath.toClassPath(
				new File("C:\\Users\\Pieed\\git\\bermuda\\einScheiss\\src\\main\\java\\bermuda\\main\\Anwendung.java")
						.toPath());

		assertThat(classPath).isEqualTo("bermuda.main.Anwendung");
	}

	@Test
	public void hasSamePackage() throws Exception {
		ClassPath classPath = ClassPath.toClassPath(
				"C:\\Users\\Pieed\\git\\bermuda\\einScheiss\\src\\main\\java\\bermuda\\main\\Anwendung.java");

		ClassPath classPath2 = ClassPath.toClassPath(
				"C:\\Users\\Pieed\\git\\bermuda\\einScheiss\\src\\main\\java\\bermuda\\main\\Anwendung.java");
		boolean b = classPath.hasSamePackage(classPath2);
		assertThat(b).isEqualTo(true);
	}

	@Test
	public void hasSamePackage_False() throws Exception {
		ClassPath classPath = ClassPath
				.toClassPath("C:\\Users\\Pieed\\git\\home\\RocketLearn\\src\\model\\AbstractBody.java");

		ClassPath classPath2 = ClassPath
				.toClassPath("C:\\Users\\Pieed\\git\\home\\RocketLearn\\src\\controller\\RocketLearnApp.java");
		assertThat(classPath.hasSamePackage(classPath2)).isEqualTo(false);
	}
}
