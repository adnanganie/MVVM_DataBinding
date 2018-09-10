package in.muheeb.mvvm_databinding.model.network.retrofit;

import java.util.List;

import in.muheeb.mvvm_databinding.model.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface ApiClient
{
    @GET("getUsersForApp.php")
    Call<User> getUserList();
}
