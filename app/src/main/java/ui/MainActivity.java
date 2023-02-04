package ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import algonquin.cst2335.eche0011.databinding.ActivityMainBinding;
import data.MainViewModel;

public class MainActivity extends AppCompatActivity {
    private MainViewModel model;
    private ActivityMainBinding variableBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        model = new ViewModelProvider(this).get(MainViewModel.class);
        variableBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView( variableBinding.getRoot());
        TextView mytext = variableBinding.textview;


        variableBinding.mybutton.setOnClickListener(click ->
        {
            model.editString.postValue(variableBinding.myedittext.getText().toString());
        });
        model.editString.observe(this, s -> {
            variableBinding.textview.setText("Your edit text has "+ s);
        });
        Button btn = variableBinding.mybutton;
        EditText myedit = variableBinding.myedittext;

      String editString = myedit.getText().toString();
      mytext.setText("Your edit text has: " + editString);
      
      model.isSelected.observe(this, selected -> {
          variableBinding.mycheckbox.setChecked(selected);
          variableBinding.myradioButton.setChecked(selected);
          variableBinding.myswitch.setChecked(selected);
          Context context = getApplicationContext();
          CharSequence text = "Your value is:" + variableBinding.myswitch.isChecked();
          int duration = Toast.LENGTH_SHORT;

          Toast toast = Toast.makeText(context, text, duration);
          toast.show();
      });

        variableBinding.mycheckbox.setOnCheckedChangeListener((checkBox , isChecked) -> {
            model.isSelected.postValue(isChecked);
        });

        variableBinding.myradioButton.setOnCheckedChangeListener((radioButton , isChecked) -> {
            model.isSelected.postValue(isChecked);
        });

        variableBinding.myswitch.setOnCheckedChangeListener((switch1 , isChecked) -> {
            model.isSelected.postValue(isChecked);
        });


        variableBinding.imageButton.setOnClickListener(click -> {
            model.iButton.postValue(variableBinding.imageButton.getHeight() + "*" + variableBinding.imageButton.getWidth());
        });

        model.iButton.observe(this, c -> {
            Context context = getApplicationContext();
            CharSequence text = "The value is now: " + variableBinding.imageButton.getHeight() + "*" + variableBinding.imageButton.getWidth();
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
   });



    }
}
