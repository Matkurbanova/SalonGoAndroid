package kg.salongo.android.api.services;

import java.util.List;

import kg.salongo.android.api.ApiResponse;
import kg.salongo.android.models.GoAddServise;
import kg.salongo.android.models.MasterMoreService;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface MasterService {
    @GET("/api/servicemaster/{SubCategoryId}")
    Call<ApiResponse<List<kg.salongo.android.Data.MasterService>>> getMasterServices(@Path("SubCategoryId") int MasterServId);

    @GET("/api/servicemaster/mastercategories/{masterId}")
    Call<ApiResponse<List<MasterMoreService>>> getMasterMoreService (@Path("masterId")int masterId);

}
