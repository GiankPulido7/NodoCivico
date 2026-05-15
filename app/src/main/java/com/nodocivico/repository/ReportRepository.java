package com.nodocivico.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.nodocivico.models.Report;
import java.util.ArrayList;
import java.util.List;

/**
 * ReportRepository - Repositorio para reportes
 * Prepara arquitectura para Room Database
 * Actualmente usa datos simulados (mock)
 */
public class ReportRepository {

    private static ReportRepository instance;
    private final MutableLiveData<List<Report>> reportsLiveData;
    private List<Report> cachedReports;

    private ReportRepository() {
        reportsLiveData = new MutableLiveData<>();
        cachedReports = new ArrayList<>();
    }

    public static synchronized ReportRepository getInstance() {
        if (instance == null) {
            instance = new ReportRepository();
        }
        return instance;
    }

    /**
     * Obtiene todos los reportes
     * Simulado - más tarde se conectará con Room
     */
    public LiveData<List<Report>> getAllReports() {
        loadMockReports();
        reportsLiveData.setValue(cachedReports);
        return reportsLiveData;
    }

    /**
     * Crea un nuevo reporte
     */
    public void createReport(Report report, OnReportCreatedListener listener) {
        // Simular guardado
        new android.os.Handler().postDelayed(() -> {
            report.setId(cachedReports.size() + 1);
            report.setStatus("Pendiente");
            cachedReports.add(report);
            reportsLiveData.postValue(cachedReports);
            if (listener != null) {
                listener.onSuccess(report);
            }
        }, 500);
    }

    /**
     * Carga reportes de ejemplo
     */
    private void loadMockReports() {
        if (cachedReports.isEmpty()) {
            cachedReports.add(new Report(1, "Bache en calle principal", "Gran bache en la calle principal cerca del parque", "Infraestructura", "Alta", "Pendiente"));
            cachedReports.add(new Report(2, "Luz callejera dañada", "La luz del poste 45 no funciona desde hace una semana", "Servicios Públicos", "Media", "En proceso"));
            cachedReports.add(new Report(3, "Basura acumulada", "Hay basura acumulada en la esquina de las calles", "Limpieza", "Baja", "Resuelto"));
            cachedReports.add(new Report(4, "Fuga de agua", "Hay una fuga de agua en la calle lateral", "Infraestructura", "Alta", "Pendiente"));
            cachedReports.add(new Report(5, "Árbol caído", "Un árbol cayó bloqueando el paso", "Medio Ambiente", "Alta", "En proceso"));
        }
    }

    public interface OnReportCreatedListener {
        void onSuccess(Report report);
        void onError(String message);
    }
}