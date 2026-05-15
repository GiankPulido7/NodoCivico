package com.nodocivico.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.nodocivico.R;
import com.nodocivico.adapters.ReportAdapter;
import com.nodocivico.databinding.FragmentReportListBinding;
import com.nodocivico.models.Report;

import java.util.ArrayList;
import java.util.List;

/**
 * ReportListFragment - Pantalla de lista de reportes
 * Muestra lista de reportes usando RecyclerView
 */
public class ReportListFragment extends Fragment {

    private FragmentReportListBinding binding;
    private ReportAdapter adapter;
    private List<Report> reportList;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentReportListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Inicializar lista de reportes
        initReportList();

        // Configurar RecyclerView
        setupRecyclerView();

        // Botón volver
        binding.toolbar.setNavigationOnClickListener(v ->
                requireActivity().onBackPressed());
    }

    private void initReportList() {
        reportList = new ArrayList<>();

        // Agregar reportes de ejemplo
        reportList.add(new Report(1, "Bache en calle principal", "Gran bache en la calle principal cerca del parque", "Infraestructura", "Alta", "Pendiente"));
        reportList.add(new Report(2, "Luz callejera dañada", "La luz del poste 45 no funciona desde hace una semana", "Servicios Públicos", "Media", "En proceso"));
        reportList.add(new Report(3, "Basura acumulada", "Hay basura acumulada en la esquina de las calles", "Limpieza", "Baja", "Resuelto"));
        reportList.add(new Report(4, "Fuga de agua", "Hay una fuga de agua en la calle lateral", "Infraestructura", "Alta", "Pendiente"));
        reportList.add(new Report(5, "Árbol caído", "Un árbol cayó bloqueando el paso", "Medio Ambiente", "Alta", "En proceso"));
    }

    private void setupRecyclerView() {
        adapter = new ReportAdapter(reportList);
        binding.recyclerViewReports.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.recyclerViewReports.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}