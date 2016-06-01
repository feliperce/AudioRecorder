/*
 * Created by: Felipe Rodrigues
 * http://www.tupinikimtecnologia.com.br
 */
package br.com.tupinikimtecnologia.object;

import java.io.File;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.TargetDataLine;

/**
 *
 * @author felipe
 * @version 0.2
 * --- Audio Recorder thread class ---
 */
public class Recorder extends Thread {
    
    private AudioFileFormat.Type fileType;
    private File audioFile;
    private TargetDataLine line;
    private AudioFormat audioFormat;
    
    public Recorder(AudioFileFormat.Type fileType, File audioFile){
        
        audioFormat = new AudioFormat(16000, 8, 2, true, true);
    }
    

    @Override
    public void run() {
        super.run();
    }
    
}
