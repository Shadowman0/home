package einScheiss.main;

import java.util.List;

import org.junit.Test;

public class ErgebnisBerechnerTest {
	@Test
	public void berechneDieDreiZahlen() throws Exception {
		CsvEinleser csvEinleser = new CsvEinleser();
		List<ParameterModel> modelle = csvEinleser.leseParameter(
				"C:\\Users\\Pieed\\eclipse-spielereien\\einScheiss\\src\\test\\resources\\einScheiss\\main\\testdatei.csv");

		ErgebnisBerechner ergebnisBerechner = new ErgebnisBerechner(modelle.get(0));
		Ergebnis ergebnis = ergebnisBerechner.berechne();
	}
}
