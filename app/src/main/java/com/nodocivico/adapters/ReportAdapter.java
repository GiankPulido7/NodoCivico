package com.nodocivico.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.nodocivico.R;
import com.nodocivico.databinding.ItemReportBinding;
import com.nodocivico.models.Report;
import java.util.List;

/**
 * ReportAdapter - Adapter para RecyclerView de reportes
 * Administra la lista de reportes y su renderizado
 */
public class ReportAdapter extends RecyclerView.Adapter<ReportAdapter.ReportViewHolder> {

    private List<Report> reportList;
    private OnReportClickListener listener;

    public interface OnReportClickListener {
        void onReportClick(Report report);
    }

    public ReportAdapter(List<Report> reportList) {
        this.reportList = reportList;
    }

    public ReportAdapter(List<Report> reportList, OnReportClickListener listener) {
        this.reportList = reportList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ReportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemReportBinding binding = ItemReportBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new ReportViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ReportViewHolder holder, int position) {
        Report report = reportList.get(position);
        holder.bind(report);
    }

    @Override
    public int getItemCount() {
        return reportList != null ? reportList.size() : 0;
    }

    class ReportViewHolder extends RecyclerView.ViewHolder {
        private final ItemReportBinding binding;

        public ReportViewHolder(@NonNull ItemReportBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Report report) {
            binding.tvReportTitle.setText(report.getTitle());
            binding.tvReportCategory.setText(report.getCategory());
            binding.tvReportPriority.setText(report.getPriority());
            binding.tvReportStatus.setText(report.getStatus());

            // Color del estado
            int statusColor = getStatusColor(report.getStatus());
            binding.tvReportStatus.setTextColor(statusColor);

            // Color de prioridad
            int priorityColor = getPriorityColor(report.getPriority());
            binding.tvReportPriority.setTextColor(priorityColor);

            // Click listener
            if (listener != null) {
                itemView.setOnClickListener(v -> listener.onReportClick(report));
            }
        }

        private int getStatusColor(String status) {
            switch (status) {
                case "Pendiente":
                    return itemView.getContext().getColor(R.color.status_pending);
                case "En proceso":
                    return itemView.getContext().getColor(R.color.status_in_progress);
                case "Resuelto":
                    return itemView.getContext().getColor(R.color.status_resolved);
                default:
                    return itemView.getContext().getColor(R.color.status_default);
            }
        }

        private int getPriorityColor(String priority) {
            switch (priority) {
                case "Alta":
                    return itemView.getContext().getColor(R.color.priority_high);
                case "Media":
                    return itemView.getContext().getColor(R.color.priority_medium);
                case "Baja":
                    return itemView.getContext().getColor(R.color.priority_low);
                default:
                    return itemView.getContext().getColor(R.color.priority_default);
            }
        }
    }
}