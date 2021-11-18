package model;

public class JavaBeans {
	//vari�veis encapsuladas, usadas no armazenamento tempor�rio do fluxo
		private String id;
		private String produto;
		private String quantidade;
		private String valor;
		
		//m�todos p�blicos para acessar as vari�veis
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getProduto() {
			return produto;
		}
		public void setProduto(String produto) {
			this.produto = produto;
		}
		public String getQuantidade() {
			return quantidade;
		}
		public void setQuantidade(String quantidade) {
			this.quantidade = quantidade;
		}
		public String getValor() {
			return valor;
		}
		public void setValor(String valor) {
			this.valor = valor;
		}
		//Construtor principal
		public JavaBeans() {
			super();
			
		}
		//Construtor que ser� usado no ARRAYLIST (vetor din�mico)
		public JavaBeans(String id, String produto, String quantidade, String valor) {
			super();
			this.id = id;
			this.produto = produto;
			this.quantidade = quantidade;
			this.valor = valor;
		}
		


}
