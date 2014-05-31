package br.edu.fema.view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.edu.fema.controller.MarcaJPA;
import br.edu.fema.controller.MarcaJpaController;
import br.edu.fema.model.Marca;
import br.edu.fema.util.JPAUtil;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author lucas
 */
@ManagedBean
@ViewScoped
public class MarcaMB {

    private List<Marca> marcas;
    private Marca marca;
    /**
     * Creates a new instance of MarcaMB
     */
    public MarcaMB() {
        this.marca = new Marca();
    }
    
    
    public void save(Marca marca) {
        MarcaJPA mJPA = new MarcaJpaController(JPAUtil.getEmf());
        mJPA.create(marca);
        this.marca = new Marca();
    }
    
    
    public List<Marca> getMarcas() {
        MarcaJPA mJPA = new MarcaJpaController(JPAUtil.getEmf());
        this.marcas = mJPA.findMarcaEntities();
        return marcas;
    }
    
    public void setMarcas(List<Marca> marcas) {
        //Ler as marcas no banco de dados
        this.marcas = marcas;
    }
    
    public Marca getMarca() {
        return marca;
    }
    
    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}
