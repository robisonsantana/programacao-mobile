package guy.voltaic.calcularformas.controller;

import guy.voltaic.calcularformas.model.Retangulo;

/*
 *@author:<Robison>
 *@ra:<1110482313007>
 */
public class RetanguloController implements IGeometriaController {

    @Override
    public float calcularArea(Object figura) {
        if (figura instanceof Retangulo) {
            Retangulo retangulo = (Retangulo) figura;
            return retangulo.getBase() * retangulo.getAltura();
        }
        return 0;
    }

    @Override
    public float calcularPerimetro(Object figura) {
        if (figura instanceof Retangulo) {
            Retangulo retangulo = (Retangulo) figura;
            return 2 * (retangulo.getBase() + retangulo.getAltura());
        }
        return 0;
    }
}
