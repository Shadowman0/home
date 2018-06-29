package de.stringConnectionLocator;

import static guru.nidi.graphviz.model.Factory.graph;
import static guru.nidi.graphviz.model.Factory.node;

import java.io.File;

import org.junit.Test;

import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.engine.GraphvizJdkEngine;
import guru.nidi.graphviz.model.Graph;

public class GraphTest {
	@Test
	public void testName() throws Exception {
		GraphvizJdkEngine graphvizJdkEngine = new GraphvizJdkEngine();
		Graphviz.useEngine(graphvizJdkEngine, graphvizJdkEngine);
		Graph g = graph("example1").directed().with(node("a").link(node("b"), node("c").link(node("a"))));
		g = g.with(node("b").link(node("d")));
		Graphviz.fromGraph(g).width(200).render(Format.PNG).toFile(new File("example/ex1.png"));
	}
}
