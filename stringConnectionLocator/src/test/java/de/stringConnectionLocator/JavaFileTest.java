package de.stringConnectionLocator;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class JavaFileTest {
	private static final String FILE = "U:\\git\\ownrepos\\home\\explorer\\src\\main\\java\\files\\explorer\\BackendDataDto.java";
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
		javaFile = JavaFile.parse(FILE);
		Set<String> types = javaFile.getPublicReturnTypes();
		assertThat(types).contains("Vector");
	}

	@Test
	public void getMethodsWithoutGenerics() throws Exception {
		javaFile = JavaFile.parse(FILE);
		Set<MethodSignature> types = javaFile.getMethodsWithoutGenerics();
		assertThat(types).isEqualTo("");
	}

	@Test
	public void getGetters() throws Exception {
		javaFile = JavaFile.parse(FILE);
		Set<MethodSignature> types = javaFile.getGetters();
		assertThat(types).isEqualTo("");
	}

	@Test
	public void getGetters_Zuweisung() throws Exception {
		javaFile = JavaFile.parse(
				"C:\\Users\\pwegner\\eemweb-gitrepos\\EEMWebMigrator\\commons-migrator\\src\\main\\java\\de\\etengo\\eemweb\\commons\\migrator\\domain\\abrechnung\\BelegPosition.java");
		Set<MethodSignature> types = javaFile.getGetters();
		for (MethodSignature methodSignature : types) {
			System.out.println("result.set" + methodSignature.getName().substring(3) + "(entity."
					+ methodSignature.getName() + "());");
		}
		assertThat(types).isEqualTo("");
	}

	@Test
	public void getConstructors() throws Exception {
		javaFile = JavaFile.parse(FILE);
		Set<MethodSignature> types = javaFile.getConstructors();
		assertThat(types).isEqualTo("");
	}
}
