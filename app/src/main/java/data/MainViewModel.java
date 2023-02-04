package data;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import ui.MainActivity;

public class MainViewModel extends ViewModel {
    public MutableLiveData<String> editString = new MutableLiveData<>();

    //public MutableLiveData<Boolean> click = new MutableLiveData<>(false);
    public MutableLiveData<Boolean> isSelected = new MutableLiveData<>();
    public MutableLiveData<String> iButton = new MutableLiveData<>();

    //public void observe(MainActivity, Observer<Boolean>){


}