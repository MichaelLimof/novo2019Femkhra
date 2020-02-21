package com.femkhra.Controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.femkhra.Models.Cadastro;
import com.femkhra.Models.Equipamento;
import com.femkhra.Models.Usuario;
import com.femkhra.Repositories.EmpresaRepository;
import com.femkhra.Repositories.EquipamentoRepository;
import com.femkhra.Services.TaskService;
import com.femkhra.Services.UsuarioService;

@Controller
public class ProfileController {
	
	@Autowired
	private TaskService taskService;
	@Autowired
	private UsuarioService usuarioService;
//	@Autowired
//	private EmpresaRepository er;
//
//	@Autowired
//	private EquipamentoRepository eR;
//	

	
	
	
	@GetMapping("/profile")
	public String showProfilePage(Model model, Principal principal) {
		String email = principal.getName();
		Usuario usuario = usuarioService.findOne(email);
		model.addAttribute("cadastros", taskService.findUsuarioTask(usuario));
		return "views/profile";
		
	}
	
//	@GetMapping("/detalhes")
//	
//	public ModelAndView detalhesEquip(@PathVariable("codigo") long codigo) {
//		Cadastro cadastro = er.findByCodigo(codigo);
//		ModelAndView mv = new ModelAndView("views/profile");
//		mv.addObject("cadastro", cadastro);
//		Iterable<Equipamento> equipamentos = eR.findByCadastro(cadastro);
//		mv.addObject("equipamentos", equipamentos);
//		return mv;
//
//	}

	
//	@RequestMapping("/profile")
//	public String showProfilePage(Model model, Principal principal) {
//		
//	
//	String email = principal.getName();
//		Usuario usuario = usuarioService.findOne(email);
//		Iterable<Cadastro> cadastros = taskService.findUsuarioTask(usuario);
//		model.addAttribute("cadastros", cadastros);
//	return "views/profile";
//	}
	
}
