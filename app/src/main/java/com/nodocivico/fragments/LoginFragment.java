package com.nodocivico.fragments;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import com.nodocivico.R;
import com.nodocivico.databinding.FragmentLoginBinding;

/**
 * LoginFragment - Pantalla de inicio de sesión
 * Valida credenciales y navega al HomeFragment
 */
public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Configurar botón de login
        binding.btnLogin.setOnClickListener(v -> validateLogin(view));
    }

    private void validateLogin(View view) {
        // Obtener valores de los campos
        String email = binding.etEmail.getText().toString().trim();
        String password = binding.etPassword.getText().toString().trim();

        // Validar campos vacíos
        if (TextUtils.isEmpty(email)) {
            binding.tilEmail.setError("El correo es requerido");
            return;
        } else {
            binding.tilEmail.setError(null);
        }

        if (TextUtils.isEmpty(password)) {
            binding.tilPassword.setError("La contraseña es requerida");
            return;
        } else {
            binding.tilPassword.setError(null);
        }

        // Validar formato de email
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.tilEmail.setError("Ingrese un correo válido");
            return;
        }

        // Validar longitud mínima de contraseña
        if (password.length() < 6) {
            binding.tilPassword.setError("La contraseña debe tener al menos 6 caracteres");
            return;
        }

        // Login exitoso - navegar al Home
        Toast.makeText(requireContext(), "Bienvenido a Nodo Cívico", Toast.LENGTH_SHORT).show();
        Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_homeFragment);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}