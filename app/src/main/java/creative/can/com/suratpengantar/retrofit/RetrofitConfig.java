package creative.can.com.suratpengantar.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by cia on 12/12/2017.
 */

public class RetrofitConfig {

    private static final String base_url= "http://desaliterasi.can.web.id/api/";
    //private static final String base_url= "http://192.168.43.65/api/";
    //private static final String base_url= "http://192.168.100.44/api/";

    public static Retrofit getRetrofit() {


        Gson gson = new GsonBuilder()
                .setLenient()
                .create();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit;

    }
}
