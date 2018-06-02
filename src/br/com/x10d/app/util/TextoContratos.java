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
			"IMOVEL CONTRATADO: Uma casa com "+comodosDaCasa+", situado na rua "+ruaNumeroCasa+", Parque Boa Esperan�a, 06653-590, Itapevi SP.\n\n" + 
			"LOCADOR: Quit�ria Pereira Neves, Brasileira, Casada , portadora da c�dula de identidade RG: 36.841.743-8 e CPF: 882.476.434-72\n\n" + 
			"LOCAT�RIO: "+nomeCompleto+", RG"+rg+", CPF"+cpf+"\n\n" + 
			"CL�USULA PRIMEIRA: O Prazo da loca��o � de 12 meses, iniciando-se em "+dataInicioLocacao+", com t�rmino em "+dataTerminoLocacao+", independentemente de aviso ou interpela��o judicial ou mesmo extrajudicial.\n\n" + 
			"CL�USULA SEGUNDA: O aluguel mensal, dever� ser pago at� o dia "+diaPagamentoAluguel+" do m�s, subsequente e seu valor � de R$"+valorAluguel+" mensais reajustados anualmente em conformidade com a varia��o IGP-M. Sendo que no primeiro m�s de aluguel o locat�rio dever� efetuar um dep�sito de um m�s de aluguel antecipado.\n\n" + 
			"CL�USULA TERCEIRA: O locat�rio ser� respons�vel por todos os incidentes que venham a ocorrer com o im�vel que foi alugado a partir de sua data de loca��o.\n\n" + 
			"CL�USULA QUARTA: O locat�rio ser� respons�vel por todas as despesas provenientes de sua utiliza��o sejam elas: liga��o ou consumo de luz, �gua e g�s que ser�o pagas diretamente para as empresas fornecedoras dos referidos servi�os.\n\n" + 
			"CL�USULA QUINTA: Em caso de atraso no pagamento do aluguel, ser� aplicado uma multa de 2% (dois por centro) do montante devido.\n\n" + 
			"CL�USULA SEXTA: Fica ao locat�rio a responsabilidade em zelar pela conserva��o e limpeza do im�vel, efetuando as reformas necess�rias para sua manuten��o sendo que todos os gastos e pagamentos ocorrer�o por conta do mesmo.\n\n" + 
			"CL�USULA S�TIMA: O locat�rio fica obrigado a devolver o im�vel em perfeita condi��o de limpeza e conserva��o inclusive da pintura das paredes quando o mesmo deixar o im�vel.\n\n" + 
			"CL�USULA OITAVA: O locat�rio n�o poder� modificar a estrutura do im�vel alugado sem a pr�via autoriza��o por escrito do locador. No caso de realiza��o de alguma obra, estas ser�o incorporadas ao im�vel sem que tenha o locat�rio qualquer indeniza��o pelas obras realizadas.\n\n" + 
			"CL�USULA NONA: O locat�rio declara receber o im�vel em perfeito estado de conserva��o e funcionamento observado isso no dia em que o im�vel foi alugado.\n\n" + 
			"CL�USULA D�CIMA: O locat�rio declara que o im�vel alugado, ser� exclusivamente para uso residencial e de sua fam�lia.\n\n" + 
			"CL�USULA D�CIMA PRIMEIRA: O locat�rio n�o poder� em hip�tese alguma sublocar, transferir ou ceder o im�vel para terceiros, sem o consentimento pr�vio e por escrito do locador.\n\n" + 
			"CL�USULA D�CIMA SEGUNDA: O locat�rio � o principal pagador respons�vel por todos os pagamentos descritos nesse contrato at� a efetiva entrega da chave ao locador e o termo da vistoria do im�vel.\n\n" + 
			"CL�USULA D�CIMA TERCEIRA: O locador tem o direito de vistoriar seus inquilinos sempre que achar conveniente para assegurar o cumprimento das obriga��es assumidas neste contrato.\n\n" + 
			"CL�USULA D�CIMA QUARTA: A infra��o de qualquer das cl�usulas do presente contrato, sujeita o infrator a multa 02 vezes ao valor do aluguel tornando por base o ultimo aluguel vencido.\n\n" + 
			"E, por assim estarem justos e contratados, mandaram extrair o presente instrumento em duas(02) vias, para que seja confirmado a aceita��o de todos os termos mencionados neste contrato, ser�o assinados no indicador de locador e locat�rio.\n\n" + 
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
			"LOCAT�RIO \r\n" + 
			" \r\n" + 
			"\r\n" + 
			"";
	return textoContrato;
	}
	
}
