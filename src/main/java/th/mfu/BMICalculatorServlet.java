package th.mfu;

import java.io.IOException;
import java.math.BigDecimal;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//TODO: add webservlet to "/calbmi"
@WebServlet(urlPatterns = "/calbmi")
public class BMICalculatorServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO: get parameter from request: "weight" and "height"
        double weight = Double.parseDouble(request.getParameter("weight"));
        double height = Double.parseDouble(request.getParameter("height"));
        //TODO: calculate bmi
        int bmi = (int)Math.round((weight / (height*height)));
        String bmiStg;
      

        /*      
  BMI < 18.5 : underweight
    - 18.5 <= BMI < 25 : normal
    - 25 <= BMI < 30 : overweight
    - 30 <= BMI < 35 : obese
    - BMI >= 35 : extremely obese
 */
        //TODO: determine the built from BMI
      if(bmi >= 35)
      {
        bmiStg = "extremely obese";
      }
      else if(bmi >=30)
      {
        bmiStg = "obese";
      }
      else if(bmi >=25)
      {
        bmiStg = "overweight";
      }
      else if (bmi >= 18.5)
      {
        bmiStg ="normal";
      }
      else 
      {
        bmiStg = "Underweight";
      }
        //TODO: add bmi and built to the request's attribute
        request.setAttribute("bmiStg",bmiStg );
        request.setAttribute("bmi", bmi);
        //TODO: forward to jsp
        request.getRequestDispatcher("/bmi_result.jsp").forward(request, response);;

           
    }
    
}
