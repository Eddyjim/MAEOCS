import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Form;
import javax.microedition.midlet.*;

public class hola extends MIDlet{

	Thread UIThread;
	Display display;
	Form form;
	
	public hola (){
		display = Display.getDisplay(this);
		form = new Form("hola mundo");
	}


	public void startApp() {
		display.setCurrent(form);
	}

	public void pauseApp() {
		// Here we could reduce the resources but we should keep the Display instance
		// and the eSWT UI Thread. 
	}

	public void destroyApp(boolean unconditional) {
	}
}
