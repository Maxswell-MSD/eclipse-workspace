/**
* Validação dos formulários
 * @author Maxswell Sousa Diniz
 */
function validar() {
	//variáveis usadas para capturar o texto do formulário
	let nome = frmAgenda.nome.value;
	let fone = frmAgenda.fone.value;
	let email = frmAgenda.email.value;
	
	if (nome === "") {
		alert("Preencha o campo nome");
		frmAgenda.nome.focus();
	} else if (fone === "") {
		alert("Preencha o telefone");
		frmAgenda.fone.focus();
	} else if (email === "") {
		alert("Preencha o Email");
		frmAgenda.email.focus();
	} else {
		//submeter o formulário
	}
	
	
}