/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myservlet;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mybean.class_bean;
import mybean.teacher_bean;

public class makework extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet makework</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet makework at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");   //解决乱码所必须的
        HttpSession ss = request.getSession(true);
        String tt = request.getParameter("work");
        String etime = request.getParameter("etime");
        FileWriter writer;

        String[] etimes = etime.split("\\-|\\s|:");//设置的截止时间
        etime = etimes[0] + "-" + etimes[1] + "-" + etimes[2] + "-" + etimes[3] + "-" + etimes[4] + "-" + etimes[5];

        SimpleDateFormat sdf = new SimpleDateFormat();//当前的系统时间
        sdf.applyPattern("yyyy-MM-dd-HH-mm-ss");
        Date date = new Date();
        String fileName = sdf.format(date) + "-" + etime + ".txt";//当前时间-截止时间作为文件名

        String mm = "work1";//查找一个空的文件夹
        String path = "d:/" + mm;
        File backfile = new File(path);
        if (backfile != null && backfile.exists() && backfile.isDirectory()) {
            File[] files = backfile.listFiles();
            if (files != null && files.length > 0) {
                mm = "work2";
            }
        }
        path = "d:/" + mm;
        backfile = new File(path);
        if (backfile != null && backfile.exists() && backfile.isDirectory()) {
            File[] files = backfile.listFiles();
            if (files != null && files.length > 0) {
                mm = "work3";
            }
        }

        teacher_bean tea = new teacher_bean();//获取文件路径
        class_bean cla = new class_bean();
        tea = (teacher_bean) ss.getAttribute("teacherbean");
        cla = (class_bean) ss.getAttribute("classbean");
        String tea_ID = tea.getTea_ID();
        String cou_ID = cla.getCou_ID();
        String cla_ID = cla.getClass_ID();

        String filePath = tea_ID + "/" + cou_ID + "/" + cla_ID + "/" + mm + "/" + fileName;//得到文件路径和名称组合

        try {
            writer = new FileWriter(filePath);//写文件
            writer.write(tt);
            writer.flush();
            writer.close();
        } catch (Exception e) {

        }
        PrintWriter out = response.getWriter();
        out.println("<html><body>发布成功<br><a href=\"Tea_Homepage.jsp\">返回主页</a></body></html>");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
