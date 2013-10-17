package org.iwb.services;

import java.io.IOException;
import java.io.InputStream;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
public interface FileSystemService {

    /**
     * Returns the opened input stream to read the specified file content.
     *
     * @param bucket the bucket of the file.
     * @param file the file name
     * @return See description.
     */
    byte[] load(String bucket, String file) throws IOException;

}
