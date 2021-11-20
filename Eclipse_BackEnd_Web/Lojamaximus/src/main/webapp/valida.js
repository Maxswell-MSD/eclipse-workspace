/**
* Validação dos formulários
 * @author Maxswell Sousa Diniz
 */
function validar() {
	//variáveis usadas para capturar o texto do formulário
	let produto = frmProduto.produto.value;
	let quantidade = frmProduto.quantidade.value;
	let valor = frmProduto.valor.value;
	
	if (produto === "") {
		alert("Preencha o campo produto");
		frmProduto.produto.focus();
	} else if (quantidade === "") {
		alert("Preencha a quantidade");
		frmProduto.quantidade.focus();
	} else if (valor === "") {
		alert("Preencha o valor do produto");
		frmProduto.valor.focus();
	} else {
		//submeter o formulário
	}
	
	
}