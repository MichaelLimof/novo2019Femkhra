package com.femkhra.Controllers;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.femkhra.Models.Cadastro;
import com.femkhra.Services.TaskService;
import com.femkhra.Services.UsuarioService;

@Controller
public class CompanyController {

	 @Autowired
	 private TaskService taskService;
	 @Autowired
	 private UsuarioService  usuarioService;
	 
//	 @GetMapping("/addTask")
//	 public String taskForm(String email, Model model, HttpSession session) {
//		 
//		 session.setAttribute("email", email); 
//		 model.addAttribute("cadastros", new Cadastro());
//		 return "cadastro/formCadastro";
//		 
//	 }
//	 
//	 @PostMapping("/addTask")
//	 public String addTask(@Valid Cadastro cadastro,BindingResult bindingResult, HttpSession session) {
//		 if(bindingResult.hasErrors()) {
//			 return "redirect:/cadastrarEmpresa";
//		 }
//		 String email = (String) session.getAttribute("email");
//		 taskService.addTask(cadastro, usuarioService.findOne(email));
//		 
//		return  "redirect:/users";
//	 }
	 
	
	 @GetMapping("/addCompany")
	 public String empForm(String email, Model model, HttpSession session) {
		 
		 session.setAttribute("email", email); 
		 model.addAttribute("cadastros", new Cadastro());
		 return "views/addCompanyPage";
		 
	 }
	 //Cadastro de uma Nova Empresa
	 @PostMapping("/addCompany")
	 public String addCompany(@Valid Cadastro cadastro,BindingResult bindingResult, HttpSession session) {
		 if(bindingResult.hasErrors()) {
			 return "redirect:/cadastrarEmpresa";
		 }
		 String email = (String) session.getAttribute("email");
		 taskService.addCompany(cadastro, usuarioService.findOne(email));
		 
		return  "redirect:/users";
	 }
	 
		@RequestMapping(value = "update/{codigo}", method = RequestMethod.GET)
		public ModelAndView attCompany(@Valid Cadastro cadastro,BindingResult bindingResult, HttpSession session) {

			ModelAndView mv = new ModelAndView();
			String codigo = (String) session.getAttribute("codigo");
			taskService.updateCompany(cadastro);
//			mv.addObject("cadastro", cadastro);
			mv.setViewName("views/addCompanyPage");
			return mv;

		}
	 /****************************************************/
//	 @PutMapping("/addCompany")
//	 public String attCompany(@ModelAttribute Cadastro cadastro,BindingResult bindingResult, HttpSession session) {
//		 if(bindingResult.hasErrors()) {
//			 return "redirect:/cadastrarEmpresa";
//		 }
//		 String email = (String) session.getAttribute("email");
//		 taskService.addCompany(cadastro, usuarioService.findOne(email));
//		 
//		return  "redirect:/users";
//	 }
}
