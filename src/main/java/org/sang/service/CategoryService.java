package org.sang.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.sang.bean.Category;
import org.sang.bean.Result;
import org.sang.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sang on 2017/12/19.
 */
@Service
@Transactional
public class CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    public Result<Map> getAllCategories(Integer page) {
        Result<Map> result = new Result<>();
        result.setCode("200");
        Map map = new HashMap<>();

        PageHelper.startPage(page, 10);
        List<Category> allCategories = categoryMapper.getAllCategories();
        PageInfo<Category> pageInfo = new PageInfo<>(allCategories);
        map.put("list",allCategories);
        map.put("totalCount",pageInfo.getTotal());
        result.setData(map);
        return result;
    }

    public boolean deleteCategoryByIds(String ids) {
        String[] split = ids.split(",");
        int result = categoryMapper.deleteCategoryByIds(split);
        return result == split.length;
    }

    public int updateCategoryById(Category category) {
        return categoryMapper.updateCategoryById(category);
    }

    public int addCategory(Category category) {
        category.setDate(new Timestamp(System.currentTimeMillis()));
        return categoryMapper.addCategory(category);
    }

    public List<Category> getAllCategories() {
        return categoryMapper.getAllCategories();
    }
}
