package in.muheeb.mvvm_databinding.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import java.util.List;

import in.muheeb.mvvm_databinding.model.User;
import in.muheeb.mvvm_databinding.model.network.Repository;

public class UserViewModel extends ViewModel
{
    private MutableLiveData<User> userObservable = new MutableLiveData<>();
    public static final String TAG = UserViewModel.class.getName();

    public UserViewModel() {
    }

    //Returns LiveData object to the View to observe
    public LiveData<User> getUserObservable() {
        return userObservable;
    }

    //Fetches User info.
    //Called on button click
    public void getUsers()
    {
        Repository.getInstance().getUserList(this);
    }

    public void setUserObservable(User user)
    {
        //Setting value to ViewModel object which is being observed by MainActivity
        userObservable.setValue(user);
    }
}
