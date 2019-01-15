package files.explorer;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("backendData")
public class BackendDataDto {

	private final String fullName;
	private final String content;
	private final String className;
	private final String _package;

	public BackendDataDto(String fullName, String content, String className, String _package) {
		this.fullName = fullName;
		this.content = content;
		this.className = className;
		this._package = _package;
	}

	public String get_package() {
		return _package;
	}

	public String getContent() {
		return content;
	}

	public String getClassName() {
		return className;
	}

	public String getFullName() {
		return fullName;
	}

}
