/*
 * Created by: Felipe Rodrigues
 * http://www.tupinikimtecnologia.com.br
 */
package br.com.tupinikimtecnologia.object;

import java.util.TimerTask;
import javax.swing.JLabel;

/**
 *
 * @author felipe
 * @version 1.0
 * --- Class that count minutes and seconds ---
 */
public class TimerCounter extends TimerTask {

    private int second = 0, minute = 0;
    private boolean isTiming = false;
    private final JLabel statusLabel;
    
    /**
     * 
     * @param statusLabel Set the label that will change every second
     * 
     */
    public TimerCounter(JLabel statusLabel){
        this.statusLabel = statusLabel;
    }
    
    public void stopTimer(){
        second = 0;
        minute = 0;
        isTiming = false;
    }

    @Override
    public void run() {
        isTiming = true;
        second++;
        if(second==60){
            second = 0;
            minute++;
        }
        statusLabel.setText("Recording... "+minute+":"+second);
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public boolean isTiming() {
        return isTiming;
    }

    public void setIsTiming(boolean isTiming) {
        this.isTiming = isTiming;
    }
    
    
}
