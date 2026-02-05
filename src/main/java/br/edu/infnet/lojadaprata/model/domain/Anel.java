package br.edu.infnet.lojadaprata.model.domain;

import excecoes.DiametroInvalidoExcecao;
import excecoes.QuantidadeInvalidaExcecao;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TAnel")
public class Anel extends Produto {
	private String modelo;
	private boolean sobEncomenda;
	private boolean cravejado;
	private int diametro;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario cadastro;
	public Anel(){

	}
	public Anel(String nomeProduto, String codigoProduto, String preco,String quantidade)throws QuantidadeInvalidaExcecao {
		super(nomeProduto, codigoProduto, preco,quantidade);
	}

	@Override
	public float calcularPreco()throws DiametroInvalidoExcecao{
		float val = Float.parseFloat(getPreco());
		if(diametro > 35 || diametro <= 0){
			throw new DiametroInvalidoExcecao("O diametro do anel não pode ser igual a zero ou superior a 35mm.");
		}
		return val+ ((sobEncomenda ? 5 : 1) * (cravejado ? 8 : 2));
	}
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(modelo);
		sb.append(";");
		sb.append(sobEncomenda ? "Encomenda" : "TamanhoDiverso");
		sb.append(";");
		sb.append(cravejado ? "Cravejado" : "Liso");
		sb.append(";");
		return sb.toString();
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public boolean isSobEncomenda() {
		return sobEncomenda;
	}

	public void setSobEncomenda(boolean sobEncomenda) {
		this.sobEncomenda = sobEncomenda;
	}

	public boolean isCravejado() {
		return cravejado;
	}

	public void setCravejado(boolean cravejado) {
		this.cravejado = cravejado;
	}

	public int getDiametro() {
		return diametro;
	}

	public void setDiametro(int diametro) {
		this.diametro = diametro;
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
