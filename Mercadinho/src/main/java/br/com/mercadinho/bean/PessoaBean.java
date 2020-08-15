package br.com.mercadinho.bean;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.mercadinho.dao.MercadinhoDao;
import br.com.mercadinho.entidade.Pessoa;

@ViewScoped
@ManagedBean(name = "pessoa")
public class PessoaBean {

	private String nomeCompleto;
	private String nome;
	private String sobrenome;
	private Pessoa pessoa = new Pessoa();
	private MercadinhoDao<Pessoa> dao = new MercadinhoDao<Pessoa>();

	private List<String> nomes = new ArrayList<>();

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public List<String> getNomes() {
		return nomes;
	}

	public void setNomes(List<String> nomes) {
		this.nomes = nomes;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public void exibirNome() {

		this.nomeCompleto = this.nome.toUpperCase() + " " + this.sobrenome.toUpperCase();
		this.nomes.add(nome);
		this.nome = "";
		this.sobrenome = "";

	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public MercadinhoDao<Pessoa> getDao() {
		return dao;
	}

	public void setDao(MercadinhoDao<Pessoa> dao) {
		this.dao = dao;
	}

	public void remover() {
		int i = this.nomes.size() - 1;
		if (i >= 0) {
			if (i < this.nomes.size()) {

				this.nomes.remove(i);
				i = i + 2;
				this.nomeCompleto = "";
			}

		}
	}

	public void salvar() {

		 pessoa = dao.merge(pessoa);
		
	}
	
	
}
