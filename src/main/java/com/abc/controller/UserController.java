package com.abc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.abc.model.Book;
import com.abc.model.User;
import com.abc.repository.UserRepository;
import com.abc.service.UserService;

@Controller
@RequestMapping("/admin/user")
public class UserController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserService userService;

	@GetMapping("/list")
	public String ListUsers(Model model) {

		List<User> listUsers = userService.getList();
		model.addAttribute("users", listUsers);
		return "admin/user/list-users";
	}

	@GetMapping("/add")
	public String AddUser(@ModelAttribute("userRequest") User userRequest, Model model, HttpSession session) {
		model.addAttribute("userRequest", userRequest);
		return "admin/user/add-user";
	}

	@PostMapping("/add")
	public String save(@ModelAttribute User userRequest, RedirectAttributes redirectAttributes) throws IOException {
		try {
			List<User> list = userService.getList();
			for (User user : list) {
				if (user.getUsername().equals(userRequest.getUsername())) {
					redirectAttributes.addFlashAttribute("message",
							"Tên đăng nhập đã tồn tại. Vui lòng nhập tên đăng nhập khác!");
					redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
					return "redirect:/admin/user/add";
				}
			}

			userService.save(userRequest);
		} catch (Exception e) {
		}
		redirectAttributes.addFlashAttribute("message", "Thêm mới thành viên thành công!");
	    redirectAttributes.addFlashAttribute("alertClass", "alert-success");
		return "redirect:/admin/user/list";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") long id) {
		try {
			userService.deleteById(id);
		} catch (Exception e) {
		}

		return "redirect:/admin/user/list";
	}

	@GetMapping("/search")
	public String searchName(HttpServletRequest request, HttpServletResponse response, Model model,
			HttpSession session) {
		String timkiem = request.getParameter("timkiem");
		List<User> listUsers = userService.searchName(timkiem);
		if (listUsers.size() == 0) {
			session.setAttribute("messa", "Không có tên bạn cần tìm!");
			return "admin/user/list-users";
		}
		session.setAttribute("messa", "");
		model.addAttribute("users", listUsers);
		return "admin/user/list-users";
	}
}
