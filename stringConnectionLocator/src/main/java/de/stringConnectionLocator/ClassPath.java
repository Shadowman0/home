package de.stringConnectionLocator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ClassPath {

	private String className;
	private String packagename;
	private static Path path;

	public static ClassPath toClassPath(String string) throws IOException {
		return ClassPath.toClassPath(new File(string).toPath());
	}

	public static ClassPath toClassPath(Path path) throws IOException {
		String firstLine = Files.readAllLines(path).get(0);
		ClassPath classPath = new ClassPath();
		classPath.path = path;
		classPath.packagename = firstLine.substring("package ".length(), firstLine.length() - 1);
		classPath.className = path.getFileName().toString().split("\\.")[0];
		return classPath;
	}

	public ClassPath() {
	}

	public Path getPath() {
		return path;
	}

	public void setPath(Path path) {
		this.path = path;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getPackagename() {
		return packagename;
	}

	public void setPackagename(String packagename) {
		this.packagename = packagename;
	}

	@Override
	public String toString() {
		return packagename + "." + className;
	}

	public boolean hasSamePackage(ClassPath otherClassPath) {
		return packagename.equals(otherClassPath.packagename);
	}

}
