package nReporter.helpers;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

import static nReporter.NLogger.nLogger;

public class MediaContent {
    private static MediaContent ourInstance = new MediaContent();

    public static MediaContent getInstance() {
        return ourInstance;
    }

    private static byte[] bytes;
    private static String[] splitPath;

    /**
     * Build Media content using Path
     *
     * @param path Media Path
     * @return Media content instance
     * @throws IOException if path is invalid
     */
    public static MediaContent createMediaFromPath(String path) throws IOException {
        splitPath = path.split("\\.");
        bytes = FileUtils.readFileToByteArray(new File(path));
        nLogger.debug ("");
        return ourInstance;
    }

    /**
     * Build Media content form URL
     *
     * @param url URL content
     * @return Media content instance
     * @throws IOException if URL is invalid
     */
    public static MediaContent createMediaFromURL(String url) throws IOException {
        splitPath = url.split("\\.");
        bytes = IOUtils.toByteArray(new URL(url).openStream());
        return ourInstance;
    }

    /**
     * Convert image to Base64 image
     *
     * @return base64 string
     */
    public String toBase64() {
        String raw = Base64.encodeBase64String(bytes);
        nLogger.info ("Convert image to base64.");
        return "data:image/".concat(Objects.requireNonNull(splitPath)[splitPath.length - 1]).concat(";base64,").concat(Objects.requireNonNull(raw));
    }
}
