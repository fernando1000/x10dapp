package br.com.x10d.app.webservice;

import org.json.JSONObject;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import android.app.ProgressDialog;
import android.content.Context;
import br.com.x10d.app.model.Usuario;

public class AutenticacaoWS {
	
	private static final String RESOURCE_AUTENTICACAO_LOGIN = "/web/csp/wescs0402";
	private Context context;
	private Usuario usuarioEnviadoWS;
	private RequestQueue requestQueue;

	public AutenticacaoWS(Context _context){
		
		context = _context;		
		requestQueue = VolleySingleton.getInstanciaDoVolleySingleton(_context).getRequestQueue();
	}

	public void buscaUsuarioWS(String usuario, String senha) {
	    
	    final ProgressDialog progressDialog = MeuProgressDialog.criaProgressDialog(context, "Autenticando Usuário");

		String url = IpURL.URL_SERVER_REST.getValor() + RESOURCE_AUTENTICACAO_LOGIN;
		
	    usuarioEnviadoWS = new Usuario();	
		usuarioEnviadoWS.setUsuario(usuario);
		usuarioEnviadoWS.setSenha(senha);

		MontaJSONObjectGenerico montaJSONObjectGenerico = new MontaJSONObjectGenerico();
		
		JsonObjectRequest jsonObjRequest = new JsonObjectRequest(

				Request.Method.POST, 
				url, 
				montaJSONObjectGenerico.montaJSONObject(usuarioEnviadoWS),

				new Response.Listener<JSONObject>() {
					@Override
					public void onResponse(JSONObject jSONObjectResposta) {
	
						MeuProgressDialog.encerraProgressDialog(progressDialog);

					}
				}, 
				new Response.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError volleyError) {
						
						MeuProgressDialog.encerraProgressDialog(progressDialog);

						new VolleyErro().trataErroQueSeraMostratoParaUsuario(volleyError, context);
					}
				});

		jsonObjRequest.setRetryPolicy(VolleyTimeout.devolveTimeout());

		requestQueue.add(jsonObjRequest);		
	}

	/*
	private void abreDashboard() {
		
		context.startActivity(new Intent(context, ActivityDashboard.class));
		((ActivityLogin) context).finish();
	}
	*/
}
