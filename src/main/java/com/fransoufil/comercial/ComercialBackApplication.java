package com.fransoufil.comercial;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fransoufil.comercial.domain.Categoria;
import com.fransoufil.comercial.domain.Cidade;
import com.fransoufil.comercial.domain.Estado;
import com.fransoufil.comercial.domain.Produto;
import com.fransoufil.comercial.repositories.CategoriaRepository;
import com.fransoufil.comercial.repositories.CidadeRepository;
import com.fransoufil.comercial.repositories.EstadoRepository;
import com.fransoufil.comercial.repositories.ProdutoRepository;

@SpringBootApplication
public class ComercialBackApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	public static void main(String[] args) {
		SpringApplication.run(ComercialBackApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		//2.21
				Estado est1 = new Estado(null, "Minas Gerais");
				Estado est2 = new Estado(null, "São Paulo");

				Cidade c1 = new Cidade(null, "Uberlândia", est1);
				Cidade c2 = new Cidade(null, "São Paulo", est2);
				Cidade c3 = new Cidade(null, "Campinas", est2);

				est1.getCidades().addAll(Arrays.asList(c1));
				est2.getCidades().addAll(Arrays.asList(c2, c3));

				estadoRepository.saveAll(Arrays.asList(est1, est2));
				cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
	}

}
