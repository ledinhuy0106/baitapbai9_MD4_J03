// Hi.java (hoặc DiscountServlet.java)
package com.example.demo3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/display-discount")
public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy các dữ liệu từ form
        String productDescription = request.getParameter("productDescription");
        double listPrice = Double.parseDouble(request.getParameter("listPrice"));
        double discountPercent = Double.parseDouble(request.getParameter("discountPercent"));

        // Tính toán chiết khấu
        double discountAmount = listPrice * discountPercent * 0.01;
        double discountPrice = listPrice - discountAmount;

        // Hiển thị kết quả
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Discount Result</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Discount Result</h1>");
        out.println("<p><strong>Product Description:</strong> " + productDescription + "</p>");
        out.println("<p><strong>List Price:</strong> $" + listPrice + "</p>");
        out.println("<p><strong>Discount Percent:</strong> " + discountPercent + "%</p>");
        out.println("<p><strong>Discount Amount:</strong> $" + discountAmount + "</p>");
        out.println("<p><strong>Discount Price:</strong> $" + discountPrice + "</p>");
        out.println("</body>");
        out.println("</html>");
    }

}
