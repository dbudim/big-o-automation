package com.big.o.api.tools;

import java.util.List;

/**
 * Created by dbudim on 18.12.2021
 */

public class DeleteCasesWrap {

    public Integer suite_id;
    public List<Integer> case_ids;

    public DeleteCasesWrap() {
    }

    public DeleteCasesWrap(List<Integer> case_ids, Integer suite_id) {
        this.case_ids = case_ids;
        this.suite_id = suite_id;
    }
}
