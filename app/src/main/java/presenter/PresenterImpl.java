package presenter;

import java.util.List;

import bean.ResultsBean;
import model.ModelImpl;
import view.ICallback;
import view.IView;

public class PresenterImpl implements IPresenter{
    private final ModelImpl model;
    IView view;

    public PresenterImpl(IView view) {
        this.view = view;
        model = new ModelImpl();
    }

    @Override
    public void updataData() {
        model.updataData(new ICallback() {
            @Override
            public void updataSuccess(List<ResultsBean> resultsBeans) {
                view.updataSuccess(resultsBeans);
            }

            @Override
            public void updataError(String error) {
                view.updataError(error);
            }
        });
    }
}
