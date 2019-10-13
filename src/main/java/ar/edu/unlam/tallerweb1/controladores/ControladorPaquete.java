package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.servicios.ServicioPaquete;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;

@Controller
public class ControladorPaquete {

    @Inject
    private ServicioPaquete servicioPaquete;

    @RequestMapping("/paquete")
    public ModelAndView irAPaquete() {
        return new ModelAndView("paquete");
    }

    @RequestMapping("/paquete/{direccion}/{codSeguimiento}/{medioDeTransporte}")
    public ModelAndView cargarPaquete(@PathVariable String direccion, @PathVariable String codSeguimiento, @PathVariable String medioDeTransporte) {
        ModelMap modelo = new ModelMap();

        modelo.put("direccion", direccion);
        modelo.put("codSeguimiento", codSeguimiento);
        modelo.put("medioDeTransporte", medioDeTransporte);

        return new ModelAndView("informacionPaquete", modelo);
    }
}
