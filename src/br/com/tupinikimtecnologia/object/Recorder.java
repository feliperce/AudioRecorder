/*
 * Created by: Felipe Rodrigues
 * http://www.tupinikimtecnologia.com.br
 */
package br.com.tupinikimtecnologia.object;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;
import javax.swing.JOptionPane;

/**
 *
 * @author felipe
 * @version 0.5
 * --- Audio Recorder thread class ---
 */
public class Recorder extends Thread {
    
    private AudioFileFormat.Type fileType;
    private File audioFile;
    private TargetDataLine line;
    private final AudioFormat audioFormat;
    private boolean isRecording;
    
    public Recorder(AudioFileFormat.Type fileType, File audioFile){
        this.fileType = fileType;
        this.audioFile = audioFile;
        this.isRecording = true;
        this.audioFormat = new AudioFormat(16000, 8, 2, true, true);
    }
    
    private void startRecord(){
        try {

            DataLine.Info info = new DataLine.Info(TargetDataLine.class, audioFormat);
 
            line = (TargetDataLine) AudioSystem.getLine(info);
            line.open(audioFormat);
            line.start();   // start capturing
 
            System.out.println("Start capturing...");
 
            AudioInputStream ais = new AudioInputStream(line);
 
            System.out.println("Start recording...");
 
            // start recording
            AudioSystem.write(ais, fileType, audioFile);
 
        } catch (LineUnavailableException ex) {
            JOptionPane.showConfirmDialog(null, "Line unavailable, check your mic.", "ERROR", JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    
    public void stopRecord(){
        line.stop();
        line.close();
        System.out.println("Finished");
    }

    @Override
    public void run() {
        super.run();
        System.out.println("Chamou run");
        startRecord();
    }
 

    public boolean isIsRecording() {
        return isRecording;
    }

    public void setIsRecording(boolean isRecording) {
        this.isRecording = isRecording;
    }

}
