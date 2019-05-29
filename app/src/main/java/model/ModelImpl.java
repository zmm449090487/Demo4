package model;

import android.util.Log;

import java.util.List;

import api.ApiService;
import bean.ResultsBean;
import bean.User;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import view.ICallback;

public class ModelImpl implements IModel{
    private static final String TAG = "ModelImpl";
    @Override
    public void updataData(final ICallback callback) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        apiService.getData().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<User>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe: "+d);
                    }

                    @Override
                    public void onNext(User user) {
                        List<ResultsBean> results = user.getResults();
                        callback.updataSuccess(results);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.updataError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: ");
                    }
                });
    }
}
