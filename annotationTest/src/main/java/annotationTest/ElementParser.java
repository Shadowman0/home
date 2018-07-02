package annotationTest;

import javax.lang.model.element.Element;
import javax.lang.model.element.PackageElement;

public class ElementParser {

	public AnnotatedClazz createAnnotatedClazz(final Element clazz) {
		MyAnnotation annotation = clazz.getAnnotation(MyAnnotation.class);
		PackageElement enclosingPackage = (PackageElement) clazz.getEnclosingElement();
		return new AnnotatedClazz(enclosingPackage.getQualifiedName().toString(), clazz.getSimpleName().toString(),
				annotation.parameters());
	}

}
