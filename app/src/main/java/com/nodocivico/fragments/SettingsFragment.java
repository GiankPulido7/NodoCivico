package com.nodocivico.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import com.nodocivico.R;
import com.nodocivico.databinding.FragmentSettingsBinding;

/**
 * SettingsFragment - Pantalla de configuración
 * Opciones: notificaciones, modo offline, cerrar sesión
 */
public class SettingsFragment extends Fragment {

    private FragmentSettingsBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSettingsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Configurar listeners
        setupListeners(view);
    }

    private void setupListeners(View view) {
        // Switch de notificaciones
        binding.switchNotifications.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Toast.makeText(requireContext(), "Notificaciones activadas", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(requireContext(), "Notificaciones desactivadas", Toast.LENGTH_SHORT).show();
            }
        });

        // Switch de modo offline
        binding.switchOffline.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Toast.makeText(requireContext(), "Modo offline activado", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(requireContext(), "Modo offline desactivado", Toast.LENGTH_SHORT).show();
            }
        });

        // Botón cerrar sesión
        binding.btnLogout.setOnClickListener(v -> {
            Toast.makeText(requireContext(), "Sesión cerrada", Toast.LENGTH_SHORT).show();
            // Navegar al login
            Navigation.findNavController(view).navigate(R.id.action_settingsFragment_to_loginFragment);
        });

        // Botón volver
        binding.toolbar.setNavigationOnClickListener(v ->
                requireActivity().onBackPressed());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}