package de.stringConnectionLocator;

import static org.assertj.core.api.Assertions.assertThat;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

public class SourceReaderTest //
// extends AbstractIntegrationTest //
{
	private static final String FILEPATH = "C:\\Users\\Pieed\\git\\home\\RocketLearn\\src";

	@Test
	@Ignore
	public void read() throws Exception {
		SourceReader sourceReader = new SourceReader();
		List<Path> javaFiles = sourceReader.getAllJavaFileNames(FILEPATH);

		javaFiles.forEach(file -> System.out.println(file.toString()));
		assertThat(javaFiles.toString()).isEqualTo("");

	}

	@Test
	public void readFilesToHashMap() throws Exception {
		SourceReader sourceReader = new SourceReader();
		HashMap<String, JavaFile> hashMap = sourceReader.readFilesToFileMap(FILEPATH);
		assertThat(hashMap.keySet().toString())
				.isEqualTo("[gui.GuiAbstractBody, controller.KeyActionsBody, model.rockets.RocketSmall,"
						+ " controller.RocketLearnApp, model.Vector,"
						+ " gui.BodyCanvas, model.rockets.RocketFuelTank, gui.GuiSimpleBody, model.Strut, model.Vector2d,"
						+ " model.BodyList, model.rockets.Rocket, model.Planet, model.AbstractBody, gui.GuiTrajectory,"
						+ " model.Simulation, gui.GuiRocketExtended, model.forces.Forces, model.SimpleBody, gui.MainWindow,"
						+ " model.rockets.RocketEngine, gui.GuiBody, gui.GuiRocket, controller.MouseWheelEvent, controller.KeyActionsGui,"
						+ " gui.GuiPlanet]");

	}

	@Test
	public void getImports() throws Exception {
		SourceReader sourceReader = new SourceReader();
		HashMap<String, JavaFile> hashMap = sourceReader.readFilesToFileMap(FILEPATH);

		JavaFile javaFile = hashMap.get("gui.GuiAbstractBody");
		assertThat(javaFile.getImports()).isEqualTo("");
	}

	@Test
	public void readFilesToPackageMap() throws Exception {
		SourceReader sourceReader = new SourceReader();
		HashMap<String, List<JavaFile>> hashMap = sourceReader.readFilesToPackageMap(FILEPATH);
		assertThat(hashMap).isEqualTo("");
	}

	@Test
	public void usageSysoTest() throws Exception {
		SourceReader sourceReader = new SourceReader();
		HashMap<String, List<JavaFile>> hashMap = sourceReader.readFilesToPackageMap(FILEPATH);

		List<JavaFile> actual = hashMap.get("model.rockets");
		for (JavaFile javaFile : actual) {
			for (JavaFile javaFile2 : actual) {
				if (javaFile.uses(javaFile2)) {
					System.out.println(
							javaFile.getClassPath().toString() + " uses " + javaFile2.getClassPath().toString());
				}
			}
		}

	}

	@Test
	public void createSamePackageUsageMap() throws Exception {
		SourceReader sourceReader = new SourceReader();
		HashMap<JavaFile, List<JavaFile>> usages = sourceReader.createSamePackageUsageMap(FILEPATH);
		assertThat(usages).isEqualTo("");
	}

}
