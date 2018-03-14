package argument_parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Command {
    private String text;
    private List<String> asList;
    private ArgumentCatalog argumentCatalog;

    public Command(String text, ArgumentCatalog commandCatalog) {
        this.text = text;
        this.argumentCatalog = commandCatalog;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> split() {
        String[] split = text.split(" ");
        asList = Arrays.asList(split);
        return asList;
    }

    public List<Argument> parseArguments() {
        return asList.stream().map(arg -> argumentCatalog.get(arg)).filter(arg -> !arg.equals(argumentCatalog.getDefaultArgument())).collect(Collectors.toList());
    }
}
