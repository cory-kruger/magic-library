package ca.corykruger.magic.magic_library.mtgjson.set;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import ca.corykruger.magic.magic_library.utils.FileUtilsWrapper;

public class SetRetriever {

	private FileUtilsWrapper fileUtils;
	private Gson gson;
	
	private URL url;
	private File file;
	
	public SetRetriever(FileUtilsWrapper fileUtils, Gson gson, URL url, File file) {
		this.fileUtils = fileUtils;
		this.gson = gson;
		this.url = url;
		this.file = file;
	}
	
	public Set retrieveSet() throws IOException {
		if (!file.exists()) {
			fileUtils.copyURLToFile(url, file);
		}
		String json = fileUtils.readFileToString(file);
		return gson.fromJson(json, new TypeToken<Set>() {}.getType());
	}
}
