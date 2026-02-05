package br.edu.infnet.lojadaprata.model.domain;

import javax.persistence.*;

import excecoes.ClienteInvalidoExcecao;


@Entity
@Table(name = "TCliente")
public class Cliente {

	private String nome;
	private String email;
	private String rg;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario cadastro;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idEndereco")
	private Endereco endereco;

	public Cliente(){

	}
	public Cliente(String nome,String email,String rg)throws ClienteInvalidoExcecao{

		if(nome == null){
			throw new ClienteInvalidoExcecao("O campo NOME deve ser preechido.");
		}
		if(email == null){
			throw new ClienteInvalidoExcecao("O campo EMAIL deve ser preechido.");
		}
		if(rg == null){
			throw new ClienteInvalidoExcecao("O campo rg deve ser preechido.");
		}
		this.nome = nome;
		this.email = email;
		this.rg = rg;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(nome);
		sb.append(";");
		sb.append(email);
		sb.append(";");
		sb.append(rg);
		return sb.toString();
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getCadastro() {
		return cadastro;
	}
	public void setCadastro(Usuario cadastro) {
		this.cadastro = cadastro;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
