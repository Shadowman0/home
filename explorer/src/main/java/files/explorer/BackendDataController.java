package files.explorer;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin()
public class BackendDataController {

	@RequestMapping(value = "/backendData/{id}")
	BackendDataDto get(@PathVariable("id") Long id) {
		return new BackendDataDto("tolle Daten nr" + id);
	}

	@RequestMapping(value = "/backendData/allData")
	List<Integer> getList() {
		return Arrays.asList(1, 2, 3);
	}
}
