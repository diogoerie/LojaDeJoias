package br.edu.infnet.lojadaprata.model.domain;

import excecoes.ClienteInvalidoExcecao;
import excecoes.QuantidadeInvalidaExcecao;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.*;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "TPedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String carrinho;
	private String codigoProduto;
	@Column(name = "data_criacao")
	private LocalDateTime data;
	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "idCLiente")
	private Cliente cliente;
	@ManyToMany(cascade = CascadeType.DETACH)
	private List<Produto> produtos;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario cadastro;

	public Pedido() {
	}

	public Pedido(Cliente cliente, List<Produto> produtos) throws ClienteInvalidoExcecao, QuantidadeInvalidaExcecao {
		if (cliente == null) {
			throw new ClienteInvalidoExcecao("Não existe nenhum cliente associado ao pedido!");
		}

		if (produtos == null) {
			throw new QuantidadeInvalidaExcecao("Não existe nenhum produto associado ao pedido!");
		}

		this.cliente = cliente;
		this.produtos = produtos;
		this.data = LocalDateTime.now();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Carrinho: ").append(carrinho).append("\n");
		sb.append("Código do Produto: ").append(codigoProduto).append("\n");
		sb.append("Data do Pedido: ").append(data).append("\n");
		sb.append("Cliente: ").append(cliente).append("\n");
		sb.append("Produtos:\n");
		for (Produto produto : produtos) {
			sb.append(produto).append("\n");
		}
		return sb.toString();
	}

	public String obterLinha() {
		return this.getCarrinho() + ";" + this.getCliente() + ";" + this.getProdutos().size() + "\r\n";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(String carrinho) {
		this.carrinho = carrinho;
	}

	public String getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Usuario getCadastro() {
		return cadastro;
	}

	public void setCadastro(Usuario cadastro) {
		this.cadastro = cadastro;
	}
}
