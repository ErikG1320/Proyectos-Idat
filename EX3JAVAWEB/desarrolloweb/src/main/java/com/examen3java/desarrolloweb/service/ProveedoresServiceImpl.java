package com.examen3java.desarrolloweb.service;

import com.examen3java.desarrolloweb.Entity.Provedores;
import com.examen3java.desarrolloweb.repository.ProveedoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProveedoresServiceImpl implements ProveedoresService {

    @Autowired
    private ProveedoresRepository proveedoresRepository;

    @Override
    public List<Provedores> findAll() {
        return proveedoresRepository.findAll();
    }

    @Override
    public Provedores findById(Long id) {
        return proveedoresRepository.findById(id).orElse(null);
    }

    @Override
    public Provedores save(Provedores proveedor) {
        return proveedoresRepository.save(proveedor);
    }

    @Override
    public void deleteById(Long id) {
        proveedoresRepository.deleteById(id);
    }

    @Override
    public List<Provedores> findByPais(String pais) {
        return proveedoresRepository.findByPais(pais);
    }

    @Override
    public List<Provedores> findByEstado(String estado) {
        return proveedoresRepository.findByEstado(estado);
    }

    @Override
    public List<Provedores> findByMontoCredito(BigDecimal monto) {
        return proveedoresRepository.findByMontoCreditoGreaterThanEqual(monto);
    }

    @Override
    public List<Provedores> buscarPorNombreYPais(String nombredistribuidor, String pais) {
        if (nombredistribuidor != null && pais != null) {
            return proveedoresRepository.findByNombredistribuidorContainingAndPais(nombredistribuidor, pais);
        } else if (nombredistribuidor != null) {
            return proveedoresRepository.findByNombredistribuidorContaining(nombredistribuidor);
        } else if (pais != null) {
            return proveedoresRepository.findByPais(pais);
        }
        return findAll();
    }
}
