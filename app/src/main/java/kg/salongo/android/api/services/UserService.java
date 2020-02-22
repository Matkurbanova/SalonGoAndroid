package kg.salongo.android.api.services;

import kg.salongo.android.api.ApiResponse;
import kg.salongo.android.models.GoUser;
import kg.salongo.android.models.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UserService {
    @GET("api/login")
    Call<ApiResponse<GoUser>> login(
//           @Header("token") String token,
            @Query("login") String login, @Query("password") String password);

    @POST("api/register/personal")
    Call<ApiResponse<User>> registerPersonal(
            @Query("login") String login,
            @Query("password") String password,
            @Query("phone") String phone,
            @Query("name") String name);


}

