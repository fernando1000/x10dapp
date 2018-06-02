package br.com.x10d.app.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TextoContratos {
	   		
	public String devolveDataAtualFormatada(){
    	
    	Date data =  new Date();
    	Locale locale = new Locale("pt","BR");
    	DateFormat dateFormat = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", locale); 
    	String dataFormatada = dateFormat.format(data);
    	String dataAtual = "Itapevi, "+dataFormatada+". \n";
  
    	return dataAtual;
    }
		
	public String devolveContratoPadrao(String comodosDaCasa, String ruaNumeroCasa, 
										String nomeCompleto, String rg, String cpf,
										String dataInicioLocacao, String dataTerminoLocacao,
										String diaPagamentoAluguel, String valorAluguel){

	String textoContrato = "\n\n" + 
			"IMOVEL CONTRATADO: Uma casa com "+comodosDaCasa+", situado na rua "+ruaNumeroCasa+", Parque Boa Esperança, 06653-590, Itapevi SP.\n\n" + 
			"LOCADOR: Quitéria Pereira Neves, Brasileira, Casada , portadora da cédula de identidade RG: 36.841.743-8 e CPF: 882.476.434-72\n\n" + 
			"LOCATÁRIO: "+nomeCompleto+", RG"+rg+", CPF"+cpf+"\n\n" + 
			"CLÁUSULA PRIMEIRA: O Prazo da locação é de 12 meses, iniciando-se em "+dataInicioLocacao+", com término em "+dataTerminoLocacao+", independentemente de aviso ou interpelação judicial ou mesmo extrajudicial.\n\n" + 
			"CLÁUSULA SEGUNDA: O aluguel mensal, deverá ser pago até o dia "+diaPagamentoAluguel+" do mês, subsequente e seu valor é de R$"+valorAluguel+" mensais reajustados anualmente em conformidade com a variação IGP-M. Sendo que no primeiro mês de aluguel o locatário deverá efetuar um depósito de um mês de aluguel antecipado.\n\n" + 
			"CLÁUSULA TERCEIRA: O locatário será responsável por todos os incidentes que venham a ocorrer com o imóvel que foi alugado a partir de sua data de locação.\n\n" + 
			"CLÁUSULA QUARTA: O locatário será responsável por todas as despesas provenientes de sua utilização sejam elas: ligação ou consumo de luz, água e gás que serão pagas diretamente para as empresas fornecedoras dos referidos serviços.\n\n" + 
			"CLÁUSULA QUINTA: Em caso de atraso no pagamento do aluguel, será aplicado uma multa de 2% (dois por centro) do montante devido.\n\n" + 
			"CLÁUSULA SEXTA: Fica ao locatário a responsabilidade em zelar pela conservação e limpeza do imóvel, efetuando as reformas necessárias para sua manutenção sendo que todos os gastos e pagamentos ocorrerão por conta do mesmo.\n\n" + 
			"CLÁUSULA SÉTIMA: O locatário fica obrigado a devolver o imóvel em perfeita condição de limpeza e conservação inclusive da pintura das paredes quando o mesmo deixar o imóvel.\n\n" + 
			"CLÁUSULA OITAVA: O locatário não poderá modificar a estrutura do imóvel alugado sem a prévia autorização por escrito do locador. No caso de realização de alguma obra, estas serão incorporadas ao imóvel sem que tenha o locatário qualquer indenização pelas obras realizadas.\n\n" + 
			"CLÁUSULA NONA: O locatário declara receber o imóvel em perfeito estado de conservação e funcionamento observado isso no dia em que o imóvel foi alugado.\n\n" + 
			"CLÁUSULA DÉCIMA: O locatário declara que o imóvel alugado, será exclusivamente para uso residencial e de sua família.\n\n" + 
			"CLÁUSULA DÉCIMA PRIMEIRA: O locatário não poderá em hipótese alguma sublocar, transferir ou ceder o imóvel para terceiros, sem o consentimento prévio e por escrito do locador.\n\n" + 
			"CLÁUSULA DÉCIMA SEGUNDA: O locatário é o principal pagador responsável por todos os pagamentos descritos nesse contrato até a efetiva entrega da chave ao locador e o termo da vistoria do imóvel.\n\n" + 
			"CLÁUSULA DÉCIMA TERCEIRA: O locador tem o direito de vistoriar seus inquilinos sempre que achar conveniente para assegurar o cumprimento das obrigações assumidas neste contrato.\n\n" + 
			"CLÁUSULA DÉCIMA QUARTA: A infração de qualquer das cláusulas do presente contrato, sujeita o infrator a multa 02 vezes ao valor do aluguel tornando por base o ultimo aluguel vencido.\n\n" + 
			"E, por assim estarem justos e contratados, mandaram extrair o presente instrumento em duas(02) vias, para que seja confirmado a aceitação de todos os termos mencionados neste contrato, serão assinados no indicador de locador e locatário.\n\n" + 
			" \r\n" + 
			"\r\n" + 
			"\r\n" + 
			" \r\n" + 
			"___________________________\r\n" + 
			"LOCADOR \r\n" + 
			"\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"___________________________\r\n" + 
			"LOCATÁRIO \r\n" + 
			" \r\n" + 
			"\r\n" + 
			"";
	return textoContrato;
	}
	
}
