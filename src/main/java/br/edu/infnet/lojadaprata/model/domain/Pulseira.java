package br.edu.infnet.lojadaprata.model.domain;

import excecoes.QuantidadeInvalidaExcecao;
import excecoes.TamanhoInvalidoExcecao;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "TPulseira")
public class Pulseira extends Produto {

	private String modelo;
	private boolean maleavel;
	private boolean prendedor;
	private int tamanho;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario cadastro;
	public Pulseira(){}
	public Pulseira(String nomeProduto, String codigoProduto, String preco,String quantidade)throws QuantidadeInvalidaExcecao {
		super(nomeProduto, codigoProduto, preco,quantidade);
	}

	@Override
	public float calcularPreco()throws TamanhoInvalidoExcecao{
		float val = Float.parseFloat(getPreco());
		if(tamanho <= 0){
			throw new TamanhoInvalidoExcecao("O tamnho não pode ser igual ou menor que zero. ");
		}
		return val+ (maleavel ? 12:8) * (prendedor ? 8 : 4);
	}
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(modelo);
		sb.append(";");
		sb.append(maleavel ? "Maleável" : "Rígida");
		sb.append(";");
		sb.append(prendedor ? "Prendedor" : "PeçaUnica");
		sb.append(";");
		sb.append("tamanho");
		return sb.toString();
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public boolean isMaleavel() {
		return maleavel;
	}

	public void setMaleavel(boolean maleavel) {
		this.maleavel = maleavel;
	}

	public boolean isPrendedor() {
		return prendedor;
	}

	public void setPrendedor(boolean prendedor) {
		this.prendedor = prendedor;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
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
