/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 *
 * @author David
 */
public class Metodos {
    
    public static void copiarArquivo(File arquivo, File destino) throws IOException {
        if (destino.exists()) {
            destino.delete();
        }
        FileChannel arquivoChannel = null;
        FileChannel destinoChannel = null;
        try {
            arquivoChannel = new FileInputStream(arquivo).getChannel();
            destinoChannel = new FileOutputStream(destino).getChannel();
            arquivoChannel.transferTo(0, arquivoChannel.size(),
                    destinoChannel);
        } finally {
            if (arquivoChannel != null && arquivoChannel.isOpen()) {
                arquivoChannel.close();
            }
            if (destinoChannel != null && destinoChannel.isOpen()) {
                destinoChannel.close();
            }
        }
    }
}
