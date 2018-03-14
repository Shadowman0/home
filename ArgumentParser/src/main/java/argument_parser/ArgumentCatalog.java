package argument_parser;

import java.util.HashMap;
import java.util.function.BiConsumer;

public class ArgumentCatalog {
    private HashMap<String, Argument> arguments = new HashMap();
    private Argument defaultArgument;

    public void add(String key, Argument argument) {
        arguments.put(key, argument);
    }

    public ArgumentCatalog() {

        this.defaultArgument = new Argument("");
    }

    public void forEach(BiConsumer<? super String, ? super Argument> action) {
        arguments.forEach(action);
    }

    public boolean containsKey(Object key) {
        return arguments.containsKey(key);
    }

    public Argument get(Object key) {
        return arguments.getOrDefault(key, defaultArgument);
    }

    public Argument getDefaultArgument() {
        return defaultArgument;
    }
}
