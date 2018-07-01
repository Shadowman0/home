package de.stringConnectionLocator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

	public List<String> getGetReturnTypes() {
		ArrayList<String> result = new ArrayList<>();
		Matcher m = Pattern.compile(".?public \\b(\\w+)\\b get[A-Z].?").matcher(getContentAsString());
		while (m.find()) {
			result.add(m.group(1));
		}
		return result;
	}

	public Set<String> getPublicReturnPrimitives() {
		Set<String> result = new HashSet<>();
		Matcher m = Pattern.compile(".?public \\b([a-z]+\\w?)\\b \\w+.?").matcher(getContentAsString());
		while (m.find()) {
			if (!m.group(1).equals("class") && !m.group(1).equals("void")) {
				result.add(m.group(1));
			}
		}
		return result;
	}

	public Set<String> getPublicReturnTypes() {
		Set<String> result = new HashSet<>();
		Matcher m = Pattern.compile(".?public \\b([A-Z]\\w*)\\b \\w+.?").matcher(getContentAsString());
		while (m.find()) {
			if (!m.group(1).equals("class")) {
				result.add(m.group(1));
			}
		}
		return result;
	}

	public Set<MethodSignature> getMethodsWithoutGenerics() {
		Set<MethodSignature> result = new HashSet<>();
		Matcher m = Pattern.compile("\\s*((public|private|))\\s*(\\b\\w*\\b)\\s*(\\w+?)[(](\\w*?\\s*?\\w*?)?[)]\\s[{]")
				.matcher(getContentAsString());
		while (m.find()) {
			if (!m.group(3).equals(classPath.getClassName())) {
				MethodSignature methodSignature = new MethodSignature();
				methodSignature.setModifiers(m.group(2));
				methodSignature.setReturnType(m.group(3));
				methodSignature.setName(m.group(4));
				methodSignature.setParameters(m.group(5).split(","));
				result.add(methodSignature);
			}
		}
		return result;
	}

	public Set<MethodSignature> getGetters() {
		Set<MethodSignature> getters = getMethodsWithoutGenerics().stream().filter(MethodSignature::isGetter)
				.collect(Collectors.toSet());
		return getters;
	}

	public Set<MethodSignature> getConstructors() {
		Set<MethodSignature> result = new HashSet<>();
		Matcher m = Pattern.compile("\\s*((public|private|))\\s*(SimpleBody)[(](.*?)?[)]\\s[{]")
				.matcher(getContentAsString());
		while (m.find()) {
			if (!m.group(3).equals(classPath.getClassName())) {
				MethodSignature methodSignature = new MethodSignature();
				methodSignature.setModifiers(m.group(2));
				methodSignature.setReturnType(m.group(3));
				methodSignature.setName(m.group(3));
				// methodSignature.setParameters(m.group(4).split(","));
				result.add(methodSignature);
			}
		}
		return result;
	}

}
