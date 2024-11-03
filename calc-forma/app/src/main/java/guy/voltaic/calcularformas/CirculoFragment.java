package guy.voltaic.calcularformas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import guy.voltaic.calcularformas.controller.CirculoController;
import guy.voltaic.calcularformas.model.Circulo;

/*
 *@author:<Robison>
 *@ra:<1110482313007>
 */
public class CirculoFragment extends Fragment {

    private EditText etRaio;
    private TextView tvResultado;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_circulo, container, false);

        etRaio = view.findViewById(R.id.et_raio);
        tvResultado = view.findViewById(R.id.tv_resultado_circulo);

        CirculoController controller = new CirculoController();

        Button btnCalcularArea = view.findViewById(R.id.btn_calcular_area_circulo);
        btnCalcularArea.setOnClickListener(v -> {
            float raio = Float.parseFloat(etRaio.getText().toString());
            Circulo circulo = new Circulo();
            circulo.setRaio(raio);
            float area = controller.calcularArea(circulo);
            tvResultado.setText("Área: " + area);
            etRaio.setText("");
        });

        Button btnCalcularPerimetro = view.findViewById(R.id.btn_calcular_perimetro_circulo);
        btnCalcularPerimetro.setOnClickListener(v -> {
            float raio = Float.parseFloat(etRaio.getText().toString());
            Circulo circulo = new Circulo();
            circulo.setRaio(raio);
            float perimetro = controller.calcularPerimetro(circulo);
            tvResultado.setText("Perímetro: " + perimetro);
            etRaio.setText("");
        });

        return view;
    }
}