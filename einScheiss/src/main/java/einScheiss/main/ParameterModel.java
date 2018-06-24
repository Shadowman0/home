package einScheiss.main;

import com.opencsv.bean.CsvBindByName;

public class ParameterModel {
	@CsvBindByName(column = "erster Parameter")
	private double ersterParameter;

	@CsvBindByName(column = "zweiter Parameter")
	private double zweiterParameter;

	@CsvBindByName(column = "dritter Parameter")
	private double dritterParameter;

	@Override
	public String toString() {
		return "ParameterModel [ersterParameter=" + ersterParameter + ", zweiterParameter=" + zweiterParameter
				+ ", dritterParameter=" + dritterParameter + "]";
	}

}
