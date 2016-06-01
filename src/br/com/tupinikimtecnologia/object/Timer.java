/*
 * Created by: Felipe Rodrigues
 * http://www.tupinikimtecnologia.com.br
 */
package br.com.tupinikimtecnologia.object;

import java.util.TimerTask;

/**
 *
 * @author felipe
 * @version 0.5
 * --- Class that count minutes and seconds ---
 */
public class Timer extends TimerTask {

    private int second = 0, minute = 0;
    private boolean isTiming = false;
    
    public void stopTime(){
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
    }
    
    
}
