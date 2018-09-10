package in.muheeb.mvvm_databinding.model.network.retrofit;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import in.muheeb.mvvm_databinding.utils.UrlUtils;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseService
{
    protected Retrofit retrofit;



    public BaseService()
    {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        // comment when going for Live
        httpClient.addInterceptor(httpLoggingInterceptor);

        retrofit = new Retrofit.Builder()
                .baseUrl(UrlUtils.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient.build())
                .build();
    }
}
