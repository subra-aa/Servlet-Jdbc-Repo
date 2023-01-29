package com.yotam;

import com.yotam.domain.Recipe;
import com.yotam.jdbc.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by yotamm on 28/04/16.
 */
@WebServlet("/users")
public class AllUsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sql = "SELECT * FROM demo.recipes";

        int totalRows;
        List<Recipe> recipeList = new ArrayList<>();
        try {
            Connection connection = JdbcUtils.getConnection();
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int recipeId = resultSet.getInt("recipe_id");
                String recipeName = resultSet.getString("recipe_name");
                Recipe recipe = new Recipe();
                recipe.setRecipeId(recipeId);
                recipe.setRecipeName(recipeName);
                recipeList.add(recipe);
            }
        } catch( Exception ex) {
            ex.printStackTrace();
        }
        //Forward the request to users.jsp to render the list
        req.setAttribute("model", recipeList);
        req.getRequestDispatcher("recipes.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
