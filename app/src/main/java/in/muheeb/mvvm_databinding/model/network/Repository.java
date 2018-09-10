package in.muheeb.mvvm_databinding.model.network;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import java.util.List;

import in.muheeb.mvvm_databinding.model.User;
import in.muheeb.mvvm_databinding.model.network.retrofit.ApiClient;
import in.muheeb.mvvm_databinding.model.network.retrofit.BaseService;
import in.muheeb.mvvm_databinding.viewmodel.UserViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository extends BaseService
{
    private ApiClient apiClient;
    public static final String TAG = Repository.class.getName();
    User user;

    public static Repository getInstance()
    {
        return new Repository();
    }

    public void getUserList(final UserViewModel userViewModel)
    {
        apiClient = retrofit.create(ApiClient.class);
        apiClient.getUserList().enqueue(new Callback<User>()
        {
            @Override
            public void onResponse(Call<User> call, Response<User> response)
            {
                if (response.body() != null)
                    user = response.body();

                    //Setting User object to view-model class to be assigned to ViewModel object
                    userViewModel.setUserObservable(user);

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) 
            {
                Log.i(TAG, "onFailure: In response");
            }
        });
    }
}
