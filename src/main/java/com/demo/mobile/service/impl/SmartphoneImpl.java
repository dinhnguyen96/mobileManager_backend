package com.demo.mobile.service.impl;

import com.demo.mobile.model.Smartphone;
import com.demo.mobile.repository.ISmartPhoneRepository;
import com.demo.mobile.service.ISmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SmartphoneImpl implements ISmartPhoneService
{
    @Autowired
    private ISmartPhoneRepository smartPhoneRepository;
    @Override
    public Iterable<Smartphone> findAll() {
        return smartPhoneRepository.findAll();
    }

    @Override
    public Optional<Smartphone> findById(Long id) {
        return smartPhoneRepository.findById(id);
    }

    @Override
    public Smartphone save(Smartphone smartPhone) {
        return smartPhoneRepository.save(smartPhone);
    }

    @Override
    public void remove(Long id)
    {
        smartPhoneRepository.deleteById(id);
    }
}
