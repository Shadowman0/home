package annotationTest;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

import javax.annotation.processing.Filer;
import javax.tools.JavaFileObject;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;

public class SourceFileWriter {

	private Configuration freemarkerCfg;
	private Filer filer;

	public SourceFileWriter(final Filer filer) {
		this.filer = filer;
		freemarkerCfg = new Configuration(new Version(2, 3, 20));
		freemarkerCfg.setClassForTemplateLoading(this.getClass(), "/");
		freemarkerCfg.setDefaultEncoding("UTF-8");
		freemarkerCfg.setLocale(Locale.US);
		freemarkerCfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
	}

	public void createFiles(final List<AnnotatedClazz> annotatedClazzes) {
		Objects.requireNonNull(annotatedClazzes);

		Template template;
		String templateName = "templates/clazz.ftl";
		try {
			template = freemarkerCfg.getTemplate(templateName);
		} catch (IOException e) {
			throw new RuntimeException("Could not load template '" + templateName + "'", e);
		}

		for (AnnotatedClazz clazz : annotatedClazzes) {
			Map<String, Object> modelMap = new HashMap<>();
			modelMap.put("packageName", clazz.getPackageName());
			modelMap.put("parentClazzName", clazz.getParentClazzName());
			String generatedClazzName = clazz.getParentClazzName() + "Builder";
			modelMap.put("generatedClazzName", generatedClazzName);

			try {
				JavaFileObject jfo = filer.createSourceFile(clazz.getPackageName() + "." + generatedClazzName);
				Writer writer = jfo.openWriter();
				template.process(modelMap, writer);
			} catch (IOException | TemplateException e) {
				e.printStackTrace();
				System.out.println("FEHLER");
			}
		}
	}
}
