package annotationTest;

import javax.lang.model.element.Element;
import javax.lang.model.element.PackageElement;

public class AnnotatedClazz {
	private String packageName;

	private String parentClazzName;

	private String[] parameters;

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getParentClazzName() {
		return parentClazzName;
	}

	public void setParentClazzName(String parentClazzName) {
		this.parentClazzName = parentClazzName;
	}

	public String[] getParameters() {
		return parameters;
	}

	public void setParameters(String[] childClazzNames) {
		this.parameters = childClazzNames;
	}

	public AnnotatedClazz(String packageName, String parentClazzName, String[] childClazzNames) {
		this.packageName = packageName;
		this.parentClazzName = parentClazzName;
		this.parameters = childClazzNames;
	}

	public AnnotatedClazz(Element clazz) {
		MyAnnotation annotation = clazz.getAnnotation(MyAnnotation.class);
		PackageElement enclosingPackage = (PackageElement) clazz.getEnclosingElement();
		this.packageName = enclosingPackage.getQualifiedName().toString();
		this.parentClazzName = clazz.getSimpleName().toString();
		this.parameters = annotation.parameters();
	}

}
