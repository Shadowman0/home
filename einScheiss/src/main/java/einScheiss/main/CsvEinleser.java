package einScheiss.main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

public class CsvEinleser {

	public List<ParameterModel> leseParameter(String dateiname) throws IllegalStateException, FileNotFoundException {
		return new CsvToBeanBuilder(new FileReader(dateiname)).withType(ParameterModel.class).build().parse();

	}

}
