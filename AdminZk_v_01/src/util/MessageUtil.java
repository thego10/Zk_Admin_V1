package util;

import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Messagebox;

public class MessageUtil {
	public static void confirmation(String strMessage, EventListener el){
		Messagebox.show(strMessage,"Confirmation",
				Messagebox.YES | Messagebox.NO,
				Messagebox.QUESTION, el);
	}
		
	public static void information(String strMessage){
		Messagebox.show(strMessage,"Information",Messagebox.OK,
				Messagebox.INFORMATION, null);
	}
	
	public static void warning(String strMessage){
		Messagebox.show(strMessage,"Warning",Messagebox.OK,
				Messagebox.EXCLAMATION, null);
	}
	
	public static void error(String strMessage){
		Messagebox.show(strMessage,"Error",Messagebox.OK,
				Messagebox.ERROR, null);
	}
	
}
