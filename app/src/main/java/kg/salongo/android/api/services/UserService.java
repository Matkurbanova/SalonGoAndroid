package kg.salongo.android.api.services;

import kg.salongo.android.api.ApiResponse;
import kg.salongo.android.models.GoUser;
import kg.salongo.android.models.User;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
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

    @Multipart
    @POST("/api/register/master")
    Call<ApiResponse<User>> registerMaster(
            @Query("login") String login,
            @Query("name") String name,
            @Query("password") String password,
            @Query("phone") String phone,
            @Query("workExperienceYear") String workExperienceYear,
            @Part MultipartBody.Part file);

    @Multipart
    @POST ("/api/register/salon")
    Call<ApiResponse<User>>registerSalon(
            @Query("login") String login,
                    @Query("name") String name,
                    @Query("password") String password,
                    @Query("phone") String phone,
                    @Query("address") String address,

                    @Part MultipartBody.Part file);


}

