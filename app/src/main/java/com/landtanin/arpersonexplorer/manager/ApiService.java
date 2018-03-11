package com.landtanin.arpersonexplorer.manager;

import com.landtanin.arpersonexplorer.model.BaseModel;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by User on 6/5/2560.
 */

/**
 * Create Retrofit GET Http URL part
 */
public interface ApiService {

    @Multipart
    @POST("hack24/")
    Call<BaseModel> postImage(@Part MultipartBody.Part base);

}
