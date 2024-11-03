package guy.voltaic.calcularformas.controller;

import guy.voltaic.calcularformas.model.Circulo;

/*
 *@author:<Robison>
 *@ra:<1110482313007>
 */
public class CirculoController implements IGeometriaController {

    private static final float PI = 3.14159f;

    @Override
    public float calcularArea(Object figura) {
        if (figura instanceof Circulo) {
            Circulo circulo = (Circulo) figura;
            return PI * circulo.getRaio() * circulo.getRaio();
        }
        return 0;
    }

    @Override
    public float calcularPerimetro(Object figura) {
        if (figura instanceof Circulo) {
            Circulo circulo = (Circulo) figura;
            return 2 * PI * circulo.getRaio();
        }
        return 0;
    }
}

