package com.big.o.listeners;

import com.big.o.api.tools.Result;
import com.big.o.api.tools.TestrailRestClient;
import com.big.o.api.tools.TmsId;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class TestrailResultListener implements ISuiteListener, ITestListener {

    private TestrailRestClient client = new TestrailRestClient();
    private Map<String, String> tests;

    private long start;
    private long end;

    @Override
    public void onStart(ISuite suite) {
        tests = execute(client.results.getTests("4")).body()
                .tests
                .stream()
                .collect(Collectors.toMap(t -> t.case_id, t -> t.id));
        start = System.currentTimeMillis();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("WRITE RESULTS");
        var caseId = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(TmsId.class).id();
        var res = new Result(parseInt(caseId), 1, "written by auto test");
        execute(client.results.addResult(tests.get(caseId), res));
    }

    @Override
    public void onFinish(ISuite suite) {
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
