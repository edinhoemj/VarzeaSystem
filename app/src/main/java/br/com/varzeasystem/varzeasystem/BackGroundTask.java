package br.com.varzeasystem.varzeasystem;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by edinho on 31/08/2016.
 */
public class BackGroundTask extends AsyncTask<String, String, Object> {

    private String usuario;
    private String senha;
    private Context context;

    public BackGroundTask(String user, String pass) {
         usuario = user;
         senha = pass;
    }

    @Override
    protected String doInBackground(String... params) {

        JSONObject login = new JSONObject();

        try {
            login.put("email", usuario);
            login.put("senha", senha);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        String json = login.toString();

        WebClient requisicao = new WebClient();
        String resposta = requisicao.post(json);

        return resposta;
    }


    protected void onPostExecute(String resposta) {

        Toast.makeText(context, resposta, Toast.LENGTH_LONG).show();
    }
}
