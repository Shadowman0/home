package files.explorer;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BackendDataControllerTest {
	@InjectMocks
	private BackendDataController controller;
	
	@Test
	public void getList_JsonComparison() {
		assertThat(controller.getList()).extracting(it -> ObjectMapping.jsonBuilder().writeValueAsString(it)).descriptionText()
				.contains("files.explorer.source.PersonMapper");
	}
	
	@Test
	public void getList_FullNames() {
		assertThat(controller.getList()).extracting(it -> it.getFullName()).containsExactlyInAnyOrder(//
				"files.explorer.source.Person", "files.explorer.source.PersonDto", "files.explorer.source.PersonMapper");
	}
	
}
