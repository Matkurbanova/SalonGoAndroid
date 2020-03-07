package kg.salongo.android.api.services;

import java.util.List;

import kg.salongo.android.Data.Category;
import kg.salongo.android.Data.MasterService;
import kg.salongo.android.Data.Promo;
import kg.salongo.android.Data.Service;
import kg.salongo.android.Data.SubCategory;
import kg.salongo.android.api.ApiResponse;
import kg.salongo.android.models.GoAddServise;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CategoryService {
    @GET("/api/category")
    Call<ApiResponse<List<Category>>> getCategories();

    @GET("/api/subcategory/{id}")
    Call<ApiResponse<List<SubCategory>>> getSubCategories(@Path("id") int subCatId);

//    @GET("/api/servicemaster/{SubCategoryId}")
//    Call<ApiResponse<List<MasterService>>> getMasterServices(@Path("SubCategoryId") int MasterServId);

    @GET("/api/servicesalon/{SubCategoryId}")
    Call<ApiResponse<List<Service>>> getSalonServices(@Path("SubCategoryId") int SalonServId);
    @GET("/api/promo")
    Call<ApiResponse<List<Promo>>>getPromo();

    @POST("/api/servicemaster/add")
    Call<ApiResponse<GoAddServise>> addService(
            @Query("token") String token,
            @Query("Price") String Price,
            @Query("Description") String Description,
            @Query("SubCategoryId") int subCategoryId,
            @Query("Image") String Image
    );

}
