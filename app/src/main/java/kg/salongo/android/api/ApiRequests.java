package kg.salongo.android.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.util.Collection;
import java.util.List;

import kg.salongo.android.Data.Category;
import kg.salongo.android.Data.MasterService;
import kg.salongo.android.Data.Promo;
import kg.salongo.android.Data.Service;
import kg.salongo.android.Data.SubCategory;
import kg.salongo.android.api.services.CategoryService;
import kg.salongo.android.api.services.UserService;
import kg.salongo.android.models.GoAddServise;
import kg.salongo.android.models.GoUser;
import kg.salongo.android.models.User;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiRequests {

    public static final String BASE_URL = "http://192.168.0.108:8080";
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

    public static void getCategories(Callback<ApiResponse<List<Category>>> callback) {
        CategoryService categoryService = retrofit.create(CategoryService.class);
        categoryService.getCategories().enqueue(callback);
    }

    public static void getSubCategories(int id, Callback<ApiResponse<List<SubCategory>>> callback) {
        CategoryService categoryService = retrofit.create(CategoryService.class);
        categoryService.getSubCategories(id).enqueue(callback);
    }

    public static void getMasterServices(int SubCategoryId, Callback<ApiResponse<List<MasterService>>> callback) {
        kg.salongo.android.api.services.MasterService masterService = retrofit.create(kg.salongo.android.api.services.MasterService.class);
        masterService.getMasterServices(SubCategoryId).enqueue(callback);
    }

    public static void getSalonService(int SubCategoryId, Callback<ApiResponse<List<Service>>> callback) {
        CategoryService categoryService = retrofit.create(CategoryService.class);
        categoryService.getSalonServices(SubCategoryId).enqueue(callback);
    }

    public static void getPromo(Callback<ApiResponse<List<Promo>>> callback) {
        CategoryService categoryService = retrofit.create(CategoryService.class);
        categoryService.getPromo().enqueue(callback);

    }

    public static void registerPersonal(
            String login,
            String password,
            String phone,
            String name,
            Callback<ApiResponse<User>> callback) {
        UserService userService = retrofit.create(UserService.class);
        userService.registerPersonal(login, password, phone, name).enqueue(callback);
    }

    public static void registerMaster(
            String login,
            String name,
            String password,
            String phone,
            String workExperienceYear,
            File imag,
            Callback<ApiResponse<User>> callback) {
        UserService userService = retrofit.create(UserService.class);
        RequestBody requestFile =
                RequestBody.create(MediaType.parse("multipart/form-data"), imag);
        MultipartBody.Part body =
                MultipartBody.Part.createFormData("image", imag.getName(), requestFile);
        userService.registerMaster(login, name, password, phone, workExperienceYear, body).enqueue(callback);
    }


    public static void addService(
            String token,
            String Price,
            String Description,
            int subCategoryId,
            String Image,
            Callback<ApiResponse<GoAddServise>> callback) {
        CategoryService categoryService = retrofit.create(CategoryService.class);
        categoryService.addService(token, Price, Description, subCategoryId, Image).enqueue(callback);

    }
}
