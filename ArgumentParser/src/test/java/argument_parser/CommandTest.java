package argument_parser;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CommandTest {
    private String text;
    private Command command;
    private ArgumentCatalog argumentCatalog;

    @Before
    public void setUp() {

        text = "wol --port 3 01:12:34:56:78:9a";
        argumentCatalog = new ArgumentCatalog();
        argumentCatalog.add("--port", new Argument("port"));

        command = new Command(text, argumentCatalog);
    }

    @Test
    public void split() throws Exception {
        List<String> split = command.split();

        assertThat(split).containsExactlyInAnyOrder("wol", "--port", "3", "01:12:34:56:78:9a");
    }

    @Test
    public void findArgument() throws Exception {
        List<String> split = command.split();
        List<Argument> collect = command.parseArguments();

        assertThat(collect).containsExactly(new Argument("port"));
    }

}
