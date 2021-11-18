package model;

public class JavaBeans {
	//vari�veis encapsuladas, usadas no armazenamento tempor�rio do fluxo
			private String id;
			private String nome;
			private String fone;
			private String email;
			
			//m�todos p�blicos para acessar as vari�veis
			public String getId() {
				return id;
			}
			public void setId(String id) {
				this.id = id;
			}
			public String getNome() {
				return nome;
			}
			public void setNome(String nome) {
				this.nome = nome;
			}
			public String getFone() {
				return fone;
			}
			public void setFone(String fone) {
				this.fone = fone;
			}
			public String getEmail() {
				return email;
			}
			public void setEmail(String email) {
				this.email = email;
			}
			//Construtor principal
			public JavaBeans() {
				super();
				
			}
			//Construtor que ser� usado no ARRAYLIST (vetor din�mico)
			public JavaBeans(String id, String nome, String fone, String email) {
				super();
				this.id = id;
				this.nome = nome;
				this.fone = fone;
				this.email = email;
			}
			
			

}
