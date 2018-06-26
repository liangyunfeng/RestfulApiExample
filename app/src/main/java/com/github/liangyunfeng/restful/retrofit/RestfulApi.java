package com.github.liangyunfeng.restful.retrofit;

/**
 * Created by yunfeng.l on 2018/6/25.
 */

import com.github.liangyunfeng.restful.bean.Animal;
import com.github.liangyunfeng.restful.bean.Zoo;

import java.util.List;
import java.util.Map;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * base url: https://api.example.com/
 *
 * @request
 * GET /zoos：列出所有动物园
 * POST /zoos：新建一个动物园
 * GET /zoos/ID：获取某个指定动物园的信息
 * PUT /zoos/ID：更新某个指定动物园的信息（提供该动物园的全部信息）
 * PATCH /zoos/ID：更新某个指定动物园的信息（提供该动物园的部分信息）
 * DELETE /zoos/ID：删除某个动物园
 * GET /zoos/ID/animals：列出某个指定动物园的所有动物
 * DELETE /zoos/ID/animals/ID：删除某个指定动物园的指定动物
 *
 * 过滤信息（Filtering）:
 * ?limit=10：指定返回记录的数量
 * ?offset=10：指定返回记录的开始位置。
 * ?page=2&per_page=100：指定第几页，以及每页的记录数。
 * ?sortby=name&order=asc：指定返回结果按照哪个属性排序，以及排序顺序。
 * ?animal_type_id=1：指定筛选条件
 *
 *
 * 返回结果:
 * GET /collection：返回资源对象的列表（数组）
 * GET /collection/resource：返回单个资源对象
 * POST /collection：返回新生成的资源对象
 * PUT /collection/resource：返回完整的资源对象
 * PATCH /collection/resource：返回完整的资源对象
 * DELETE /collection/resource：返回一个空文档
 */
public interface RestfulApi {

    /**
     * GET /zoos：列出所有动物园
     *
     * @return 返回资源对象的列表（数组）
     */
    @Headers({"Content-Type:application/json", "Accept:vnd.example-com.foo+json; version=1.0"})
    @GET("zoos")
    Call<List<Zoo>> getAllZoo();
    //Call<ResponseBody> getAllZoo();

    /**
     * POST /zoos：新建一个动物园
     *
     * @return 返回新生成的资源对象
     */
    @Headers({"Content-Type:application/json", "Accept:vnd.example-com.foo+json; version=1.0"})
    @POST("zoos")
    Call<Zoo> postCreate(@Body RequestBody body);
    //Call<ResponseBody> postCreate(@Body RequestBody body);

    @Headers({"Content-Type:application/json", "Accept:vnd.example-com.foo+json; version=1.0"})
    @POST("zoos")
    @FormUrlEncoded
    Call<Zoo> postCreate(@Field("id") int id, @Field("name") String name, @Field("address") String address);
    //Call<ResponseBody> postCreate(@Field("id") int id, @Field("name") String name, @Field("address") String address);

    @Headers({"Content-Type:application/json", "Accept:vnd.example-com.foo+json; version=1.0"})
    @POST("zoos")
    @FormUrlEncoded
    Call<Zoo> postCreate(@FieldMap Map<String, String> map);
    //Call<ResponseBody> postCreate(@FieldMap Map<String, String> map);

    /**
     * GET /zoos/ID：获取某个指定动物园的信息
     *
     * @return 返回单个资源对象
     */
    @Headers({"Content-Type:application/json", "Accept:vnd.example-com.foo+json; version=1.0"})
    @GET("zoos/{id}")
    Call<Zoo> GetZooById(@Path("id") int id);
    //Call<ResponseBody> GetZooById(@Path("id") int id);

    /**
     * PUT /zoos/ID：更新某个指定动物园的信息（提供该动物园的全部信息）
     *
     * @return 返回完整的资源对象
     */
    @Headers({"Content-Type:application/json", "Accept:vnd.example-com.foo+json; version=1.0"})
    @PUT("zoos/{id}")
    @FormUrlEncoded
    Call<Zoo> putZooById(@Path("id") int id, @FieldMap Map<String, String> map);
    //Call<ResponseBody> putZooById(@Path("id") int id, @FieldMap Map<String, String> map);

    /**
     * PATCH /zoos/ID：更新某个指定动物园的信息（提供该动物园的部分信息）
     *
     * @return 返回完整的资源对象
     */
    @Headers({"Content-Type:application/json", "Accept:vnd.example-com.foo+json; version=1.0"})
    @PATCH("zoos/{id}")
    @FormUrlEncoded
    Call<Zoo> patchZooById(@Path("id") int id, @FieldMap Map<String, String> map);
    //Call<ResponseBody> patchZooById(@Path("id") int id, @FieldMap Map<String, String> map);

    /**
     * DELETE /zoos/ID：删除某个动物园
     *
     * @return 返回一个空文档
     */
    @Headers({"Content-Type:application/json", "Accept:vnd.example-com.foo+json; version=1.0"})
    @DELETE("zoos/{id}")
    Call<Zoo> deleteZooById(@Path("id") int id);
    //Call<ResponseBody> deleteZooById(@Path("id") int id);

    /**
     * GET /zoos/ID/animals：列出某个指定动物园的所有动物
     *
     * @return 返回资源对象的列表（数组）
     */
    @Headers({"Content-Type:application/json", "Accept:vnd.example-com.foo+json; version=1.0"})
    @GET("zoos/{zooId}/animals")
    Call<List<Animal>> getAllAnimalByZooId(@Path("zooId") int zooId);
    //Call<ResponseBody> getAllAnimalByZooId(@Path("zooId") int zooId);

    /**
     * DELETE /zoos/ID/animals/ID：删除某个指定动物园的指定动物
     *
     * @return 返回一个空文档
     */
    @Headers({"Content-Type:application/json", "Accept:vnd.example-com.foo+json; version=1.0"})
    @GET("zoos/{zooId}/animals/{animalId}")
    Call<Animal> deleteAnimalByZooId(@Path("zooId") int zooId, @Path("animalId") int animalId);
    //Call<ResponseBody> deleteAnimalByZooId(@Path("zooId") int zooId, @Path("animalId") int animalId);
}
