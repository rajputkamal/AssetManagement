package com.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AssetModel;
import com.dto.Asset;
import com.dto.Employee;

@WebServlet("/assignAssetToEmployee")
public class AssignAssetToEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		AssetModel am = new AssetModel();
		Asset ast = am.getAsset(name);
		ArrayList<Employee> listEmp = am.getEmployeeNames();

		RequestDispatcher rd = null;
		if (ast != null && listEmp != null) {
			rd = request.getRequestDispatcher("assignAsset.jsp");
			request.setAttribute("AST", ast);
			request.setAttribute("LIST_EMP", listEmp);
			rd.forward(request, response);
		} else {
			rd = request.getRequestDispatcher("assignAsset.jsp");
			// request.setAttribute("AST", ast);
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
