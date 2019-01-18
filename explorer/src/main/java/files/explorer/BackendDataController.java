package files.explorer;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.stringConnectionLocator.JavaFile;
import de.stringConnectionLocator.SourceReader;

@RestController
@CrossOrigin()
public class BackendDataController {
	
	private static final String PATH = "U:\\git\\ownrepos\\home\\stringConnectionLocator\\src\\main\\java";
	private SourceReader sourceReader = new SourceReader();
	private final HashMap<String, JavaFile> files = sourceReader.readFilesToFileMap(PATH);
	private DataMapper mapper = new DataMapper();
	
	@RequestMapping(value = "/files/{fullName}")
	BackendDataDto get(@PathVariable("fullName") String fullName) {
		return mapper.map(files.get(fullName));
	}
	
	@RequestMapping(value = "/files")
	List<BackendDataDto> searchFiles(@RequestParam(defaultValue = "", value = "name", required = false) String infix) {
		List<JavaFile> fittingFiles = filterByName(infix);
		return mapper.map(fittingFiles);
	}
	
	private List<JavaFile> filterByName(String infix) {
		return files.values().stream().filter(file -> file.getClassPath().getClassName().toUpperCase().contains(infix.toUpperCase()))
				.collect(Collectors.toList());
	}
}
