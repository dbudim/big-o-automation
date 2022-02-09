package com.big.o.listeners;

import com.big.o.api.tools.Result;
import com.big.o.api.tools.Results;
import com.big.o.api.tools.TestrailRestClient;
import com.big.o.api.tools.TmsId;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class TestrailResultBulkListener implements ISuiteListener, ITestListener {

    private TestrailRestClient client = new TestrailRestClient();
    private Map<String, String> tests;
    private List<Result> results = Collections.synchronizedList(new ArrayList<>());

    private long start;
    private long end;

    @Override
    public void onStart(ISuite suite) {
        start = System.currentTimeMillis();
        tests = execute(client.results.getTests("4")).body()
                .tests
                .stream()
                .collect(Collectors.toMap(t -> t.case_id, t -> t.id));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String caseId = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(TmsId.class).id();
        String testId = tests.get(caseId);
        var res = new Result(parseInt(caseId), parseInt(testId), 1, "bulk added result");
        results.add(res);
    }

    @Override
    public void onFinish(ISuite suite) {
        execute(client.results.addResults(4, new Results(results)));
        end = System.currentTimeMillis();
        System.out.println("SUITE TIME: " + (end - start));
    }

    private <T> Response<T> execute(Call<T> request) {
        try {
            return request.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
