/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import controllers.CompteFacade;
import controllers.CompteFacadeLocal;
import controllers.OperationFacade;
import controllers.OperationFacadeLocal;
import entities.Compte;
import entities.Operation;
import java.util.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Vector;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import exception.*;
import java.math.BigDecimal;

/**
 *
 * @author lemec
 */
@Stateless
public class GestionComptes implements GestionComptesLocal {

    @EJB
    private OperationFacadeLocal operationFacade;

    @EJB
    private CompteFacadeLocal compteFacade;

    
    @Override
    public Compte find(long NoCompte) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float positionCompte(long NoCompte) {
    float resultat = 0;
            Vector<Operation> vct= GetOperationFromCompte(NoCompte);
            Operation opt;
            for (int i=0; i<vct.size();i++){
                opt = vct.get(i);
                if (opt.getType()=="Crédit"){
                    resultat+= opt.getSomme().floatValue();
                };
                if (opt.getType()=="Débit"){
                    resultat-= opt.getSomme().floatValue();
                };
            }
            return resultat;        
    }
        public Vector<Operation> GetOperationFromCompte(long Id){

          
          List<Operation> ListeOperation = operationFacade.findAll();
          Vector<Operation> resultat = new Vector<Operation>();
          int taille = ListeOperation.size();
          Operation opt;
          for (int i=0; i<taille;i++){
              opt=ListeOperation.get(i);
              if (opt.getCompteid().getId()==Id){
                  resultat.add(opt);
          }}
              
          return resultat;
        }
     @Override
        public Operation debiter(long NoCompte, float montantCommande) throws Exception{
             
            Compte cpt = find(NoCompte);
            
            float solde = this.positionCompte(NoCompte);
            if (solde<montantCommande){
              throw new SoldeInsuffisantException();
            }
            Operation opt = new Operation();
            opt.setCompteid(cpt);
            opt.setDate(new Date());
            opt.setSomme(BigDecimal.valueOf(opt.getSomme().doubleValue()-new Double(montantCommande)));
            opt.setType("Débit");
            operationFacade.create(opt);
        return  opt;
        }
        @Override
       public Operation crediter(long NoCompte, float montantCredite) throws Exception{
             Compte cpt = find(NoCompte);
            
            float solde = this.positionCompte(NoCompte);
            if (0 <montantCredite){
              throw new Exception("Montant Crédité Négatif");
            }
            Operation opt = new Operation();
            opt.setCompteid(cpt);
            opt.setDate(new Date());
            opt.setSomme(BigDecimal.valueOf(opt.getSomme().floatValue()+montantCredite));
            opt.setType("Crédit");
            operationFacade.create(opt);
            return opt;
        }


 
}
