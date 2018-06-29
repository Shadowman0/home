package de.stringConnectionLocator;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class JavaFileTest {
	private static final String FILE = "C:\\Users\\Pieed\\git\\home\\RocketLearn\\src\\model\\BodyList.java";
	private ClassPath path;
	private JavaFile javaFile;

	@Before
	public void setUp() throws IOException {
		path = ClassPath.toClassPath(FILE);
		List<String> content = Files.readAllLines(path.getPath());
		javaFile = JavaFileBuilder.aJavaFile().withContent(content).withClassPath(path).withFilePath(path.getPath())
				.build();
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
	public void sameFolder() throws Exception {

	}
}
