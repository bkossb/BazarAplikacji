package com.bartek.servlet;

import com.bartek.domain.App;
import org.apache.lucene.search.Query;
import org.hibernate.Session;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import com.bartek.util.StartupDataLoader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("search")
public class SearchServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher(
                "/WEB-INF/pages/search.jsp").forward(request, response);


        Session session = StartupDataLoader.openSession();
        FullTextSession fullTextSession = Search.getFullTextSession(session);
        fullTextSession.beginTransaction();

        String searchString = request.getParameter("searchString");

        QueryBuilder queryBuilder = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(App.class).get();

        Query luceneQuery = queryBuilder
                .keyword()
                .onFields("name", "description")
                .matching(searchString)
                .createQuery();

        org.hibernate.Query hibernateQuery = fullTextSession.createFullTextQuery(luceneQuery, App.class);
        List<App> apps = hibernateQuery.list();
        request.setAttribute("apps", apps);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
