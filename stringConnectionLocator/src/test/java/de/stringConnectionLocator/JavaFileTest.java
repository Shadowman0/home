package de.stringConnectionLocator;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class JavaFileTest {
	private static final String FILE = "C:\\Users\\Pieed\\git\\home\\RocketLearn\\src\\model\\Planet.java";
	private static final String FILE2 = "C:\\Users\\Pieed\\git\\home\\RocketLearn\\src\\model\\SimpleBody.java";
	private ClassPath path;
	private JavaFile javaFile;

	@Before
	public void setUp() throws IOException {
		javaFile = JavaFile.parse(FILE);

	}

	@Test
	public void classPathAndFilePathCorrect() throws Exception {
		assertThat(javaFile.getFilePath().toString()).isEqualTo(FILE);
		assertThat(javaFile.getClassPath().toString()).isEqualTo("model.Planet");

	}

	@Test
	public void getImports() throws Exception {
		List<String> imports = javaFile.getImports();
		assertThat(imports).isEqualTo("");
	}

	@Test
	public void getGetReturnTypes() throws Exception {
		List<String> types = javaFile.getGetReturnTypes();
		assertThat(types).isEqualTo("");
	}

	@Test
	public void getPublicReturnPrimitives() throws Exception {
		Set<String> types = javaFile.getPublicReturnPrimitives();
		assertThat(types).contains("double", "boolean");
	}

	@Test
	public void getPublicReturnTypes() throws Exception {
		javaFile = JavaFile.parse(FILE2);
		Set<String> types = javaFile.getPublicReturnTypes();
		assertThat(types).contains("Vector");
	}
}
