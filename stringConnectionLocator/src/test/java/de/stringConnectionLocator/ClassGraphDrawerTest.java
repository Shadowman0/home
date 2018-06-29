package de.stringConnectionLocator;

import static guru.nidi.graphviz.model.Factory.graph;
import static guru.nidi.graphviz.model.Factory.node;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.engine.GraphvizJdkEngine;
import guru.nidi.graphviz.model.Graph;
import guru.nidi.graphviz.model.Node;

public class ClassGraphDrawerTest {
	private static final String FILEPATH = "C:\\Users\\Pieed\\git\\home\\RocketLearn\\src\\gui";

	@Test
	public void testName() throws Exception {
		ClassGraphDrawer classGraphDrawer = new ClassGraphDrawer();

		SourceReader sourceReader = new SourceReader();

		GraphvizJdkEngine graphvizJdkEngine = new GraphvizJdkEngine();
		Graphviz.useEngine(graphvizJdkEngine, graphvizJdkEngine);
		Graph g = graph("example1").directed();
		g = addImportEdges(sourceReader, g);
		g = addSamePackageUsageEdges(sourceReader, g);
		System.out.println(g.toString());
		Graphviz.fromGraph(g).render(Format.PNG).toFile(new File("example/ex1.png"));

	}

	private Graph addImportEdges(SourceReader sourceReader, Graph g) throws IOException {
		HashMap<String, JavaFile> hashMap = sourceReader.readFilesToFileMap(FILEPATH);
		for (String classname : hashMap.keySet()) {
			Node classNode = node(classname);
			for (String test : hashMap.get(classname).getImports()) {
				classNode = classNode.link(test);
			}
			g = g.with(classNode);
		}
		return g;
	}

	private Graph addSamePackageUsageEdges(SourceReader sourceReader, Graph g) throws IOException {
		HashMap<JavaFile, List<JavaFile>> samePackageUsageMap = sourceReader.createSamePackageUsageMap(FILEPATH);
		for (JavaFile file : samePackageUsageMap.keySet()) {
			Node classNode = node(file.getClassPath().toString());
			for (JavaFile otherFile : samePackageUsageMap.get(file)) {
				classNode = classNode.link(otherFile.getClassPath().toString());
			}
			g = g.with(classNode);
		}
		return g;
	}
}
