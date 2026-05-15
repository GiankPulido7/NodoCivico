package com.nodocivico.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import com.nodocivico.R;
import com.nodocivico.databinding.FragmentHomeBinding;

/**
 * HomeFragment - Pantalla principal
 * Muestra opciones de navegación: reportes, crear, perfil, configuración
 */
public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Configurar click listeners para las tarjetas
        setupClickListeners(view);
    }

    private void setupClickListeners(View view) {
        // Ver reportes - navegar a lista de reportes
        binding.cardReports.setOnClickListener(v ->
                Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_reportListFragment));

        // Crear reporte - navegar a crear reporte
        binding.cardCreateReport.setOnClickListener(v ->
                Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_createReportFragment));

        // Perfil - navegar a perfil
        binding.cardProfile.setOnClickListener(v ->
                Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_profileFragment));

        // Configuración - navegar a configuración
        binding.cardSettings.setOnClickListener(v ->
                Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_settingsFragment));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}