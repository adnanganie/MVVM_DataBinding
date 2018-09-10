package in.muheeb.mvvm_databinding.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User
{
    @SerializedName("name")
    @Expose
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
