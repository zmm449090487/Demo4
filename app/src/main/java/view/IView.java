package view;

import java.util.List;

import bean.ResultsBean;

public interface IView {
    void updataSuccess(List<ResultsBean> resultsBeans);
    void updataError(String error);
}
