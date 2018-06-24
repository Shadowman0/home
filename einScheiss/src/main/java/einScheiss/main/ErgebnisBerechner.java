package einScheiss.main;

public class ErgebnisBerechner {

	private ParameterModel parameterModel;

	public ErgebnisBerechner(ParameterModel parameterModel) {
		this.parameterModel = parameterModel;
	}

	public Ergebnis berechne() {
		return new Ergebnis();
	}

}
