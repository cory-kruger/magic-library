package ca.corykruger.magic.magic_library.mtgjson.set;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import ca.corykruger.magic.magic_library.utils.FileUtilsWrapper;

/**
 * Retrieves the set from either <a href="https://mtgjson.com">MTG JSON</a> or the 
 * already-existant local file and parses it into a <code>Set</code>
 */
public class SetRetriever {

	private FileUtilsWrapper fileUtils;
	private Gson gson;
	
	private URL url;
	private File file;
	
	/**
	 * DI constructor
	 * @param fileUtils Wrapper for {@link FileUtils} for I/O
	 * @param gson main Gson class for JSON interaction
	 * @param url URL of the remote file
	 * @param file local file for storing the set
	 */
	public SetRetriever(FileUtilsWrapper fileUtils, Gson gson, URL url, File file) {
		this.fileUtils = fileUtils;
		this.gson = gson;
		this.url = url;
		this.file = file;
	}
	
	/**
	 * Retrieves the set from the local file.  If the local file doesn't exist, 
	 * copies the remote file to the local file.
	 * @return The set
	 * @throws IOException in case of an I/O error
	 */
	public Set retrieveSet() throws IOException {
		if (!file.exists()) {
			fileUtils.copyURLToFile(url, file);
		}
		String json = fileUtils.readFileToString(file);
		return gson.fromJson(json, new TypeToken<Set>() {}.getType());
	}
}
