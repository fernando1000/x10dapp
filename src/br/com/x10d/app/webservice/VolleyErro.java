package br.com.x10d.app.webservice;

import com.android.volley.VolleyError;
import android.content.Context;

public class VolleyErro {

	public void trataErroQueSeraMostratoParaUsuario(VolleyError volleyError, Context context){
		
		if(volleyError.toString().contains("refused") ){
			
			new MeuAlerta("Erro V", "Servlet Container não está acessível", context).meuAlertaOk();	
		}
		else if(volleyError.toString().contains("HTML") ){
			
			new MeuAlerta("Erro V", "WebSpeed não está acessível", context).meuAlertaOk();	
		}
		else if(volleyError.toString().contains("unreachable") ){
			
			new MeuAlerta("Erro V", "Sem acesso a internet", context).meuAlertaOk();	
		}
		else{
			new MeuAlerta("Erro V", ""+volleyError, context).meuAlertaOk();			
		}
	}

}
