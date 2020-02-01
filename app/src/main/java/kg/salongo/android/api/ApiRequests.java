package kg.salongo.android.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Collection;
import java.util.List;

import kg.salongo.android.Data.Category;
import kg.salongo.android.Data.MasterService;
import kg.salongo.android.Data.Promo;
import kg.salongo.android.Data.Service;
import kg.salongo.android.Data.SubCategory;
import kg.salongo.android.api.services.CategoryService;
import kg.salongo.android.api.services.UserService;
import kg.salongo.android.models.GoUser;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiRequests {

    public static final String BASE_URL = "http://192.168.0.102:8080";
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

    public static void getCategories(Callback<ApiResponse<List<Category>>> callback){
        CategoryService categoryService = retrofit.create(CategoryService.class);
        categoryService.getCategories().enqueue(callback);
    }

    public static void getSubCategories(int id, Callback<ApiResponse<List<SubCategory>>> callback){
        CategoryService categoryService = retrofit.create(CategoryService.class);
        categoryService.getSubCategories(id).enqueue(callback);
    }
    public  static  void getMasterServices(int SubCategoryId, Callback<ApiResponse<List<MasterService>>>callback){
        CategoryService categoryService=retrofit.create(CategoryService.class);
        categoryService.getMasterServices(SubCategoryId).enqueue(callback);
    }
    public static void getSalonService(int SubCategoryId, Callback<ApiResponse<List<Service>>>callback){
        CategoryService categoryService=retrofit.create(CategoryService.class);
        categoryService.getSalonServices(SubCategoryId).enqueue(callback);
    }
    public static void getPromo(Callback<ApiResponse<List<Promo>>>callback){
        CategoryService categoryService=retrofit.create(CategoryService.class);
        categoryService.getPromo().enqueue(callback);

    }
}
