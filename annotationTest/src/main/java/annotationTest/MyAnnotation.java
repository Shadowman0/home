package annotationTest;

import static java.lang.annotation.RetentionPolicy.SOURCE;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(SOURCE)
@Target(ElementType.TYPE)
public @interface MyAnnotation {
	String[] parameters();
}
