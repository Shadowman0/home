package einScheiss.main;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

public class CsvEinleserTest {

	@Test
	public void testName() throws Exception {
		CsvEinleser csvEinleser = new CsvEinleser();
		List<ParameterModel> modelle = csvEinleser.leseParameter(
				"C:\\Users\\Pieed\\eclipse-spielereien\\einScheiss\\src\\test\\resources\\einScheiss\\main\\testdatei.csv");
		assertThat(modelle).hasSize(1);
		assertThat(modelle.get(0).toString()).isEqualTo("");
	}
}
