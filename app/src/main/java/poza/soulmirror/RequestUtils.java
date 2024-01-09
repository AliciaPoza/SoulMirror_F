package poza.soulmirror;

import org.json.JSONObject;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class RequestUtils {
    public static final String URL_API = "http://192.168.0.28:8080";

    public static void envoyerUtilisateur(String json){
        new Thread( () ->{
            try {
                String url = URL_API +"/utilisateurs";
                RequestUtils.sendPost(url, json);
            } catch (Exception e){
                e.printStackTrace();
            }
        }).start();
    }
    public static void envoyerConnexion (String json, OnVerificationListener listener){
        new Thread ( () ->{
            try{
                String url = URL_API+"/connexion";
                String response = RequestUtils.sendPost(url, json);
                if (response != null && response.equals("Connexion réussie")){
                    listener.onVerificationSuccess();
                } else {
                    listener.onVerificationFailure();
                }
            } catch (Exception e){
                e.printStackTrace();
                listener.onVerificationFailure();
            }
        }).start();
    }
    public interface OnVerificationListener{
        void onVerificationSuccess();
        void onVerificationFailure();
    }
    public static void envoyerSujet(int idUtilisateur, String json) {
        new Thread(() -> {
            try {
                String url = (URL_API+"/sujets");
                JSONObject jsonObject = new JSONObject(json);
                jsonObject.put("idUtilisateur", idUtilisateur);
                String jsonAEnvoyer = jsonObject.toString();
                RequestUtils.sendPost(url, jsonAEnvoyer);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
    public static String sendGet(String url) throws Exception {
        System.out.println("url : " + url);
        OkHttpClient client = new OkHttpClient();

        //Création de la requête
        Request request = new Request.Builder().url(url).build();

        //Le try-with ressource doc ici
        //Nous permet de fermer la réponse en cas de succès ou d'échec (dans le finally)
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            return response.body().string();
        }
    }
    public static String sendPost(String url, String jsonAEnvoyer ) throws Exception {
        System.out.println("url : " + url);
        OkHttpClient client = new OkHttpClient();
        //Corps de la requête
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, jsonAEnvoyer);

        //Création de la requête
        Request request = new Request.Builder().url(url).post(body).build();

        //Le try-with ressource doc ici
        //Nous permet de fermer la réponse en cas de succès ou d'échec (dans le finally)

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            return response.body().string();
        }
    }
}
