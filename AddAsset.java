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

@WebServlet("/addAsset")
public class AddAsset extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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

		int i = am.addAsset(ast);
		RequestDispatcher rd = request.getRequestDispatcher("addAssets.jsp");
		if (i != 0) {
			request.setAttribute("msg", "success");
		} else {
			request.setAttribute("msg", "fail");
		}
		rd.forward(request, response);
	}

}