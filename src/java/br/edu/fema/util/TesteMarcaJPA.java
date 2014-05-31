/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.fema.util;

import br.edu.fema.controller.MarcaJPA;
import br.edu.fema.controller.MarcaJpaController;
import br.edu.fema.model.Marca;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class TesteMarcaJPA {
    
    public static void main(String[] args){
        Marca m = new Marca();
        m.setNome("Ford");
        MarcaJPA mJPA = new MarcaJpaController(JPAUtil.getEmf());
        try {
            mJPA.create(m);
            JOptionPane.showMessageDialog(null, "Marca salva, id=" + m.getId());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro 1 -" + ex.getMessage());
        }
     
        // Leitura de marca
        Marca mLida = mJPA.findMarca(m.getId());
        JOptionPane.showMessageDialog(null, "Marca lida, id=" + mLida.getId()
                + "\nNome= " + mLida.getNome());

        // Alteração de marca
        try {
            mLida.setNome("Novo");
            mJPA.edit(mLida);
            JOptionPane.showMessageDialog(null, "Marca alterada, id=" + mLida.getId()
                    + "\nNome= " + mLida.getNome());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro 2 -" + ex.getMessage());
        }
        /*
        // Exclusao de marca
        try {
            mJPA.destroy(mLida.getId());
            JOptionPane.showMessageDialog(null, "Marca excluida, id=" + mLida.getId()
                    + "\nNome= " + mLida.getNome());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro 3 -" + ex.getMessage());
        } 
                */
    }
    
}
