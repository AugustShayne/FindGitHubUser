package example.com.daizy.findgithubuser.viewmodle;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import example.com.daizy.findgithubuser.BR;

/**
 * Created by daizy on 2017/4/14.
 */

public class MainViewModel extends BaseObservable {
    private String text;
    private boolean pb;

    @Bindable
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        notifyPropertyChanged(BR.text);
    }

    @Bindable
    public boolean isPb() {
        return pb;
    }

    public void setPb(boolean pb) {
        this.pb = pb;
        notifyPropertyChanged(BR.pb);
    }
}
