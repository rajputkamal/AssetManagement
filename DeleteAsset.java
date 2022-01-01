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

@WebServlet("/deleteAsset")
public class DeleteAsset extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		AssetModel am = new AssetModel();
		String status = am.getAssignmentStatus(name);
		RequestDispatcher rd = null;
		ArrayList<Asset> list = am.getAllAssets();
		System.out.println(status);

		int i = 0;
		if (!(status.equals("assigned"))) {
			i = am.deleteAsset(name);
			if (i != 0) {
				list = am.getAllAssets();
				System.out.println("Going to list details...");
				rd = request.getRequestDispatcher("listAssets.jsp");
				request.setAttribute("LIST", list);
				request.setAttribute("msg", "Asset Deleted");
				rd.forward(request, response);
			}
		} else {
			list = am.getAllAssets();
			System.out.println("Going to list details...");
			rd = request.getRequestDispatcher("listAssets.jsp");
			request.setAttribute("LIST", list);
			request.setAttribute("msg", "Asset Can Not delete, It Is Assigned");
			rd.forward(request, response);
		}
		/*
		 * if (!(status.equals("assigned"))) { int i = am.deleteAsset(name); if (i != 0)
		 * { list = am.getAllAssets(); System.out.println("Going to list details...");
		 * rd = request.getRequestDispatcher("listAssets.jsp");
		 * request.setAttribute("LIST", list); request.setAttribute("msg",
		 * "Asset Deleted"); rd.forward(request, response); } else { rd =
		 * request.getRequestDispatcher("listAssets.jsp"); request.setAttribute("msg",
		 * "Something Went Wrong.. Record Not Deleted"); rd.forward(request, response);
		 * } } else { rd = request.getRequestDispatcher("listAssets.jsp");
		 * request.setAttribute("LIST", list); request.setAttribute("msg",
		 * "Assets Assigned, It Can Not Delete"); rd.forward(request, response); }
		 */
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
