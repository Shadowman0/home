package files.explorer;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("backendData")
public class BackendDataDto {
	private final String content;

	public BackendDataDto(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}
}
