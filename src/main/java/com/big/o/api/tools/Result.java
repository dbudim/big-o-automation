package com.big.o.api.tools;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Objects;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

public class Result {

    public Integer status_id;
    public Integer test_id;
    public Integer case_id;
    public transient Integer run_id;
    public String comment;
    public String defects;
    public String custom_allure;

    public Result() {
    }

    public Result(int case_id, int status_id, String comment) {
        this.case_id = case_id;
        this.status_id = status_id;
        this.comment = comment;
    }

    public Result(int case_id, int test_id, int status_id, String comment) {
        this.test_id = test_id;
        this.case_id = case_id;
        this.status_id = status_id;
        this.comment = comment;
    }

    public class Builder {

        private Result result = new Result();

        public Builder statusId(Integer statusId) {
            result.status_id = statusId;
            return this;
        }

        public Builder testId(Integer testId) {
            result.test_id = testId;
            return this;
        }

        public Builder comment(String comment) {
            result.comment = comment;
            return this;
        }

        public Builder caseId(Integer caseId) {
            result.case_id = caseId;
            return this;
        }

        public Builder runId(Integer runId) {
            result.run_id = runId;
            return this;
        }

        public Builder allureLink(String allureLink) {
            result.custom_allure = allureLink;
            return this;
        }

        public Result build() {
            return result;
        }
    }


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, JSON_STYLE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return test_id == result.test_id && case_id == result.case_id && run_id == result.run_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(test_id, case_id, run_id);
    }
}
