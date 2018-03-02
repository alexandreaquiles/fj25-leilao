package br.com.caelum.leilao.modelo;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.leilao.util.JPATest;

public class UsuarioTest extends JPATest {
	
	@Test
	public void adicionaUsuario(){
		Usuario usuario = criaUsuario();

		manager.persist(usuario);
		
		long num = manager.createQuery("select count(u) from Usuario u", Long.class).getSingleResult();
		Assert.assertEquals(1, num);
	}
	
	
	@Test
	public void alteraUsuario(){
		Usuario usuario = criaUsuario();
		manager.persist(usuario);
		
		usuario.setNome("Fulano");
		
		manager.flush();
		
		long original = manager.createQuery("select count(u) from Usuario u where u.nome = :nome", Long.class).setParameter("nome", "Fernandino").getSingleResult();
		long alterado = manager.createQuery("select count(u) from Usuario u where u.nome = :nome", Long.class).setParameter("nome", "Fulano").getSingleResult();
		
		Assert.assertEquals(1, alterado);
		Assert.assertEquals(0, original);
	}
	
	@Test
	public void removeUsuario(){
		Usuario usuario = criaUsuario();
		manager.persist(usuario);
		manager.remove(usuario);
		
		long num = manager.createQuery("select count(u) from Usuario u", Long.class).getSingleResult();
		Assert.assertEquals(0, num);
	}
	
	@Test
	public void armazenaEnderecoDoUsuario(){
		Usuario usuario = criaUsuario();
		
		Endereco endereco = criaEndereco();
		usuario.setEndereco(endereco);
		
		manager.persist(usuario);
		
		Usuario adicionado = manager.createQuery("select u from Usuario u where u = :usuario", Usuario.class).setParameter("usuario", usuario).getSingleResult();
		Endereco enderecoAdicionado = adicionado.getEndereco();
		Assert.assertEquals("SCS1", enderecoAdicionado.getLogradouro());
		Assert.assertEquals("Asa Sul", enderecoAdicionado.getBairro());
		Assert.assertEquals("Brasília", enderecoAdicionado.getCidade());
		Assert.assertEquals("DF", enderecoAdicionado.getEstado());
		Assert.assertEquals("12345-678", enderecoAdicionado.getCep());
	}
	
	@Test
	public void adicionaFormasDePagamentoDiversas(){
		Usuario usuario = criaUsuario();
		
		CartaoDeCredito cartao = new CartaoDeCredito();
		cartao.setMesExpiracao(4);
		cartao.setAnoExpiracao(2019);
		cartao.setNumero("12345");
		manager.persist(cartao);
		
		ContaBancaria conta = new ContaBancaria();
		conta.setBanco("BB");
		conta.setAgencia("1234");
		conta.setNumero("2222");
		manager.persist(conta);
		
		usuario.adicionaFormaDePagamento(cartao);
		usuario.adicionaFormaDePagamento(conta);
		
		manager.persist(usuario);
		
		@SuppressWarnings("unchecked")
		List<FormaDePagamento> formasAdicionadas = manager.createQuery("select u.formasDePagamento from Usuario u where u = :usuario").setParameter("usuario", usuario).getResultList();
		Assert.assertEquals(2, formasAdicionadas.size());
		
		Assert.assertTrue(formasAdicionadas.stream().anyMatch(forma -> forma instanceof CartaoDeCredito));
		Assert.assertTrue(formasAdicionadas.stream().anyMatch(forma -> forma instanceof ContaBancaria));
		
	}

	//métodos auxiliares

	static Endereco criaEndereco() {
		Endereco endereco = new Endereco();
		endereco.setLogradouro("SCS1");
		endereco.setBairro("Asa Sul");
		endereco.setCidade("Brasília");
		endereco.setEstado("DF");
		endereco.setCep("12345-678");
		return endereco;
	}
	
	
	static Usuario criaUsuario() {
		Usuario usuario = new Usuario();
		usuario.setEmail("fernandino@gmail.com");
		usuario.setNome("Fernandino");
		usuario.setSobrenome("da Silva");
		return usuario;
	}

}
