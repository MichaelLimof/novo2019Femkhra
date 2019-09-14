package com.femkhra.Models;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.bind.annotation.DeleteMapping;




@Entity
@Table(name = "equipamento")
public class Equipamento {
	@Id
	@NotEmpty
	private String numero_serie;
	@NotEmpty
	private String marca;
	@NotEmpty
	private String modelo;
	@NotEmpty
	private String dataInserircao;
	@NotEmpty
	private String tensaoMaxima;
	@NotEmpty
	private String tensaoOperacao;
	@NotEmpty
	private String mAmaximo;
	@NotEmpty
	private String tempoMaximo;
	@NotEmpty
	private String tempoUtilizado;
	@NotEmpty
	private int qtdRadiografias;
	
	private String correcaoTensao;
	
	private String disparadorAuto;
	@NotEmpty
	private String caboDisparador;
	@NotEmpty
	private String contadorTempo;
	@NotEmpty
	private String coneComprimento;
	@NotEmpty
	private String coneDiametro;
	@NotEmpty
	private String coneExtremidade;
	@NotEmpty
	private String distaciaFoco;
	@NotEmpty
	private String formaOnda;

	@ManyToOne
	private Cadastro cadastro;  
	
		
	
	public String getNumero_serie() {
		return numero_serie;
	}
	public void setNumero_serie(String numero_serie) {
		this.numero_serie = numero_serie;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getDataInserircao() {
		return dataInserircao;
	}
	public void setDataInserircao(String dataInserircao) {
		this.dataInserircao = dataInserircao;
	

}
	public Cadastro getCadastro() {
		return cadastro;
	}
	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}
	
	public String getTensaoMaxima() {
		return tensaoMaxima;
	}
	public void setTensaoMaxima(String tensaoMaxima) {
		this.tensaoMaxima = tensaoMaxima;
	}
	public String getTensaoOperacao() {
		return tensaoOperacao;
	}
	public void setTensaoOperacao(String tensaoOperacao) {
		this.tensaoOperacao = tensaoOperacao;
	}
	public String getmAmaximo() {
		return mAmaximo;
	}
	public void setmAmaximo(String mAmaximo) {
		this.mAmaximo = mAmaximo;
	}
	public String getTempoMaximo() {
		return tempoMaximo;
	}
	public void setTempoMaximo(String tempoMaximo) {
		this.tempoMaximo = tempoMaximo;
	}
	public String getTempoUtilizado() {
		return tempoUtilizado;
	}
	public void setTempoUtilizado(String tempoUtilizado) {
		this.tempoUtilizado = tempoUtilizado;
	}
	public int getQtdRadiografias() {
		return qtdRadiografias;
	}
	public void setQtdRadiografias(int qtdRadiografias) {
		this.qtdRadiografias = qtdRadiografias;
	}
	public String getCorrecaoTensao() {
		return correcaoTensao;
	}
	public void setCorrecaoTensao(String correcaoTensao) {
		this.correcaoTensao = correcaoTensao;
	}
	public String getDisparadorAuto() {
		return disparadorAuto;
	}
	public void setDisparadorAuto(String disparadorAuto) {
		this.disparadorAuto = disparadorAuto;
	}
	public String getCaboDisparador() {
		return caboDisparador;
	}
	public void setCaboDisparador(String caboDisparador) {
		this.caboDisparador = caboDisparador;
	}
	public String getContadorTempo() {
		return contadorTempo;
	}
	public void setContadorTempo(String contadorTempo) {
		this.contadorTempo = contadorTempo;
	}
	public String getConeComprimento() {
		return coneComprimento;
	}
	public void setConeComprimento(String coneComprimento) {
		this.coneComprimento = coneComprimento;
	}
	public String getConeDiametro() {
		return coneDiametro;
	}
	public void setConeDiametro(String coneDiametro) {
		this.coneDiametro = coneDiametro;
	}
	public String getConeExtremidade() {
		return coneExtremidade;
	}
	public void setConeExtremidade(String coneExtremidade) {
		this.coneExtremidade = coneExtremidade;
	}
	public String getDistaciaFoco() {
		return distaciaFoco;
	}
	public void setDistaciaFoco(String distaciaFoco) {
		this.distaciaFoco = distaciaFoco;
	}
	public String getFormaOnda() {
		return formaOnda;
	}
	public void setFormaOnda(String formaOnda) {
		this.formaOnda = formaOnda;
	}
	
}