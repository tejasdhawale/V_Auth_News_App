package com.tejas.v_authmachinetest.main.roomDb;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.tejas.v_authmachinetest.main.model.Article;

@Database(entities = {Article.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ArticleDAO getArticleDAO();


}

