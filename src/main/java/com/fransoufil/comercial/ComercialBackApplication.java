package com.fransoufil.comercial;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fransoufil.comercial.domain.Categoria;
import com.fransoufil.comercial.domain.Cidade;
import com.fransoufil.comercial.domain.Cliente;
import com.fransoufil.comercial.domain.Endereco;
import com.fransoufil.comercial.domain.Estado;
import com.fransoufil.comercial.domain.Pagamento;
import com.fransoufil.comercial.domain.PagamentoComBoleto;
import com.fransoufil.comercial.domain.PagamentoComCartao;
import com.fransoufil.comercial.domain.Pedido;
import com.fransoufil.comercial.domain.Produto;
import com.fransoufil.comercial.domain.enums.EstadoPagamento;
import com.fransoufil.comercial.domain.enums.TipoCliente;
import com.fransoufil.comercial.repositories.CategoriaRepository;
import com.fransoufil.comercial.repositories.CidadeRepository;
import com.fransoufil.comercial.repositories.ClienteRepository;
import com.fransoufil.comercial.repositories.EnderecoRepository;
import com.fransoufil.comercial.repositories.EstadoRepository;
import com.fransoufil.comercial.repositories.PagamentoRepository;
import com.fransoufil.comercial.repositories.PedidoRepository;
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
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;

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
				
				Cliente cli1 = new Cliente(null, "Francisco Souza", "francisco@souza", "3333333366", TipoCliente.PESSOAFISICA);
				Cliente cli2 = new Cliente(null, "Felipe Souza", "felipe@souza", "55566677788", TipoCliente.PESSOAJURIDICA);
				Cliente cli3 = new Cliente(null, "Claudia Cristina", "claudia@cristina", "66677788899", TipoCliente.PESSOAFISICA);
				
				cli1.getTelefones().addAll(Arrays.asList("33335555", "977778888"));
				cli2.getTelefones().addAll(Arrays.asList("977889933"));
				cli3.getTelefones().addAll(Arrays.asList("66778833", "955778822"));
				
				Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 777", "Jardim", "33330077", cli1, c1);
				Endereco e2 = new Endereco(null, "Rua Madeira", "88", "Apto 333", "Vila", "77889955", cli1, c3);
				Endereco e3 = new Endereco(null, "Rua Nuvem", "23", "Apto 17", "Aliança", "22445566", cli2, c2);
				Endereco e4 = new Endereco(null, "Rua Jandira", "15", null, "Alameda", "55336666", cli3, c3);
				
				cli1.getEndereco().addAll(Arrays.asList(e1, e2));
				cli2.getEndereco().addAll(Arrays.asList(e3));
				cli3.getEndereco().addAll(Arrays.asList(e4));
				
				clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3));
				
				enderecoRepository.saveAll(Arrays.asList(e1, e2, e3, e4));
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
				
				Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
				Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);
				
				Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
				ped1.setPagamento(pagto1);
				
				Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
				ped2.setPagamento(pagto2);
				
				cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
				
				pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
				pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
	}

}
