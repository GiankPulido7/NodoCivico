package com.nodocivico.fragments;

import android.os.Handler;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import com.nodocivico.R;
import com.nodocivico.databinding.FragmentSplashBinding;

/**
 * SplashFragment - Pantalla de carga inicial
 * Muestra el logo y nombre de la app durante 2 segundos
 */
public class SplashFragment extends Fragment {

    private FragmentSplashBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSplashBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Simular carga por 2 segundos y navegar al Login
        new Handler().postDelayed(() -> {
            Navigation.findNavController(view).navigate(R.id.action_splashFragment_to_loginFragment);
        }, 2000);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}