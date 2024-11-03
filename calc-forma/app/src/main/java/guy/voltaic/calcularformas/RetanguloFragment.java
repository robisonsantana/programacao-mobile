package guy.voltaic.calcularformas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import guy.voltaic.calcularformas.controller.RetanguloController;
import guy.voltaic.calcularformas.model.Retangulo;

/*
 *@author:<Robison>
 *@ra:<1110482313007>
 */
public class RetanguloFragment extends Fragment {

    private EditText etBase, etAltura;
    private TextView tvResultado;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_retangulo, container, false);

        etBase = view.findViewById(R.id.et_base);
        etAltura = view.findViewById(R.id.et_altura);
        tvResultado = view.findViewById(R.id.tv_resultado_retangulo);

        RetanguloController controller = new RetanguloController();

        Button btnCalcularArea = view.findViewById(R.id.btn_calcular_area_retangulo);
        btnCalcularArea.setOnClickListener(v -> {
            float base = Float.parseFloat(etBase.getText().toString());
            float altura = Float.parseFloat(etAltura.getText().toString());
            Retangulo retangulo = new Retangulo();
            retangulo.setBase(base);
            retangulo.setAltura(altura);
            float area = controller.calcularArea(retangulo);
            tvResultado.setText("Área: " + area);
            etBase.setText("");
            etAltura.setText("");
        });

        Button btnCalcularPerimetro = view.findViewById(R.id.btn_calcular_perimetro_retangulo);
        btnCalcularPerimetro.setOnClickListener(v -> {
            float base = Float.parseFloat(etBase.getText().toString());
            float altura = Float.parseFloat(etAltura.getText().toString());
            Retangulo retangulo = new Retangulo();
            retangulo.setBase(base);
            retangulo.setAltura(altura);
            float perimetro = controller.calcularPerimetro(retangulo);
            tvResultado.setText("Perímetro: " + perimetro);
            etBase.setText("");
            etAltura.setText("");
        });

        return view;
    }
}