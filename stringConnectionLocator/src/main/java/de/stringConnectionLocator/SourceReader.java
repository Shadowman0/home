package de.stringConnectionLocator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class SourceReader {

	public List<Path> getAllJavaFileNames(String filepath) throws IOException {
		return Files.walk(Paths.get(filepath)).filter(Files::isRegularFile).collect(Collectors.toList());
	}

	public HashMap<String, JavaFile> readFilesToFileMap(String filepath) throws IOException {
		List<Path> javaFiles = getAllJavaFileNames(filepath);
		HashMap<String, JavaFile> hashMap = new HashMap<>();
		for (Path path : javaFiles) {
			JavaFile javaFile = JavaFile.parse(path);
			hashMap.put(javaFile.getClassPath().toString(), javaFile);
		}
		return hashMap;
	}

	public HashMap<String, List<JavaFile>> readFilesToPackageMap(String filepath) throws IOException {
		List<Path> javaFiles = getAllJavaFileNames(filepath);
		HashMap<String, List<JavaFile>> hashMap = new HashMap<>();
		for (Path path : javaFiles) {
			JavaFile javaFile = JavaFile.parse(path);
			hashMap.compute(javaFile.getClassPath().getPackagename(), (packagename, oldlist) -> {
				if (oldlist == null) {
					oldlist = new ArrayList<>();
				}
				oldlist.add(javaFile);
				return oldlist;
			});
		}
		return hashMap;
	}

	public HashMap<JavaFile, List<JavaFile>> createSamePackageUsageMap(String filepath) throws IOException {
		HashMap<JavaFile, List<JavaFile>> result = new HashMap<>();
		HashMap<String, List<JavaFile>> packageMap = readFilesToPackageMap(filepath);
		for (List<JavaFile> packagecontent : packageMap.values()) {
			for (JavaFile javaFile : packagecontent) {
				for (JavaFile otherJavafile : packagecontent) {
					if (javaFile.uses(otherJavafile) && !javaFile.equals(otherJavafile)) {
						result.compute(javaFile, (filenameKey, oldlist) -> {
							if (oldlist == null) {
								oldlist = new ArrayList<>();
							}
							oldlist.add(otherJavafile);
							return oldlist;
						});
					}
				}

			}
		}
		return result;
	}

}
