package example.com.daizy.findgithubuser;



import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import example.com.daizy.findgithubuser.databinding.ActivityMainBinding;
import example.com.daizy.findgithubuser.model.GitHubModel;
import example.com.daizy.findgithubuser.viewmodle.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainViewModel viewModel;
    private GitHubModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);
        binding.setModel(viewModel = new MainViewModel());
        model = new GitHubModel(viewModel);

        binding.btnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.setPb(true);
                model.getUser(binding.etName.getText().toString());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
