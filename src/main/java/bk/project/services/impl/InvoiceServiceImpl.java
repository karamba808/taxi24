package bk.project.services.impl;

import bk.project.domain.Invoice;
import bk.project.repositories.InvoiceRepository;
import bk.project.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    @Autowired
    private InvoiceRepository repository;

    @Override
    public Invoice create(Invoice invoice) {
        return repository.save(invoice);
    }

    @Override
    public List<Invoice> invoices() {
        return repository.findAll();
    }
}
