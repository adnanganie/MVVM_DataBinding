package in.muheeb.mvvm_databinding.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import in.muheeb.mvvm_databinding.R;
import in.muheeb.mvvm_databinding.databinding.ActivityMainBinding;
import in.muheeb.mvvm_databinding.model.User;
import in.muheeb.mvvm_databinding.model.network.Repository;
import in.muheeb.mvvm_databinding.viewmodel.UserViewModel;

public class MainActivity extends AppCompatActivity
{
    public static final String TAG = MainActivity.class.getName();
    private Button btn;
    private TextView tv;
    UserViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //Binding activity to the layout
        final ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //Subscribing to view-model
        viewModel = ViewModelProviders.of(this).get(UserViewModel.class);

        //Observing the data-class using UserViewModel reference
        viewModel.getUserObservable().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User users)
            {
                //Setting User object for data-binding
                binding.setUser(users);
            }
        });

        //Setting OnClickListener object using Lambda expressions
        binding.setListener( (view) -> {
            viewModel.getUsers();
        });


    }
}
