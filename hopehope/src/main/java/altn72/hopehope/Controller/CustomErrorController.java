package altn72.hopehope.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, HttpServletResponse response, Model model) {
        Object status = request.getAttribute("javax.servlet.error.status_code");

        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());

            if (statusCode == 404) {
                try {
                    response.sendRedirect("/api/excel/view");
                    return null;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            model.addAttribute("statusCode", statusCode);

            switch (statusCode) {
                case 500:
                    model.addAttribute("message", "Une erreur interne du serveur s'est produite.");
                    break;
                case 403:
                    model.addAttribute("message", "Accès refusé à cette ressource.");
                    break;
                default:
                    model.addAttribute("message", "Une erreur inattendue s'est produite.");
                    break;
            }
        } else {
            model.addAttribute("statusCode", "Unknown");
            model.addAttribute("message", "Erreur inconnue.");
        }

        return "error";
    }
}
