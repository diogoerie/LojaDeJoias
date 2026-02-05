package br.edu.infnet.lojadaprata.model.domain;

import excecoes.PesoInvalidoExcecao;
import excecoes.QuantidadeInvalidaExcecao;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "TColar")
public class Colar extends Produto {
	private String modelo;
	private boolean pingente;
	private int peso;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario cadastro;
	public Colar(){	}
	public Colar(String nomeProduto, String codigoProduto, String preco,String quantidade)throws QuantidadeInvalidaExcecao{
		super(nomeProduto, codigoProduto, preco,quantidade);

	}
	@Override
	public float calcularPreco() throws PesoInvalidoExcecao{
		float val = Float.parseFloat(getPreco());
		if(peso > 300 || peso <= 0){
			throw new PesoInvalidoExcecao("O peso não pode ser igual a zero ou superior a 300g");
		}
		return val+ (pingente ? 9:6) * peso;
	}
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(modelo);
		sb.append(";");
		sb.append(peso);
		sb.append(";");
		sb.append(pingente ? "ComPingente" : "SemPingente");
		sb.append(";");
		return sb.toString();
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public boolean isPingente() {
		return pingente;
	}

	public void setPingente(boolean pingente) {
		this.pingente = pingente;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	@Override
	public Usuario getCadastro() {
		return cadastro;
	}

	@Override
	public void setCadastro(Usuario cadastro) {
		this.cadastro = cadastro;
	}
}
