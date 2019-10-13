package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Cadete;
import ar.edu.unlam.tallerweb1.servicios.ServicioCadete;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ControladorCadete {
    @Inject
    private ServicioCadete servicioCadete;

    @RequestMapping("/registrarcadete")
    public ModelAndView registrarCadete() {
        Cadete cadete = new Cadete();
        ModelMap modelo = new ModelMap();
        modelo.put("cadete", cadete);

        return new ModelAndView("registrarCadete", modelo);
    }

    @RequestMapping(path = "/validar-cadete", method = RequestMethod.POST)
    public ModelAndView validarCadete(@ModelAttribute("cadete") Cadete cadete, HttpServletRequest request) {
        ModelMap modelo = new ModelMap();
        boolean cadeteExiste = servicioCadete.existeCadete(cadete.getEmail());

        if (!cadeteExiste) {
            servicioCadete.altaCadete(cadete);
            return new ModelAndView("redirect:/home");
        } else {

            return new ModelAndView("redirect:/registrarcadete");
        }
    }

    @RequestMapping("/cadete")
    public ModelAndView irACadete() {
        return new ModelAndView("cadete");
    }

    @RequestMapping("/cadete/{dni}/{nombre}/{apellido}")
    public ModelAndView cargarCadete(@PathVariable Integer dni, @PathVariable String nombre, @PathVariable String apellido) {
        ModelMap modelo = new ModelMap();

        modelo.put("dni", dni);
        modelo.put("nombre", nombre);
        modelo.put("apellido", apellido);

        return new ModelAndView("informacionCadete", modelo);
    }
}
