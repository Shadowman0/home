package de.stringConnectionLocator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import net.karneim.pojobuilder.GeneratePojoBuilder;

public class JavaFile {
	private List<String> content = new ArrayList<>();
	private ClassPath classPath;
	private Path filePath;

	public Path getFilePath() {
		return filePath;
	}

	public void setFilePath(Path filePath) {
		this.filePath = filePath;
	}

	public List<String> getContent() {
		return content;
	}

	public String getContentAsString() {
		StringBuilder result = new StringBuilder();
		for (String line : content) {
			result.append(line);
		}
		return result.toString();
	}

	public void setContent(List<String> content) {
		this.content = content;
	}

	public ClassPath getClassPath() {
		return classPath;
	}

	public void setClassPath(ClassPath classPath) {
		this.classPath = classPath;
	}

	@GeneratePojoBuilder(withFactoryMethod = "aJavaFile")
	public JavaFile(List<String> content, ClassPath classPath, Path filePath) {
		this.content = content;
		this.classPath = classPath;
		this.filePath = filePath;
	}

	public List<String> getImports() {
		List<String> imports = content.stream().filter(line -> line.startsWith("import")).map(line -> {
			return line.substring("import ".length(), line.length() - 1);
		}).collect(Collectors.toList());
		return imports;
	}

	public static JavaFile parse(String file) throws IOException {
		ClassPath path = ClassPath.toClassPath(file);
		List<String> content = Files.readAllLines(path.getPath());
		return JavaFileBuilder.aJavaFile().withContent(content).withClassPath(path).withFilePath(path.getPath())
				.build();
	}

	public static JavaFile parse(Path path) throws IOException {
		ClassPath classpath = ClassPath.toClassPath(path);
		List<String> content = Files.readAllLines(path);
		return JavaFileBuilder.aJavaFile().withContent(content).withClassPath(classpath).withFilePath(path).build();
	}

	@Override
	public String toString() {
		return classPath.toString();
	}

	public boolean uses(JavaFile javaFile) {
		return getContentAsString().matches(".*\\b" + javaFile.getClassPath().getClassName() + "\\b.*");
	}

}
