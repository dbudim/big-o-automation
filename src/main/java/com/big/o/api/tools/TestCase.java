package com.big.o.api.tools;

import java.util.Objects;

public class TestCase {

    public Integer id;
    public Integer case_id;
    public Integer status_id;
    public int run_id;
    public Integer custom_automated;
    public Boolean custom_live;
    public int type_id;
    public Integer suite_id;

    public Integer getCaseId() {
        return case_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestCase testCase = (TestCase) o;
        return Objects.equals(id, testCase.id) &&
                Objects.equals(case_id, testCase.case_id) &&
                Objects.equals(status_id, testCase.status_id) &&
                Objects.equals(run_id, testCase.run_id) &&
                Objects.equals(custom_automated, testCase.custom_automated) &&
                Objects.equals(custom_live, testCase.custom_live);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, case_id, status_id, run_id, custom_automated, custom_live);
    }
}
