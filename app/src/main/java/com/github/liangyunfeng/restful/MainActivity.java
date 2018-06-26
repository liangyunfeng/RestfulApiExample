package com.github.liangyunfeng.restful;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
