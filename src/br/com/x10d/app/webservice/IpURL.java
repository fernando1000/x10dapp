package br.com.x10d.app.webservice;

public enum IpURL {

	//local DATASUL
	URL_SERVER_REST("http://172.16.3.94:82/cgi-bin/cgiip.exe/WService=ContaSIM"),
	NOME_DO_PACOTE("mobile.contasim.model.");
			
	private String valor;
	
	private IpURL(String valor){
		this.valor = valor;
	}
	public String getValor(){
		return valor;
	}
}
