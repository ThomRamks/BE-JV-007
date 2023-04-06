package ADA.BEJV007.service;

import ADA.BEJV007.domain.Address;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

@Service
public class APIConsumer {


    public Address apiAddress (Address address){
        try{
            URL url = new URL("https://viacep.com.br/ws/" +address.getCep()+"/json/");
            URLConnection connection = url.openConnection();
            InputStream is = connection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String cep = "";
            StringBuilder jsonCep = new StringBuilder();
            while((cep = br.readLine()) != null){
                jsonCep.append(cep);
            }
            address = new Gson().fromJson(jsonCep.toString(), Address.class);
        } catch (IOException ex){
            ex.getMessage();
        }
        return address;
    }
}
