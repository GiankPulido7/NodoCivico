package com.nodocivico.fragments;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.nodocivico.R;
import com.nodocivico.databinding.FragmentCreateReportBinding;

/**
 * CreateReportFragment - Pantalla para crear nuevo reporte
 * Formulario con título, descripción, categoría y prioridad
 */
public class CreateReportFragment extends Fragment {

    private FragmentCreateReportBinding binding;

    // Opciones de categorías
    private String[] categories = {"Infraestructura", "Servicios Públicos", "Limpieza", "Medio Ambiente", "Seguridad"};
    private String[] priorities = {"Baja", "Media", "Alta"};

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCreateReportBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Configurar spinners
        setupSpinners();

        // Botón guardar
        binding.btnSaveReport.setOnClickListener(v -> validateAndSaveReport());

        // Botón volver
        binding.toolbar.setNavigationOnClickListener(v ->
                requireActivity().onBackPressed());
    }

    private void setupSpinners() {
        // Spinner de categorías
        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<>(
                requireContext(),
                android.R.layout.simple_spinner_item,
                categories
        );
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinnerCategory.setAdapter(categoryAdapter);

        // Spinner de prioridades
        ArrayAdapter<String> priorityAdapter = new ArrayAdapter<>(
                requireContext(),
                android.R.layout.simple_spinner_item,
                priorities
        );
        priorityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinnerPriority.setAdapter(priorityAdapter);
    }

    private void validateAndSaveReport() {
        // Obtener valores
        String title = binding.etTitle.getText().toString().trim();
        String description = binding.etDescription.getText().toString().trim();
        String category = binding.spinnerCategory.getSelectedItem().toString();
        String priority = binding.spinnerPriority.getSelectedItem().toString();

        // Validar título
        if (TextUtils.isEmpty(title)) {
            binding.tilTitle.setError("El título es requerido");
            return;
        } else {
            binding.tilTitle.setError(null);
        }

        // Validar descripción
        if (TextUtils.isEmpty(description)) {
            binding.tilDescription.setError("La descripción es requerida");
            return;
        } else {
            binding.tilDescription.setError(null);
        }

        // Validar longitud mínima de descripción
        if (description.length() < 20) {
            binding.tilDescription.setError("La descripción debe tener al menos 20 caracteres");
            return;
        }

        // Guardar reporte (simulado)
        saveReport(title, description, category, priority);
    }

    private void saveReport(String title, String description, String category, String priority) {
        // Aquí iría la lógica de guardado con Room/Repository
        // Por ahora solo mostramos un Toast
        Toast.makeText(requireContext(),
                "Reporte creado exitosamente:\n" +
                        "Título: " + title + "\n" +
                        "Categoría: " + category + "\n" +
                        "Prioridad: " + priority,
                Toast.LENGTH_LONG).show();

        // Limpiar formulario
        clearForm();

        // Volver a la pantalla anterior
        requireActivity().onBackPressed();
    }

    private void clearForm() {
        binding.etTitle.setText("");
        binding.etDescription.setText("");
        binding.spinnerCategory.setSelection(0);
        binding.spinnerPriority.setSelection(0);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}