package example.com.daizy.findgithubuser.model;

import java.io.IOException;

import example.com.daizy.findgithubuser.api.GitHubService;
import example.com.daizy.findgithubuser.bean.User;
import example.com.daizy.findgithubuser.net.ServiceGenerator;
import example.com.daizy.findgithubuser.viewmodle.MainViewModel;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by daizy on 2017/4/14.
 */

public class GitHubModel {
    private GitHubService git;
    private MainViewModel viewModel;

    public GitHubModel(MainViewModel viewModel) {
        this.viewModel = viewModel;
        this.git = ServiceGenerator.createService(GitHubService.class);
    }

    public void getUser(final String username){

        System.out.println("getUser -- userName = " + username);
        Call call = git.getUser(username);
        call.enqueue(new Callback<User>() {

            @Override
            public void onResponse(Response<User> response) {
                User user = response.body();

                if (user == null){
                    ResponseBody errorBody = response.errorBody();

                    if (errorBody == null){
                        viewModel.setText("responseBody is null !!");
                    }else {
                        try {
                            viewModel.setText("responseBody is " + errorBody.string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }else {
                    viewModel.setText("GitName = " + user.getName() + "\nWebSite = " + user.getBlog());
                }

                viewModel.setPb(false);
            }

            @Override
            public void onFailure(Throwable t) {
                viewModel.setText(t.getMessage());
                viewModel.setPb(false);
            }
        });
    }
}
