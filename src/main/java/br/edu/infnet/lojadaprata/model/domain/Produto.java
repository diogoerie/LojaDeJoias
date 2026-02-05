package br.edu.infnet.lojadaprata.model.domain;

import com.sun.istack.NotNull;
import excecoes.DiametroInvalidoExcecao;
import excecoes.PesoInvalidoExcecao;
import excecoes.QuantidadeInvalidaExcecao;
import excecoes.TamanhoInvalidoExcecao;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "TProduto")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	private String nomeProduto;
	@NotNull
	private String preco;
	@NotNull
	private String codigoProduto;
	@NotNull
	private String quantidade;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario cadastro;
	@ManyToMany(mappedBy = "produtos")
	private List<Pedido> pedidos;
	public Produto(){
	}

	public Produto(String nomeProduto,String codigoProduto,String preco,String quantidade)throws QuantidadeInvalidaExcecao{
		this.nomeProduto = nomeProduto;
		this.codigoProduto = codigoProduto;
		this.preco = preco;
		this.quantidade = quantidade;
		float valorQ = Float.parseFloat(quantidade);
		if(valorQ <= 0 ){
			throw new QuantidadeInvalidaExcecao("A quantidade de produtos não pode ser menor ou igual a zero.");
		}
	}
	public abstract float calcularPreco() throws PesoInvalidoExcecao,DiametroInvalidoExcecao,TamanhoInvalidoExcecao;

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(nomeProduto);
		sb.append(";");
		sb.append(codigoProduto);
		sb.append(";");
		sb.append(preco);
		sb.append(";");
		sb.append(quantidade);
		sb.append(";");
		return sb.toString();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public String getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public Usuario getCadastro() {
		return cadastro;
	}

	public void setCadastro(Usuario cadastro) {
		this.cadastro = cadastro;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
}
