package guy.voltaic.salarycalcprofs.model;

/*
 *@author:<Robison>
 *@ra:<1110482313007>
 */
public class ProfessorTitular extends Professor{

    public ProfessorTitular() {
        super();
    }

    @Override
    public double calcSalario(double salario, int anosInstituicao) {
        if (anosInstituicao < 5) {
            return salario;
        } else {
            salario *= 1.05;
            return calcSalario(salario, anosInstituicao - 5);
        }
    }
}
