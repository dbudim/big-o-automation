package com.big.o.api.tools;

import jdk.jfr.ContentType;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.*;

import java.util.List;

/**
 * Created by dbudim on 18.12.2021
 */

public interface CaseService {

    @POST("add_case/{section_id}")
    Call<TestCase> addCase(@Path("section_id") Integer sectionId, @Body Case testCase);

    @GET("get_cases/{project_id}&suite_id={suite_id}")
    Call<CasesResp> getCases(@Path("project_id") Integer project_id, @Path("suite_id") Integer suite_id);

    @POST("delete_case/{case_id}")
    Call<ResponseBody> deleteCase(@Path("case_id") Integer case_id);

    @POST("delete_cases/{suite_id}")
    Call<ResponseBody> deleteCases(@Path("suite_id") Integer suite_id, @Body DeleteCasesWrap deleteCasesWrap);

}
