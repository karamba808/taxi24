package bk.project.services;

import bk.project.domain.Invoice;

import java.util.List;

public interface InvoiceService {
    public Invoice create(Invoice invoice);
    public List<Invoice> invoices();
}
