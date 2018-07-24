package ca.corykruger.magic.magic_library.mtgjson.set_list;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import com.google.gson.Gson;

import ca.corykruger.magic.magic_library.utils.FileUtilsWrapper;

public class SetListRetrieverTest {
	
	@Rule
	public TemporaryFolder tempFolder = new TemporaryFolder();
	
	private SetListRetriever retriever;
	
	private FileUtilsWrapper fileUtils;
	private Gson gson;
	private URL url;
	private File file;
	
	private String localFile = "[{\"name\": \"Unstable\",\"code\": \"UST\",\"releaseDate\": \"2017-12-08\"}]";
	private String remoteFile = "[{\"name\": \"Unhinged\",\"code\": \"UNH\",\"releaseDate\": \"2004-11-20\"}]";
	
	List<Set> setList;
	
	@Before
	public void setUp() throws IOException {
		fileUtils = new FileUtilsWrapper();
		gson = new Gson();
		file =  tempFolder.newFile();
		setList = new ArrayList<>();
	}
	
	
	@Test
	public void localFileReturnedWhenLocalFilePresent() throws IOException {
		FileUtils.writeStringToFile(file, localFile, Charset.defaultCharset());
		retriever = new SetListRetriever(fileUtils, gson, url, file);
		setList.add(new Set("Unstable", "UST", "2017-12-08"));
		List<Set> retrievedList = retriever.retrieveSetList();
		assertTrue(retrievedList.size() == setList.size());
		for (Set set : setList) {
			assertTrue(retrievedList.contains(set));
		}
	}
	
	@Test
	public void remoteFileReturnedWhenLocalFileNotPresent() throws IOException {
		FileUtils.writeStringToFile(file, remoteFile, Charset.defaultCharset());
		retriever = new SetListRetriever(fileUtils, gson, url, file);
		setList.add(new Set("Unhinged", "UNH", "2004-11-20"));
		List<Set> retrievedList = retriever.retrieveSetList();
		assertTrue(retrievedList.size() == setList.size());
		for (Set set : setList) {
			assertTrue(retrievedList.contains(set));
		}
	}
	
}
