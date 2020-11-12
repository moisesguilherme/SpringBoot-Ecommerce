package org.una.sdm.aula09.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.sdm.aula09.domain.Cliente;
import org.una.sdm.aula09.exceptions.ClienteWithSameCpfAlreadyExistException;
import org.una.sdm.aula09.exceptions.ClienteNotFoundException;
import org.una.sdm.aula09.exceptions.ClienteWithoutCpfException;
import org.una.sdm.aula09.repositories.ClienteRepositoryJPA;
import org.una.sdm.aula09.services.interfaces.ClienteServiceAPI;

import java.util.List;

@Service
public class ClienteService implements ClienteServiceAPI {

    @Autowired
    private ClienteRepositoryJPA repositoryJPA;


    @Override
    @Transactional(readOnly = true)
    public Cliente get(Long id) {
        try {
            Cliente cliente = repositoryJPA.findById(id).get();
            return cliente;
        } catch (Exception ex){
            throw new ClienteNotFoundException(ex.getMessage());
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        List<Cliente> clientes = repositoryJPA.findAll();
        return clientes;
    }

    @Override
    @Transactional
    public Cliente create(Cliente cliente) {

        if(cliente.getCpf() == null) {
            throw new ClienteWithoutCpfException("Não é possível registrar cliente sem o cpf!");
        }
        Cliente clienteBuscado = repositoryJPA.findByCpf(cliente.getCpf());
        if(clienteBuscado != null) {
            throw new ClienteWithSameCpfAlreadyExistException("Não é possível registrar dois clientes com o mesmo cpf!");
        }
        return repositoryJPA.save(cliente);
    }

    @Override
    @Transactional
    public void update(Cliente cliente) {
        repositoryJPA.save(cliente);
    }

    @Override
    @Transactional
    public void remove(Long id) {
        repositoryJPA.deleteById(id);
    }
}
