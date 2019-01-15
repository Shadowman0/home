package de.stringConnectionLocator;

import static org.assertj.core.api.Assertions.assertThat;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

public class SourceReaderTest //
// extends AbstractIntegrationTest //
{
	private static final String FILEPATH = "C:\\Users\\pwegner\\eemweb-gitrepos\\EEMWebPerson\\person\\src\\main\\java\\de\\etengo\\eemweb\\person\\domain\\";

	@Test
	// @Ignore
	public void read() throws Exception {
		SourceReader sourceReader = new SourceReader();
		List<Path> javaFiles = sourceReader.getAllJavaFileNames(FILEPATH);

		javaFiles.forEach(file -> System.out.println(file.getFileName().toString()));
		assertThat(javaFiles.toString()).isEqualTo("");

	}

	@Test
	public void readFilesToHashMap() throws Exception {
		SourceReader sourceReader = new SourceReader();
		HashMap<String, JavaFile> hashMap = sourceReader.readFilesToFileMap(FILEPATH);
		assertThat(hashMap.keySet().toString()).isEqualTo(
				"[de.etengo.eemweb.person.domain.person.Titel, de.etengo.eemweb.person.domain.weblink.Weblink,"
						+ " de.etengo.eemweb.person.domain.person.AnredeCatalog, de.etengo.eemweb.person.domain.DSGVOEinwilligungMessageMapper,"
						+ " de.etengo.eemweb.person.domain.person.RolleRepository, de.etengo.eemweb.person.domain.person.marketingoptin.MarketingOptIn,"
						+ " de.etengo.eemweb.person.domain.sprache.SprachauspraegungCatalog, de.etengo.eemweb.person.domain.sprache.SprachkenntnisMapper, "
						+ "de.etengo.eemweb.person.domain.weblink.PersonWeblinkdaten, de.etengo.eemweb.person.domain.person.TitelRepository, "
						+ "de.etengo.eemweb.person.domain.sprache.SprachkenntnisController, de.etengo.eemweb.person.domain.sprache.SprachkenntnisService, "
						+ "de.etengo.eemweb.person.domain.weblink.PersonWeblinkdatenRepository, de.etengo.eemweb.person.domain.PersonInternalControllerForDevelopment, "
						+ "de.etengo.eemweb.person.domain.sprache.Sprachkenntnis, de.etengo.eemweb.person.domain.sprache.SprachkenntnisOrpController, de.etengo.eemweb.person.domain.person.PersonRepository, de.etengo.eemweb.person.domain.person.marketingoptin.MarketingOptInCatalog, de.etengo.eemweb.person.domain.sprache.SprachkenntnisRepository, de.etengo.eemweb.person.domain.person.RolleCatalog, de.etengo.eemweb.person.domain.PersonMessageMapper, de.etengo.eemweb.person.domain.person.AnredeRepository, de.etengo.eemweb.person.domain.sprache.SprachauspraegungRepository, de.etengo.eemweb.person.domain.PersonSender, de.etengo.eemweb.person.domain.sprache.Sprachauspraegung, de.etengo.eemweb.person.domain.weblink.WeblinkController, de.etengo.eemweb.person.domain.weblink.WeblinkOrpController, de.etengo.eemweb.person.domain.PersonInternalController, de.etengo.eemweb.person.domain.PersonSecuredInternalController, de.etengo.eemweb.person.domain.person.Rolle, de.etengo.eemweb.person.domain.person.Anrede, de.etengo.eemweb.person.domain.weblink.WeblinkService, de.etengo.eemweb.person.domain.sprache.SpracheCatalog, de.etengo.eemweb.person.domain.sprache.SpracheRepository, de.etengo.eemweb.person.domain.PersonController, de.etengo.eemweb.person.domain.sprache.SprachkenntnisMessageMapper, de.etengo.eemweb.person.domain.person.Person, de.etengo.eemweb.person.domain.person.PersonRolle, de.etengo.eemweb.person.domain.sprache.Sprache, de.etengo.eemweb.person.domain.PersonEnumsAsTextMapper, de.etengo.eemweb.person.domain.PersonOrpController, de.etengo.eemweb.person.domain.weblink.PersonWeblinkdatenMapper, de.etengo.eemweb.person.domain.person.TitelCatalog, de.etengo.eemweb.person.domain.PersonMapper, de.etengo.eemweb.person.domain.person.marketingoptin.PersonMarketingOptIn,"
						+ " de.etengo.eemweb.person.domain.person.marketingoptin.MarketingOptInRepository, de.etengo.eemweb.person.domain.PersonService]");

	}

	@Test
	public void readFilesToHashMap_Packages() throws Exception {
		SourceReader sourceReader = new SourceReader();
		HashMap<String, JavaFile> hashMap = sourceReader.readFilesToFileMap(FILEPATH);
		assertThat(hashMap.values()).extracting(file -> file.getClassPath())
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
