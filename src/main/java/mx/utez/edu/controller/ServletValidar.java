package mx.utez.edu.controller;

import mx.utez.edu.model.usuarios.UsuarioBean;
import mx.utez.edu.model.usuarios.UsuarioDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletValidar", value = "/ServletValidar")

public class ServletValidar extends HttpServlet {
    UsuarioBean userBean = new UsuarioBean();
    UsuarioDao userDao = new UsuarioDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if(accion.equalsIgnoreCase("Ingresar")) {
            String usuario = request.getParameter("txtuser");
            String contraseña = request.getParameter("txtpass");
            if(userDao.Validar()==1 && userBean.getUsuario()!=null && userBean.getContraseña()!=null) {
                userBean = userDao.Validar2(usuario,contraseña);
                request.getRequestDispatcher("ServletControlador?accion=principal").forward(request,response);
            }
            else {
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }
        }
        else{
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }
}
