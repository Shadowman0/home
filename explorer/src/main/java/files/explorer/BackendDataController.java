package files.explorer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin()
public class BackendDataController {

	@RequestMapping(value = "/backendData/{id}")
	BackendDataDto get(@PathVariable("id") Long id) {
		return createData(id);
	}

	private BackendDataDto createData(long i) {
		return new BackendDataDto(i, "tolle Daten nr" + i);
	}

	@RequestMapping(value = "/backendData/allData")
	List<BackendDataDto> getList() {
		return IntStream.range(0, 5).mapToObj(i -> createData(i)).collect(Collectors.toList());
	}
}
