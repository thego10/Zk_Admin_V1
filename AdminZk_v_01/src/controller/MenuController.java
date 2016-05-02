package controller;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zkmax.zul.Navbar;
import org.zkoss.zkmax.zul.Navitem;
import org.zkoss.zul.A;
import org.zkoss.zul.Div;
import org.zkoss.zul.Hlayout;
import org.zkoss.zul.Include;
import org.zkoss.zul.Messagebox;


public class MenuController extends SelectorComposer<Component> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Wire
	Hlayout main;
	@Wire
	Div sidebar;
	@Wire
	Navbar navbar;
	@Wire
	Navitem calitem, mnDashboard, mnMasterUser, mnMasterData, mnPenjualan;
	@Wire
	A toggler;
	
	@Wire
	Include mainInclude;
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		setDefaultPanel();
	}
	
    private void setDefaultPanel() {
    	mnDashboard.setSelected(true);
    	mainInclude.setSrc("/page.zul");
    }
    
    @Listen("onClick = #mnDashboard")
    public void clickDashboard(){
    	setDefaultPanel();
    	mainInclude.setSrc("/page.zul");
    }
    
    @Listen("onClick = #mnMasterUser")
    public void clickMenuUser(){
    	mainInclude.setSrc("/contoh.zul");
    }
    
    @Listen("onClick = #mnMasterData")
    public void clickmnMasterData(){
    	mainInclude.setSrc("/masterdata.zul");
    }
    @Listen("onClick = #mnPenjualan")
    public void clickmnMasterPenjualan(){
    	mainInclude.setSrc("/penjualan.zul");
    }
}
