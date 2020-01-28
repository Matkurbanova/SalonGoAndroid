package kg.salongo.android.api.services;

import java.util.List;

import kg.salongo.android.Data.Category;
import kg.salongo.android.api.ApiResponse;
import kg.salongo.android.models.GoCategory;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CategoryService {
    @GET("/api/category")
Call<List<Category>>getCategory();

    @GET("/api/category/{id}")
    Call<List<Category>>getCategoryById(@Path("id")int id);
}
