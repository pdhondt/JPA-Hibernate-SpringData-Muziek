package be.vdab.muziek.services;

import be.vdab.muziek.repositories.ArtiestRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ArtiestService {
    private final ArtiestRepository artiestRepository;

    public ArtiestService(ArtiestRepository artiestRepository) {
        this.artiestRepository = artiestRepository;
    }
}
