package qubo.gui;

import qubo.QuboInstance;
import utils.InvalidRangeException;
import utils.Log;

class InstanceRunnable implements Runnable {


    private final QuboInstance quboInstance;
    private final MainWindow window;

    public void stop(){
        this.quboInstance.stop();
    }

    public InstanceRunnable(QuboInstance quboInstance, MainWindow window){ //window è un "puntatore" alla finestra principale
        this.quboInstance = quboInstance;
        this.window = window;
    }

    @Override
    public void run() {
        try{
            quboInstance.run();
        }
        catch (NumberFormatException e){
            if(Confirm.requestConfirm("Check input and relaunch program, would you like to see an example configuration?"))
                window.exampleConf();
        }
        window.idle();
        Log.logln("Stopped");
    }
}
