package com.tejas.v_authmachinetest.main.roomDb;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.tejas.v_authmachinetest.main.model.Article;

import java.util.List;

@Dao
public interface ArticleDAO {
    @Insert
    public void insert(Article... articles);

    @Update
    public void update(Article... articles);

    @Delete
    public void delete(Article contact);

    @Query("SELECT * FROM article")
    public List<Article> getArticles();

    @Query("DELETE FROM article")
    public void clearTable();

}