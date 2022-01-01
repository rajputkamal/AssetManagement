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

@WebServlet("/assignEmployee")
public class AssignEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		AssetModel am = new AssetModel();
		int i = am.changeAssetStatus(name);
		Asset ast = am.getAsset(name);
		ArrayList<Employee> list = am.getEmployeeNames();
		RequestDispatcher rd = null;
		if (i != 0 && ast != null && list != null) {
			rd = request.getRequestDispatcher("editAsset.jsp");
			rd = request.getRequestDispatcher("assignAsset.jsp");
			request.setAttribute("AST", ast);
			request.setAttribute("LIST_EMP", list);
			request.setAttribute("msg", "Asset Assigned To Employee");
			rd.forward(request, response);
		}else {
			rd = request.getRequestDispatcher("assignAsset.jsp");
			// request.setAttribute("AST", ast);
			request.setAttribute("msg", "Asset Not Assignedß");
			rd.forward(request, response);
		}

		// String msg = (String) request.getAttribute("msg");
		// ArrayList<Employee> list = (ArrayList<Employee>)
		// request.getAttribute("LIST_EMP");
		// Asset ast = (Asset) request.getAttribute("AST");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
