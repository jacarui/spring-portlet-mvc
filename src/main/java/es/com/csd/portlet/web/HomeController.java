package es.com.csd.portlet.web;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import es.com.csd.portlet.domain.User;
import es.com.csd.portlet.repository.UserRepository;

@Controller
@RequestMapping("VIEW")
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private UserRepository userRepository;

	private void afterPropertiesSet() {
		if (userRepository.count() == 0) {
			for (int i = 0; i < 45; i++) {
				saveUser("username" + 1);
			}
		}
	}

	private void saveUser(String username) {
		User usuario = new User();
		usuario.setFirstName("first");
		usuario.setUsername(username);
		userRepository.save(usuario);
	}

	@RenderMapping
	public ModelAndView showHome(Locale locale, ModelAndView model) {
		afterPropertiesSet();
		model.addObject("users", userRepository.findByUsernameLike("user%"));
		model.setViewName("home");

		return model;
	}

}
