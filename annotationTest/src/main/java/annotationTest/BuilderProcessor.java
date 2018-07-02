package annotationTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

import com.google.auto.service.AutoService;

@SupportedAnnotationTypes("annotationTest.MyBuilder")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@AutoService(Processor.class)
public class BuilderProcessor extends AbstractProcessor {

	private ElementParser elementParser;
	private SourceFileWriter sourceFileWriter;

	@Override
	public void init(final ProcessingEnvironment processingEnv) {
		super.init(processingEnv);
		this.elementParser = new ElementParser();
		this.sourceFileWriter = new SourceFileWriter(processingEnv.getFiler());
	}

	@Override
	public boolean process(final Set<? extends TypeElement> annotations, final RoundEnvironment roundEnv) {
		Set<? extends Element> annotatedElements = roundEnv.getElementsAnnotatedWith(MyAnnotation.class);
		List<AnnotatedClazz> parsedClazzes = new ArrayList<>();
		for (Element element : annotatedElements) {
			AnnotatedClazz clazz = this.elementParser.createAnnotatedClazz(element);
			parsedClazzes.add(clazz);
			System.out.println("test");
		}
		sourceFileWriter.createFiles(parsedClazzes);
		return false;
	}
}
