public class CaixaEletronico implements ICaixaEletronico {

	private int cedulas[][] = { { 100, 100 }, { 50, 200 }, { 20, 300 }, { 10, 350 }, { 5, 450 }, { 2, 500 } };
	public int cotaMinima;

	public CaixaEletronico(){
		this.cotaMinima = Integer.parseInt(pegaValorTotalDisponivel());
	}
	
	public String pegaRelatorioCedulas() {
		String resposta = "Relatório de notas: \n\n";

		for (int i = 0; i < this.cedulas.length; i++) {
			resposta += "Cédula: R$ " + this.cedulas[i][0] + ",00  Quantidade:" + this.cedulas[i][1] + "\n";
		}

		return resposta;
	}

	public String pegaValorTotalDisponivel() {
		String resposta = "";
		int valorTotal = 0;
		
		for (int i = 0; i < this.cedulas.length; i++) {
			valorTotal += (this.cedulas[i][0] * this.cedulas[i][1]);
		}

		resposta = Integer.toString(valorTotal);
		return resposta;
	}

	public String reposicaoCedulas(Integer cedula, Integer quantidade) {
		String resposta = "";

		switch (cedula) {
		case 100:
			this.cedulas[0][1] += quantidade;
			resposta += "Quantidade: " + quantidade + " Nota: R$ 100.\n";
			break;
		case 50:
			this.cedulas[1][1] += quantidade;
			resposta += "Quantidade: " + quantidade + " Nota: R$ 50.\n";
			break;
		case 20:
			this.cedulas[2][1] += quantidade;
			resposta += "Quantidade: " + quantidade + " Nota: R$ 20.\n";
			break;
		case 10:
			this.cedulas[3][1] += quantidade;
			resposta += "Quantidade: " + quantidade + " Nota: R$ 10.\n";
			break;
		case 5:
			this.cedulas[4][1] += quantidade;
			resposta += "Quantidade: " + quantidade + " Nota: R$ 5.\n";
			break;
		case 2:
			this.cedulas[5][1] += quantidade;
			resposta += "Quantidade: " + quantidade + " Nota: R$ 2.\n";
			break;

		default:
			break;
		}

		return resposta;
	}

	public String sacar(Integer valor) {
		String resposta = "Seu saque contém: \n";

		int cedula100 = 0, cedula50 = 0, cedula20 = 0, cedula10 = 0, cedula5 = 0, cedula2 = 0, totalCedulas = 0, aux = 0;
		
		//Atribui ao valorTotal o valor total disponível no caixa
		int valorTotal = Integer.parseInt(pegaValorTotalDisponivel());

		//Verifica se o valor a ser sacado está disponível para saque
		if (valor > valorTotal || valor == 1) {
			resposta = "Saque não realizado por falta de cédulas";
		} else {
			
			//Divide o valor a ser sacado por 100 para saber quantas notas deste tipo serão necessárias
			cedula100 = valor / 100;
			//Verifica se serão necessárias notas de 100 e se existem notas deste tipo disponível
			if(cedula100 > 0 && cedulas[0][1] > 0) {
				//Verifica se a quantidade de notas deste tipo atende a quantidade necessária para o saque 
				if(cedulas[0][1] - cedula100 >= 0){
					//Subtrai das cédulas disponíveis a quantia exigida no saque
					cedulas[0][1] -= cedula100;
					//Pega o restante do valor para prosseguir a operação
					valor %= 100;
					//Concatena a resposta 
					resposta += cedula100 + " nota(s) de R$ 100 \n";
				}
				//Caso a quantidade de notas disponíveis seja inferior do que a necessária
				else{
					//Variável auxiliar para guardar o resto do valor
					aux = valor % 100;
					//Multiplica-se a quantidades de notas faltantes pela nota da vez e soma-se o resto
					valor = ((cedula100 - cedulas[0][1]) * 100 ) + aux ;
					//Atribui a quantidade de cédulas retiradas
					cedula100 = cedulas[0][1];
					//Concatena a resposta com a quantidade de cédulas deste tipo disponível
					resposta += cedula100 + " nota(s) de R$ 100 \n";
					//Zera a quantidade de cedulas disponíveis para este tipo
					cedulas[0][1] = 0;
				}
			}
			//Zera as cédulas deste tipo pois a mesma não é necessária ou não está disponível
			else{
				cedula100 = 0;
			}
			
			//Divide o valor a ser sacado por 50 para saber quantas notas deste tipo serão necessárias
			cedula50 = valor / 50;
			//Verifica se serão necessárias notas de 50 e se existem notas deste tipo disponível
			if(cedula50 > 0 && cedulas[1][1] > 0) {
				//Verifica se a quantidade de notas deste tipo atende a quantidade necessária para o saque 
				if(cedulas[1][1] - cedula50 >= 0){
					//Subtrai das cédulas disponíveis a quantia exigida no saque
					cedulas[1][1] -= cedula50;
					//Pega o restante do valor para prosseguir a operação
					valor %= 50;
					//Concatena a resposta 
					resposta += cedula50 + " nota(s) de R$ 50 \n";
				}
				//Caso a quantidade de notas disponíveis seja inferior do que a necessária
				else{
					//Variável auxiliar para guardar o resto do valor
					aux = valor % 50;
					//Multiplica-se a quantidades de notas faltantes pela nota da vez e soma-se o resto
					valor = ((cedula50 - cedulas[1][1]) * 50 ) + aux ;
					//Atribui a quantidade de cédulas retiradas
					cedula50 = cedulas[1][1];
					//Concatena a resposta com a quantidade de cédulas deste tipo disponível
					resposta += cedula50 + " nota(s) de R$ 50 \n";
					//Zera a quantidade de cedulas disponíveis para este tipo
					cedulas[1][1] = 0;
				}
			}
			//Zera as cédulas deste tipo pois a mesma não é necessária ou não está disponível
			else{
				cedula50 = 0;
			}

			
			//Divide o valor a ser sacado por 20 para saber quantas notas deste tipo serão necessárias
			cedula20 = valor / 20;
			//Verifica se serão necessárias notas de 20 e se existem notas deste tipo disponível
			if(cedula20 > 0 && cedulas[2][1] > 0) {
				//Verifica se a quantidade de notas deste tipo atende a quantidade necessária para o saque 
				if(cedulas[2][1] - cedula20 >= 0){
					//Subtrai das cédulas disponíveis a quantia exigida no saque
					cedulas[2][1] -= cedula20;
					//Pega o restante do valor para prosseguir a operação
					valor %= 20;
					//Concatena a resposta 
					resposta += cedula20 + " nota(s) de R$ 20 \n";
				}
				//Caso a quantidade de notas disponíveis seja inferior do que a necessária
				else{
					//Variável auxiliar para guardar o resto do valor
					aux = valor % 20;
					//Multiplica-se a quantidades de notas faltantes pela nota da vez e soma-se o resto
					valor = ((cedula20 - cedulas[2][1]) * 20 ) + aux ;
					//Atribui a quantidade de cédulas retiradas
					cedula20 = cedulas[2][1];
					//Concatena a resposta com a quantidade de cédulas deste tipo disponível
					resposta += cedula20 + " nota(s) de R$ 20 \n";
					//Zera a quantidade de cedulas disponíveis para este tipo
					cedulas[2][1] = 0;
				}
			}
			//Zera as cédulas deste tipo pois a mesma não é necessária ou não está disponível
			else{
				cedula20 = 0;
			}


			//Divide o valor a ser sacado por 10 para saber quantas notas deste tipo serão necessárias
			cedula10 = valor / 10;
			//Verifica se serão necessárias notas de 10 e se existem notas deste tipo disponível
			if(cedula10 > 0 && cedulas[3][1] > 0) {
				//Verifica se a quantidade de notas deste tipo atende a quantidade necessária para o saque 
				if(cedulas[3][1] - cedula10 >= 0){
					//Subtrai das cédulas disponíveis a quantia exigida no saque
					cedulas[3][1] -= cedula10;
					//Pega o restante do valor para prosseguir a operação
					valor %= 10;
					//Concatena a resposta 
					resposta += cedula10 + " nota(s) de R$ 10 \n";
				}
				//Caso a quantidade de notas disponíveis seja inferior do que a necessária
				else{
					//Variável auxiliar para guardar o resto do valor
					aux = valor % 10;
					//Multiplica-se a quantidades de notas faltantes pela nota da vez e soma-se o resto
					valor = ((cedula10 - cedulas[3][1]) * 10 ) + aux ;
					//Atribui a quantidade de cédulas retiradas
					cedula10 = cedulas[3][1];
					//Concatena a resposta com a quantidade de cédulas deste tipo disponível
					resposta += cedula10 + " nota(s) de R$ 10 \n";
					//Zera a quantidade de cedulas disponíveis para este tipo
					cedulas[3][1] = 0;
				}
			}
			//Zera as cédulas deste tipo pois a mesma não é necessária ou não está disponível
			else{
				cedula10 = 0;
			}

			//Divide o valor a ser sacado por 5 para saber quantas notas deste tipo serão necessárias
			cedula5 = valor / 5;
			//Verifica se serão necessárias notas de 5 e se existem notas deste tipo disponível
			if(cedula5 > 0 && cedulas[4][1] > 0 && valor != 6 && valor != 8) {
				//Verifica se a quantidade de notas deste tipo atende a quantidade necessária para o saque 
				if(cedulas[4][1] - cedula5 >= 0){
					//Subtrai das cédulas disponíveis a quantia exigida no saque
					cedulas[4][1] -= cedula5;
					//Pega o restante do valor para prosseguir a operação
					valor %= 5;
					//Concatena a resposta 
					resposta += cedula5 + " nota(s) de R$ 5 \n";
				}
				//Caso a quantidade de notas disponíveis seja inferior do que a necessária
				else{
					//Variável auxiliar para guardar o resto do valor
					aux = valor % 5;
					//Multiplica-se a quantidades de notas faltantes pela nota da vez e soma-se o resto
					valor = ((cedula5 - cedulas[4][1]) * 5 ) + aux ;
					//Atribui a quantidade de cédulas retiradas
					cedula5 = cedulas[4][1];
					//Concatena a resposta com a quantidade de cédulas deste tipo disponível
					resposta += cedula5 + " nota(s) de R$ 5 \n";
					//Zera a quantidade de cedulas disponíveis para este tipo
					cedulas[4][1] = 0;
				}
			}
			//Zera as cédulas deste tipo pois a mesma não é necessária ou não está disponível
			else{
				cedula5 = 0;
			}
			
			//Divide o valor a ser sacado por 2 para saber quantas notas deste tipo serão necessárias
			cedula2 = valor / 2;
			//Verifica se serão necessárias notas de 2 e se existem notas deste tipo disponível
			if(cedula2 > 0 && cedulas[5][1] > 0) {
				//Verifica se a quantidade de notas deste tipo atende a quantidade necessária para o saque 
				if(cedulas[5][1] - cedula2 >= 0){
					//Subtrai das cédulas disponíveis a quantia exigida no saque
					cedulas[5][1] -= cedula2;
					//Pega o restante do valor para prosseguir a operação
					valor %= 2;
					//Concatena a resposta 
					resposta += cedula2 + " nota(s) de R$ 2 \n";
				}
				//Caso a quantidade de notas disponíveis seja inferior do que a necessária
				else{
					//Variável auxiliar para guardar o resto do valor
					aux = valor % 2;
					//Multiplica-se a quantidades de notas faltantes pela nota da vez e soma-se o resto
					valor = ((cedula2 - cedulas[5][1]) * 2 ) + aux ;
					//Atribui a quantidade de cédulas retiradas
					cedula2 = cedulas[5][1];
					//Concatena a resposta com a quantidade de cédulas deste tipo disponível
					resposta += cedula2 + " nota(s) de R$ 2 \n";
					//Zera a quantidade de cedulas disponíveis para este tipo
					cedulas[5][1] = 0;
				}
			}
			//Zera as cédulas deste tipo pois a mesma não é necessária ou não está disponível
			else{
				cedula2 = 0;
			}

			
			//Verifica se soboru algun valor
			if(valor > 0){
				resposta = "Saque não realizado por falta de cédulas";
			} else{
				
				//Soma a quantidade de cedulas removidas
				totalCedulas = cedula100 + cedula50 + cedula20 + cedula10 + cedula5 + cedula2;
				
				//Verifica se a quantidade de cédulas é maior que o estipulado pela regra
				if(totalCedulas > 30){
					//Repõe as células retiradas
					cedulas[0][1] += cedula100;
					cedulas[1][1] += cedula50;
					cedulas[2][1] += cedula20;
					cedulas[3][1] += cedula10;
					cedulas[4][1] += cedula5;
					cedulas[5][1] += cedula2;
					resposta = "Seu saque ultrapassou o limite de cédulas.";
				} 
			}
		}

		return resposta;
	}

	public String armazenaCotaMinima(Integer minimo) {
		String resposta = " Nova cota mínima: R$ " + minimo + ",00.";
		this.cotaMinima = minimo;
		return resposta;
	}

	public static void main(String arg[]) {
		GUI janela = new GUI();
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
	}

}
