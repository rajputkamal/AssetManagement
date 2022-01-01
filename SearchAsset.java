package com.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AssetModel;
import com.dto.Asset;

@WebServlet("/searchAsset")
public class SearchAsset extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		AssetModel am = new AssetModel();
		Asset ast = am.getAsset(name);
		RequestDispatcher rd = null;
		if (ast != null) {
			rd = request.getRequestDispatcher("adminHome.jsp");
			request.setAttribute("AST", ast);
			request.setAttribute("msg", "Record Found");
			rd.forward(request, response);
		}else {
			rd = request.getRequestDispatcher("adminHome.jsp");
			request.setAttribute("msg", "Record Not Found");
			rd.forward(request, response);
		}
	}

}
