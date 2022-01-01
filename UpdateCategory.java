package com.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdminModel;
import com.dto.Category;

@WebServlet("/updateCategory")
public class UpdateCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uid = request.getParameter("uid");
		AdminModel am = new AdminModel();
		Category ct = am.getCategory(uid);
		if (ct != null) {
			RequestDispatcher rd = request.getRequestDispatcher("editCategory.jsp");
			request.setAttribute("CTG", ct);
			rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String name = request.getParameter("name");
		String description = request.getParameter("description");

		Category cat = new Category(uid, name, description);
		AdminModel am = new AdminModel();

		int i = am.updateCategory(cat);
	
		ArrayList<Category> list = am.getAllCategories();
		if (i != 0) {
			RequestDispatcher rd = request.getRequestDispatcher("listCategory.jsp");
			request.setAttribute("LIST", list);
			request.setAttribute("msg", "Category Updated");
			rd.forward(request, response);
		}
	}
}
