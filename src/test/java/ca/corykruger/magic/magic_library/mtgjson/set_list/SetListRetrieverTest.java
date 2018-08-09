package ca.corykruger.magic.magic_library.mtgjson.set_list;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import com.google.gson.Gson;

import ca.corykruger.magic.magic_library.utils.FileUtilsWrapper;

public class SetListRetrieverTest {
	
	@Rule
	public TemporaryFolder tempFolder = new TemporaryFolder();
	
	private SetListRetriever retriever;
	
	private Gson gson;
	private URL url;
	private File file;
	
	private String localFile = "[{\"name\": \"Unstable\",\"code\": \"UST\",\"releaseDate\": \"2017-12-08\"}]";
	private String remoteFile = "[{\"name\": \"Unstable\",\"code\": \"UST\",\"releaseDate\": \"2017-12-08\"}, "
	+ "{\"name\": \"Unhinged\",\"code\": \"UNH\",\"releaseDate\": \"2004-11-20\"}]";
	
	List<Set> setList;
	
	@Before
	public void setUp() throws IOException {
		gson = new Gson();
		setList = new ArrayList<>();
	}
	
	@After
	public void tearDown() {
		file.delete();
	}
	
	@Test
	public void localFileReturnedWhenLocalFilePresent() throws IOException {
		file = tempFolder.newFile();
		FileUtils.writeStringToFile(file, localFile, Charset.defaultCharset());
		retriever = new SetListRetriever(new FileUtilsWrapper(), gson, url, file);
		setList.add(new Set("Unstable", "UST", "2017-12-08"));
		List<Set> retrievedList = retriever.retrieveSetList();
		assertTrue(retrievedList.size() == setList.size());
		for (Set set : setList) {
			assertTrue(retrievedList.contains(set));
		}
	}
	
	@Test
	public void remoteFileReturnedWhenLocalFileNotPresent() throws IOException {
		// Create a temporary file, save its path, then delete it so that File.exists() returns false
		file = tempFolder.newFile();
		String tempFilePath = file.getPath();
		file.delete();
		
		// Create a new file at the temporary file location and save the contents of remoteFile to it
		Answer<Void> answer = new Answer<Void>() {

			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				file = new File(tempFilePath);
				FileUtils.writeStringToFile(file, remoteFile, Charset.defaultCharset());
				return null;
			}};
		
		FileUtilsWrapper fileUtils = mock(FileUtilsWrapper.class); 
		doAnswer(answer).when(fileUtils).copyURLToFile(any(URL.class), any(File.class));
		doCallRealMethod().when(fileUtils).readFileToString(any(File.class));
		doCallRealMethod().when(fileUtils).readFileToString(any(File.class), any(Charset.class));
		retriever = new SetListRetriever(fileUtils, gson, url, file);
		setList.add(new Set("Unhinged", "UNH", "2004-11-20"));
		setList.add(new Set("Unstable", "UST", "2017-12-08"));
		List<Set> retrievedList = retriever.retrieveSetList();
		assertTrue(retrievedList.size() == setList.size());
		for (Set set : setList) {
			assertTrue(retrievedList.contains(set));
		}
	}
	
}
