package question3;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;
import java.util.ListIterator;
public class Pile2<T> implements PileI<T>{
    /** par d�l�gation : utilisation de la class Stack */
    private Stack<T> stk;
    /** la capacit� de la pile */
    private int capacite;

    /** Cr�ation d'une pile.
     * @param taille la "taille maximale" de la pile, doit �tre > 0
     */
    public Pile2(int taille){
        // � compl�ter
        if(taille<=0) 
            taille = CAPACITE_PAR_DEFAUT;
        capacite = taille;
        stk = new Stack<T>();
    }

    public Pile2(){
        // � compl�ter
        this(0);
    }

    public void empiler(T o) throws PilePleineException{
        // � compl�ter
        if(stk.size()>=this.capacite) throw new PilePleineException();
        
        stk.push(o); 
    }

    public T depiler() throws PileVideException{
        // � compl�ter
        if(stk.empty()) throw new PileVideException();
        
        return stk.pop();
    }

    public T sommet() throws PileVideException{
        // � compl�ter
        if(stk.empty()) throw new PileVideException();
        return stk.peek();
    }

    // recopier ici toutes les autres m�thodes
    // qui ne sont pas modifi�es en fonction
    // du type des �l�ments de la pile
    public int capacite(){
        return this.capacite();
    }
    public int taille(){
        return stk.size();
    }
    public boolean estVide(){
         return stk.empty();
    }
    public boolean estPleine(){
        return stk.size() == capacite;
    }
    public boolean equals(Object o){
        if(! (o instanceof PileI) ) return false;
        Pile2<T> op = (Pile2<T>)o;
        if(op.taille() != this.taille()) return false;
        if(op.capacite() != this.capacite()) return false; 
        return op.toString().equals(o.toString());
    }
    public String toString(){
       ListIterator<T> stkIterator = stk.listIterator(this.taille());
       String res = "[";
       while(stkIterator.hasPrevious())
       {
           res+= stkIterator.previous();
           if (stkIterator.hasPrevious())
           {
               res+=", ";
            }
        }
        
        res += "]";
        return res;
    }
} // Pile2