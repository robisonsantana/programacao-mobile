package guy.voltaic.salarycalcprofs.model;

/*
 *@author:<Robison>
 *@ra:<1110482313007>
 */
public class ProfessorHoristico extends Professor{

    public ProfessorHoristico() {
        super();
    }

    @Override
    public double calcSalario(double horaAula, int valorHoraAula) {
        return horaAula * valorHoraAula;
    }
}
