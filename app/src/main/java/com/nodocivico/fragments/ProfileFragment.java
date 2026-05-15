package com.nodocivico.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.nodocivico.R;
import com.nodocivico.databinding.FragmentProfileBinding;
import com.nodocivico.models.User;

/**
 * ProfileFragment - Pantalla de perfil del usuario
 * Muestra información del usuario: nombre, correo, rol comunitario
 */
public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;
    private User currentUser;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Cargar datos del usuario (simulado)
        loadUserData();

        // Botón volver
        binding.toolbar.setNavigationOnClickListener(v ->
                requireActivity().onBackPressed());
    }

    private void loadUserData() {
        // Crear usuario de ejemplo
        currentUser = new User(1, "Juan Pérez", "juan.perez@email.com", "Coordinador Vecinal");

        // Mostrar datos en la vista
        binding.tvUserName.setText(currentUser.getName());
        binding.tvUserEmail.setText(currentUser.getEmail());
        binding.tvUserRole.setText(currentUser.getRole());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}