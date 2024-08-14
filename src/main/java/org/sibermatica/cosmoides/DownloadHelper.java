package org.sibermatica.cosmoides;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * This class downloads files :')
 * @author CiroZDP
 */
public class DownloadHelper {

    private DownloadHelper() {}
    
    public static void asyncDownload(String str_url, String path) {
        File file = new File(path);
        if (!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        
        try {
            // Open stream
            URL                 url = new URL(str_url);            // URL
            InputStream         in  = url.openStream();            // Main stream
            BufferedInputStream bis = new BufferedInputStream(in); // Optimize data downloading
            
            // Download the file through the Java NIO API
            Files.copy(bis, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            // Show exception info
            e.printStackTrace();
        }
    }

    public static Future<Void> download(String url, String path) {
        return CompletableFuture.runAsync(() -> asyncDownload(url, path));
    }

}
