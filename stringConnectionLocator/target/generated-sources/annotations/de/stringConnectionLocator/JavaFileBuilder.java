package de.stringConnectionLocator;

import java.nio.file.Path;
import java.util.List;
import javax.annotation.Generated;
import net.karneim.pojobuilder.GwtIncompatible;

@Generated("PojoBuilder")
public class JavaFileBuilder
    implements Cloneable {
  protected JavaFileBuilder self;
  protected List<String> value$content$java$util$List;
  protected boolean isSet$content$java$util$List;
  protected ClassPath value$classPath$de$stringConnectionLocator$ClassPath;
  protected boolean isSet$classPath$de$stringConnectionLocator$ClassPath;
  protected Path value$filePath$java$nio$file$Path;
  protected boolean isSet$filePath$java$nio$file$Path;

  /**
   * Factory Method to construct a JavaFileBuilder
   *
   * @return a new JavaFileBuilder
   */
  public static JavaFileBuilder aJavaFile() {
    return new JavaFileBuilder();
  }

  /**
   * Creates a new {@link JavaFileBuilder}.
   */
  public JavaFileBuilder() {
    self = (JavaFileBuilder)this;
  }

  /**
   * Sets the default value for the content property.
   *
   * @param value the default value
   * @return this builder
   */
  public JavaFileBuilder withContent(List<String> value) {
    this.value$content$java$util$List = value;
    this.isSet$content$java$util$List = true;
    return self;
  }

  /**
   * Sets the default value for the classPath property.
   *
   * @param value the default value
   * @return this builder
   */
  public JavaFileBuilder withClassPath(ClassPath value) {
    this.value$classPath$de$stringConnectionLocator$ClassPath = value;
    this.isSet$classPath$de$stringConnectionLocator$ClassPath = true;
    return self;
  }

  /**
   * Sets the default value for the filePath property.
   *
   * @param value the default value
   * @return this builder
   */
  public JavaFileBuilder withFilePath(Path value) {
    this.value$filePath$java$nio$file$Path = value;
    this.isSet$filePath$java$nio$file$Path = true;
    return self;
  }

  /**
   * Returns a clone of this builder.
   *
   * @return the clone
   */
  @Override
  @GwtIncompatible
  public Object clone() {
    try {
      JavaFileBuilder result = (JavaFileBuilder)super.clone();
      result.self = result;
      return result;
    } catch (CloneNotSupportedException e) {
      throw new InternalError(e.getMessage());
    }
  }

  /**
   * Returns a clone of this builder.
   *
   * @return the clone
   */
  @GwtIncompatible
  public JavaFileBuilder but() {
    return (JavaFileBuilder)clone();
  }

  /**
   * Creates a new {@link JavaFile} based on this builder's settings.
   *
   * @return the created JavaFile
   */
  public JavaFile build() {
    try {
      JavaFile result = new JavaFile(value$content$java$util$List, value$classPath$de$stringConnectionLocator$ClassPath, value$filePath$java$nio$file$Path);
      return result;
    } catch (RuntimeException ex) {
      throw ex;
    } catch (Exception ex) {
      throw new RuntimeException(ex);
    }
  }
}
