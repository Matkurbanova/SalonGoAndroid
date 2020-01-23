package kg.salongo.android.api.services;

import kg.salongo.android.api.ApiResponse;
import kg.salongo.android.models.GoUser;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UserService {
    @GET("api/login")
    Call<ApiResponse<GoUser>> login(@Query("login") String login, @Query("password") String password);
}
