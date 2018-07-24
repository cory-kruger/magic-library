package ca.corykruger.magic.magic_library.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;

/**
 * Wrapper for {@link FileUtils} methods to facilitate unit testing
 */
public class FileUtilsWrapper {
	
	/**
	 * {@link FileUtils#copyURLToFile}
	 * @param source the URL to copy bytes from, must not be null
	 * @param destination the non-directory File to write bytes to (possibly overwriting), must not be null
	 * @throws IOException if source URL cannot be opened
	 * @throws IOException if destination is a directory
	 * @throws IOException if destination cannot be written
	 * @throws IOException if destination needs creating but can't be
	 * @throws IOException if an IO error occurs during copying
	 */
	public void copyURLToFile(URL source, File destination) throws IOException {
		FileUtils.copyURLToFile(source, destination);
	}
	
	/**
	 * Calls {@link #readFileToString(File, Charset)} using the default <code>charset</code>
	 * @param file the file to read, must not be null
	 * @return the file contents, never null
	 * @throws IOException in case of an I/O error
	 */
	public String readFileToString(File file) throws IOException {
		return readFileToString(file, Charset.defaultCharset());
	}
	
	/**
	 * {@link FileUtils#readFileToString(File, Charset)}
	 * @param file the file to read, must not be null
	 * @param encoding the encoding to use, null means platform default
	 * @return the file contents, never null
	 * @throws IOException in case of an I/O error
	 */
	public String readFileToString(File file, Charset encoding) throws IOException {
		return FileUtils.readFileToString(file, encoding);
	}

}
