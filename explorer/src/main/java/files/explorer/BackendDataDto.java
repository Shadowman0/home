package files.explorer;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("backendData")
public class BackendDataDto {
	private final String content;
	private final Long nummer;

	public BackendDataDto(Long nummer, String content) {
		this.nummer = nummer;
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public Long getNummer() {
		return nummer;
	}
}
