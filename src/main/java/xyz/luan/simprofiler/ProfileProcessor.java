package xyz.luan.simprofiler;

import com.google.auto.service.AutoService;
import com.squareup.javapoet.MethodSpec;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.ExecutableType;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;
import java.util.LinkedHashSet;
import java.util.Set;

@AutoService(Processor.class)
public class ProfileProcessor extends AbstractProcessor {

	private Types typeUtils;
	private Elements elementUtils;
	private Filer filer;
	private Messager messager;

	@Override
	public synchronized void init(ProcessingEnvironment processingEnv) {
		super.init(processingEnv);
		typeUtils = processingEnv.getTypeUtils();
		elementUtils = processingEnv.getElementUtils();
		filer = processingEnv.getFiler();
		messager = processingEnv.getMessager();
	}

	@Override
	public Set<String> getSupportedAnnotationTypes() {
		Set<String> annotations = new LinkedHashSet<>();
		annotations.add(Profiler.class.getCanonicalName());
		return annotations;
	}

	@Override
	public SourceVersion getSupportedSourceVersion() {
		return SourceVersion.latestSupported();
	}

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		for (Element element : roundEnv.getElementsAnnotatedWith(Profiler.class)) {
			if (element.getKind() == ElementKind.METHOD) {
				ExecutableElement method = (ExecutableElement) element;
				Element element1 = method.getEnclosedElements().get(0);
//				messager.printMessage(Diagnostic.Kind.ERROR, "asd: " + element1.getClass());
//				MethodSpec main = MethodSpec.methodBuilder("main").addStatement("$T.out.println($S)", System.class, "Hello, JavaPoet!").build();
			}
		}
		return true;
	}
}
