package backendSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import _model.MembersBean;

@Controller
//@SessionAttributes("Mem_LoginOK")
public class redirectController {
//這裡放要被控管的轉址

	// 所有員工資料
	@GetMapping(value = "/memberSystem/allMember")
	public String AllMember() {
		return "memberSystem/allMember";
	}

	// 所有顧客資料
	@GetMapping(value = "/memberSystem/allCustomer")
	public String AllCustomer() {
		return "memberSystem/allCustomer";
	}

	// 客服系統
	@GetMapping(value = "/customerService")
	public String getChat() {
		return "messageSystem/customerService";
	}

}
