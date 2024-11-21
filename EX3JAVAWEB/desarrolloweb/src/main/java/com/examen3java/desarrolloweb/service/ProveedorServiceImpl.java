package com.examen3java.desarrolloweb.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen3java.desarrolloweb.Entity.Provedores;
import com.examen3java.desarrolloweb.repository.ProvedoresRepo;
import com.examen3java.desarrolloweb.repository.ProveedorRepo;

@Service
public class ProveedorServiceImpl implements ProveedorService {
    @Autowired
    private ProvedoresRepo proveedorRepo;

    @Override
    public List<Provedores> findAll() {
        return proveedorRepo.findAll();
    }

    @Override
    public Proveedor findById(Integer id) {
        return proveedorRepo.findById(id).orElse(null);
    }

    @Override
    public Proveedor save(Provedores proveedor) {
        return proveedorRepo.save(proveedor);
    }

    @Override
    public void deleteById(Integer id) {
        proveedorRepo.deleteById(id);
    }
}
