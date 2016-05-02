package controller;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Path;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Captcha;
import org.zkoss.zul.Include;
import org.zkoss.zul.Textbox;

import template.model.UserModel;
import template.service.UserService;
import template.util.IdUtil;
import template.util.RandomUtil;
import util.MessageUtil;

public class LoginController extends GenericForwardComposer {

	private static final long serialVersionUID = 1L;
	private Textbox txtId, txtPassword;
	private String userId, password;

	public void doAfterCompose(Component win) throws Exception {
		super.doAfterCompose(win);
	}

	public void onClick$btnSubmit() {
		userId = txtId.getValue().trim();
		password = txtPassword.getValue().trim();
		if (isValidInput()) {
			// try{
			String strHashPassword = IdUtil.hashPassword(password);
			System.out.println("Password : " + strHashPassword);
			UserModel user = UserService.getUserByLogin(userId, strHashPassword);
			System.out.println("Id : " + user);
			if (user != null) {
				Executions.sendRedirect("menu.zul");
			} else {
				MessageUtil.information("Id atau password salah..");
			}
		}
	}

	private Boolean isValidInput() {
		Boolean res = true;
		String strId = txtId.getValue().trim();
		String strPassword = txtPassword.getValue().trim();

		if (strId.trim().isEmpty()) {
			res = false;
			MessageUtil.error("Id harus diisi");
		} else if (strPassword.trim().isEmpty()) {
			res = false;
			MessageUtil.error("Password harus diisi");
		}
		return res;
	}
}
