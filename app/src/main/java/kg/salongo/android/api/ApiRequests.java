package kg.salongo.android.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import kg.salongo.android.api.services.UserService;
import kg.salongo.android.models.GoUser;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiRequests {

    public static final String BASE_URL = "http://192.168.0.111:8080";
    public static final String IMAGES = BASE_URL + "/api/image/";

    private static Gson gson = new GsonBuilder().create();
    private static Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(BASE_URL)
            .build();

    public static void login(String login, String password, Callback<ApiResponse<GoUser>> callback) {
        UserService userService = retrofit.create(UserService.class);
        userService.login(login, password).enqueue(callback);
    }
}
