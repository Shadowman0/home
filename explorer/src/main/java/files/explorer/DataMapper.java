package files.explorer;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import de.stringConnectionLocator.JavaFile;

@Component
public class DataMapper {
	
	public List<BackendDataDto> map(Collection<JavaFile> files) {
		return files.stream().map(file -> map(file)).collect(Collectors.toList());
	}
	
	public BackendDataDto map(JavaFile file) {
		return new BackendDataDto(file.getClassPath().toString(), file.getContentAsString(), file.getClassPath().getClassName(),
				file.getClassPath().getPackagename());
	}
	
}
