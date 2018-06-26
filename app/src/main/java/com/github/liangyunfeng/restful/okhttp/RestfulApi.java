package com.github.liangyunfeng.restful.okhttp;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import com.github.liangyunfeng.restful.bean.Animal;
import com.github.liangyunfeng.restful.bean.Zoo;


/**
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
public class RestfulApi {

	private OkHttpClient client = new OkHttpClient();

	/**
	 * GET /zoos：列出所有动物园
	 *
	 * @return 返回资源对象的列表（数组）
	 */
	public List<Zoo> testGetAll() throws Exception {
		Request request = new Request.Builder()
				.url("https://api.example.com/zoos")
				.get()
				.addHeader("Accept", "vnd.example-com.foo+json; version=1.0")
				.build();

		Response response = client.newCall(request).execute();
		if (!response.isSuccessful())
			throw new IOException("Unexpected code " + response);

		//System.out.println(response.body().string());
		Gson gson = new Gson();
		//gson.fromJson(response.body().string(), List.class);
		List<Zoo> list = gson.fromJson(response.body().string(), new TypeToken<List<Zoo>>(){}.getType());
		return list;
	}

	/**
	 * POST /zoos：新建一个动物园
	 *
	 * @return 返回新生成的资源对象
	 */
	public Zoo testCreate() throws Exception {
		RequestBody formBody = new FormBody.Builder()
				.add("id", "1001")
				.add("name", "Jurassic Park")
				.add("address", "Scient City, Guangzhou, China")
				.build();

		Request request = new Request.Builder()
				.url("https://api.example.com/zoos")
				.post(formBody)
				.addHeader("Accept", "vnd.example-com.foo+json; version=1.0")
				.build();

		Response response = client.newCall(request).execute();
		if (!response.isSuccessful())
			throw new IOException("Unexpected code " + response);

		Gson gson = new Gson();
		Zoo zoo = gson.fromJson(response.body().string(), Zoo.class);
		return zoo;
	}

	/**
	 * GET /zoos/ID：获取某个指定动物园的信息
	 *
	 * @return 返回单个资源对象
	 */
	public Zoo testGetById(int id) throws Exception {
		Request request = new Request.Builder()
				.url("https://api.example.com/zoos/" + id)
				.get()
				.addHeader("Accept", "vnd.example-com.foo+json; version=1.0")
				.build();

		Response response = client.newCall(request).execute();
		if (!response.isSuccessful())
			throw new IOException("Unexpected code " + response);

		Gson gson = new Gson();
		Zoo zoo = gson.fromJson(response.body().string(), Zoo.class);
		return zoo;
	}

	/**
	 * PUT /zoos/ID：更新某个指定动物园的信息（提供该动物园的全部信息）
	 *
	 * @return 返回完整的资源对象
	 */
	public Zoo testPutById(int id) throws Exception {
		RequestBody formBody = new FormBody.Builder()
				.add("id", "" + id)
				.add("name", "Jurassic Park")
				.add("address", "Scient City, Guangzhou, China")
				.build();

		Request request = new Request.Builder()
				.url("https://api.example.com/zoos/" + id)
				.put(formBody)
				.addHeader("Accept", "vnd.example-com.foo+json; version=1.0")
				.build();

		Response response = client.newCall(request).execute();
		if (!response.isSuccessful())
			throw new IOException("Unexpected code " + response);

		Gson gson = new Gson();
		Zoo zoo = gson.fromJson(response.body().string(), Zoo.class);
		return zoo;
	}

	/**
	 * PATCH /zoos/ID：更新某个指定动物园的信息（提供该动物园的部分信息）
	 *
	 * @return 返回完整的资源对象
	 */
	public Zoo testPatchById(int id) throws Exception {
		RequestBody formBody = new FormBody.Builder()
				.add("id", "" + id)
				.add("name", "Jurassic Park")
				.add("address", "Scient City, Guangzhou, China")
				.build();

		Request request = new Request.Builder()
				.url("https://api.example.com/zoos/" + id)
				.patch(formBody)
				.addHeader("Accept", "vnd.example-com.foo+json; version=1.0")
				.build();

		Response response = client.newCall(request).execute();
		if (!response.isSuccessful())
			throw new IOException("Unexpected code " + response);

		Gson gson = new Gson();
		Zoo zoo = gson.fromJson(response.body().string(), Zoo.class);
		return zoo;
	}

	/**
	 * DELETE /zoos/ID：删除某个动物园
	 *
	 * @return 返回一个空文档
	 */
	public Zoo testDeleteById(int id) throws Exception {
		Request request = new Request.Builder()
				.url("https://api.example.com/zoos/" + id)
				.delete()
				.addHeader("Accept", "vnd.example-com.foo+json; version=1.0")
				.build();

		Response response = client.newCall(request).execute();
		if (!response.isSuccessful())
			throw new IOException("Unexpected code " + response);

		Gson gson = new Gson();
		Zoo zoo = gson.fromJson(response.body().string(), Zoo.class);
		return zoo;
	}

	/**
	 * GET /zoos/ID/animals：列出某个指定动物园的所有动物
	 *
	 * @return 返回资源对象的列表（数组）
	 */
	public List<Animal> testGetAllById(int id) throws Exception {
		Request request = new Request.Builder()
				.url("https://api.example.com/zoos/" + id + "/animals")
				.get()
				.addHeader("Accept", "vnd.example-com.foo+json; version=1.0")
				.build();

		Response response = client.newCall(request).execute();
		if (!response.isSuccessful())
			throw new IOException("Unexpected code " + response);

		//System.out.println(response.body().string());
		Gson gson = new Gson();
		//gson.fromJson(response.body().string(), List.class);
		List<Animal> list = gson.fromJson(response.body().string(), new TypeToken<List<Animal>>(){}.getType());
		return list;
	}

	/**
	 * DELETE /zoos/ID/animals/ID：删除某个指定动物园的指定动物
	 *
	 * @return 返回一个空文档
	 */
	public Animal testDeleteById(int zooId, int animalId) throws Exception {
		Request request = new Request.Builder()
				.url("https://api.example.com/zoos/" + zooId + "/animals/" + animalId)
				.delete()
				.addHeader("Accept", "vnd.example-com.foo+json; version=1.0")
				.build();

		Response response = client.newCall(request).execute();
		if (!response.isSuccessful())
			throw new IOException("Unexpected code " + response);

		Gson gson = new Gson();
		Animal animal = gson.fromJson(response.body().string(), Animal.class);
		return animal;
	}
}
