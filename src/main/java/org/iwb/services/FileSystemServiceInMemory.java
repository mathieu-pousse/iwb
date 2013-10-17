package org.iwb.services;


import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * TODO fill me.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
@Service
public class FileSystemServiceInMemory implements FileSystemService {

    @Override
    public byte[] load(String bucket, String file) throws IOException {
        if ("images".equals(bucket)) {
            return loadImage(file);
        }
        return null;
    }

    private byte[] loadImage(String file) throws IOException {
        int width = 150, height = 150;

        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        Graphics2D ig2 = bi.createGraphics();


        Font font = new Font("Trebuchet MS", Font.BOLD, 20);
        ig2.setFont(font);
        FontMetrics fontMetrics = ig2.getFontMetrics();
        int stringWidth = fontMetrics.stringWidth(file);
        int stringHeight = fontMetrics.getAscent();
        ig2.setPaint(Color.black);
        ig2.drawString(file, (width - stringWidth) / 2, height / 2 + stringHeight / 4);

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        ImageIO.write(bi, "png", buffer);
        return buffer.toByteArray();
    }
}
