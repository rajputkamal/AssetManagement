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


@WebServlet("/updateAsset")
public class UpdateAsset extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		AssetModel am = new AssetModel();
		Asset ast = am.getAsset(name);
		
		if (ast != null) {
			RequestDispatcher rd = request.getRequestDispatcher("editAsset.jsp");
			request.setAttribute("AST", ast);
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String purDate = request.getParameter("purDate");
		String conNote = request.getParameter("conNote");
		String category = request.getParameter("category");
		String status = request.getParameter("status");
		
		System.out.println(name+"  "+purDate+"  "+conNote+"   "+category+"  "+status);
		
		Asset ast  = new Asset(name, purDate, conNote, category, status);
		AssetModel am = new AssetModel();
		int i = am.updateAsset(ast);
		
		ArrayList<Asset> list = am.getAllCategories();
		if (i != 0) {
			RequestDispatcher rd = request.getRequestDispatcher("listAssets.jsp");
			request.setAttribute("LIST", list);
			request.setAttribute("msg", "List Updated");
			rd.forward(request, response);
		}

	}

}
