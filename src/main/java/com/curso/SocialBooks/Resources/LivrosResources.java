package com.curso.SocialBooks.Resources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.curso.SocialBooks.Dao.LivrosDao;
import com.curso.SocialBooks.Informacoes.Livro;

@RestController
public class LivrosResources {
	
	@Autowired
	private LivrosDao livrosDao;

	@RequestMapping(value = "/livros", method = RequestMethod.GET)
	public List<Livro> Listar() {
		return livrosDao.findAll();
	}
	
}
